package com.pillopl.messaging.card.events

import com.pillopl.messaging.card.ui.CreditCardApplicationController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.messaging.Source
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.support.GenericMessage
import spock.lang.Specification

import java.util.concurrent.BlockingQueue
/**
 * @author Jakub Pilimon
 */
@SpringBootTest
class ApplyForCardWithEventMessageCollectorTest extends Specification {

    @Autowired MessageCollector messageCollector

    @Autowired Source source

    BlockingQueue<GenericMessage> events

    @Autowired CreditCardApplicationController creditCardApplicationController


    def setup() {
        events = messageCollector.forChannel(source.output())
    }

    def 'should be able to get card when born in 70s or later'() {


    }

    def 'should  not be able to get card when born before 70s'() {

    }
}
