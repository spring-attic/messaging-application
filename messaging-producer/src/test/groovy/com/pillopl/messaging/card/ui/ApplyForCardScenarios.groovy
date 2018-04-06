package com.pillopl.messaging.card.ui

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import spock.lang.Specification

/**
 * @author Jakub Pilimon
 */
@SpringBootTest
class ApplyForCardScenarios extends Specification {

    @Autowired CreditCardApplicationController cardApplicationController

    def 'should be able to get card when born in 70s or later'() {
        when:
            ResponseEntity response = cardApplicationController.applyForCard(new CardApplication("70345678"))
        then:
            response.statusCode.is2xxSuccessful()
    }

    def 'should  not be able to get card when born before 70s'() {
        when:
            ResponseEntity response = cardApplicationController.applyForCard(new CardApplication("61345678"))
        then:
            response.statusCode.is4xxClientError()
    }
}
