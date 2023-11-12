package com.playground.jpatransactions.repository

import com.playground.jpatransactions.data.MyEntity
import com.playground.jpatransactions.data.SuperInterfaceDTO
import com.playground.jpatransactions.data.UnrelatedInterfaceDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.core.convert.ConversionFailedException
import spock.lang.Specification

@DataJpaTest
class EntityRepositorySpec extends Specification {
    @Autowired
    EntityRepository repo

    @Autowired
    Entity1Repository repo1

    def "test viewByID"() {
        expect:
            repo1.viewByID(1).getNumberOne()
    }

    def "test JPA Query Projection - unrelated interface"() {
        given:
            def dto = repo.findJpaFieldsById(1)
        expect:
            dto.getClass() != MyEntity
            dto.getFoo()
            dto.getBar() == 'owt'
    }

    def "test Native Query Projection - unrelated interface"() {
        given:
            def dto = repo.findUnrelatedInterfaceById(1)
        expect:
            dto.getClass() != MyEntity
            dto.getFoo()
            dto.getBar() == 'two'
    }

    def "test Native Query Projection - super interface"() {
        when:
            def dto = repo.findSuperInterfaceById(1)
        then:
            def e = thrown(ConversionFailedException)
            e.message.contains('Failed to convert from type [java.lang.Object[]]')
    }

    def "test Dynamic Projection - unrelated interface"() {
        given:
            def dto = repo.findById(1, UnrelatedInterfaceDTO)
        expect:
            dto.getClass() != MyEntity
            dto.getFoo()
    }

    def "test Dynamic Projection - super interface"() {
        given:
            def dto = repo.findById(1, SuperInterfaceDTO)
        expect:
            dto.getClass() == MyEntity
            dto.getFoo()
    }

    def "test Tuple Projection"() {
        given:
            def dto = repo.findTupleById(1)
        expect:
            dto.get('foo')
    }

    def "test Tuple Collection"() {
        given:
            def foos = repo.findFoosByIDs([1, 2])
        expect:
            foos.get(1) == 'one'
            foos.get(2) == 'three'
    }
}
