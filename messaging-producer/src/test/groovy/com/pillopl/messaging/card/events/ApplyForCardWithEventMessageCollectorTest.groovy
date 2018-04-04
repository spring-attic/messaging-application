package com.pillopl.messaging.card.events

import com.pillopl.messaging.card.ui.CardApplication
import com.pillopl.messaging.card.ui.CreditCardApplicationController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import spock.lang.Specification

import java.util.concurrent.BlockingQueue

@SpringBootTest
class ApplyForCardWithEventMessageCollectorTest extends Specification {

    @Autowired CreditCardApplicationController cardApplicationController
    @Autowired Source source
    @Autowired MessageCollector messageCollector

    BlockingQueue<GenericMessage<String>> events


    def setup() {
        events = messageCollector.forChannel(source.output())
    }

    def 'should be able to get card when born in 70s or later'() {
        when:
            cardApplicationController.applyForCard(new CardApplication("70345678"))
        then:
            events.poll().getPayload().contains("card-granted")
    }

    def 'should  not be able to get card when born before 70s'() {
        when:
            cardApplicationController.applyForCard(new CardApplication("61345678"))
        then:
            events.poll().getPayload().contains("card-application-rejected")
    }
}
