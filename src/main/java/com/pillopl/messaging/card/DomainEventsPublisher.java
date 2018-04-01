package com.pillopl.messaging.card;

import com.pillopl.messaging.card.model.DomainEvent;

public interface DomainEventsPublisher {

    void publish(DomainEvent domainEvent);
}
