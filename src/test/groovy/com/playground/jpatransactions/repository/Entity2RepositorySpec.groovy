package com.playground.jpatransactions.repository

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Shared
import spock.lang.Specification

@DataJpaTest
class Entity2RepositorySpec extends Specification {
    @Autowired
    Entity2Repository repo

    @Shared
    ObjectMapper jackson = new ObjectMapper()

    def "test 'get' prefix"() {
        expect:
            verifyAll(repo.prefixWithGet(1)) {
                it.getB1()
                it.getB2()
            }
    }

    def "test 'is' prefix"() {
        given:
            def dto = repo.prefixWithGetIs(1)
            def json = jackson.writeValueAsString(dto)
        expect:
            verifyAll(dto) {
                it.isB1
                it.isB2
            }
        and:
            json.contains('"isB1":true')
            json.contains('"isB2":true')
    }

    def "test 'is' prefix"() {
        given:
            def dto = repo.prefixWithIs(1)
        expect:
            dto.isB1()
            dto.getB2()
        when:
            dto.isB2()
        then:
            def e = thrown(IllegalArgumentException)
            e.message.startsWith('Invoked method ')
            e.message.endsWith(' is no accessor method')
    }

}
