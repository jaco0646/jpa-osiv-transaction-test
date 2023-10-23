package com.playground.jpatransactions.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * This test fails when OSIV == true.
 */
@SpringBootTest(properties = ['spring.jpa.open-in-view=false'])
@AutoConfigureMockMvc
class MyControllerSpec extends Specification {
    @Autowired
    MockMvc mockMvc

    def "test incrementByID"() {
        expect:
            mockMvc.perform(get('/1'))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.numberOne').value('1'))
                .andExpect(jsonPath('$.numberTwo').value('2'))
        and:
            mockMvc.perform(post('/1/increment?times=5'))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.numberOne').value('6'))
                .andExpect(jsonPath('$.numberTwo').value('7'))
    }
}
