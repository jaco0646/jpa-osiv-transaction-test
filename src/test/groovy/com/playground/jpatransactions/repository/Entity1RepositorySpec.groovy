package com.playground.jpatransactions.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import spock.lang.Specification

@DataJpaTest
class Entity1RepositorySpec extends Specification {
    @Autowired
    Entity1Repository repo

    def "test viewByID"() {
        expect:
            repo.viewByID(1).getNumberOne()
    }
}
