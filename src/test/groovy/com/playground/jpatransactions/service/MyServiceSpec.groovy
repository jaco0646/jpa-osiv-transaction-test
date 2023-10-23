package com.playground.jpatransactions.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

@SpringBootTest(webEnvironment = NONE)
class MyServiceSpec extends Specification {
    @Autowired
    MyService service

    def "test getEntity1"() {
        expect:
            service.getEntity1(1).getNumberOne()
    }
}
