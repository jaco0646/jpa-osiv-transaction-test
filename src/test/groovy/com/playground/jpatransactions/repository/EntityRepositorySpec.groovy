package com.playground.jpatransactions.repository

import com.playground.jpatransactions.data.MyEntity
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

    def "test when MyEntity does not implement the DTO"() {
        given:
            def dto = repo.findUnrelatedInterfaceById(1)
        expect:
            dto.getClass() != MyEntity
            dto.getFoo()
    }

    def "test when MyEntity implements the DTO"() {
        when:
            def dto = repo.findSuperInterfaceById(1)
        then:
            def e = thrown(ConversionFailedException)
            e.message.contains('Failed to convert from type [java.lang.Object[]]')
    }
}
