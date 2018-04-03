package com.pillopl.messaging.card.events

import com.pillopl.messaging.card.DomainEventsPublisher
import com.pillopl.messaging.card.application.ApplyForCardService
import com.pillopl.messaging.card.model.CardApplicationRejected
import com.pillopl.messaging.card.model.CardGranted
import com.pillopl.messaging.card.model.CreditCardRepository
import spock.lang.Specification

class ApplyForCardWithEventUnitTest extends Specification {

    DomainEventsPublisher domainEventsPublisher = Mock()
    CreditCardRepository cardRepository = Stub()
    ApplyForCardService applyForCardService = new ApplyForCardService(domainEventsPublisher, cardRepository)

    def 'should emit CardGranted when client born in 70s or later'() {
        when:
            applyForCardService.apply("89121514667")
        then:
            1 * domainEventsPublisher.publish( { it instanceof CardGranted } )
    }

    def 'should emit CardApplicationRejected when client born before 70s'() {
        when:
            applyForCardService.apply("66121514667")
        then:
            1 * domainEventsPublisher.publish( { it instanceof CardApplicationRejected } )
    }
}
