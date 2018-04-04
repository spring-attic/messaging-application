package com.pillopl.messaging.card.events

import com.pillopl.messaging.card.ui.CardApplication
import com.pillopl.messaging.card.ui.CreditCardApplicationController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import spock.lang.Ignore
import spock.lang.Specification
import spock.util.concurrent.PollingConditions

import java.util.concurrent.BlockingQueue

@SpringBootTest
@Ignore
class ApplyForCardWithInternalQueueOfEventsTest extends Specification {

    @Autowired CreditCardApplicationController cardApplicationController
    @Autowired Source source
    @Autowired MessageCollector messageCollector

    BlockingQueue<GenericMessage<String>> events

    PollingConditions pollingConditions = new PollingConditions(timeout: 10, initialDelay: 1.5, factor: 1.25)

    def setup() {
        events = messageCollector.forChannel(source.output())
    }

    def 'should be able to get card when born in 70s or later'() {
        when:
            cardApplicationController.applyForCard(new CardApplication("70345678"))
        then:
            pollingConditions.eventually {
                events.poll().getPayload().contains("card-granted")
            }
    }

    def 'should  not be able to get card when born before 70s'() {
        when:
            cardApplicationController.applyForCard(new CardApplication("61345678"))
        then:
            pollingConditions.eventually {
                events.poll().getPayload().contains("card-application-rejected")
            }
    }
}