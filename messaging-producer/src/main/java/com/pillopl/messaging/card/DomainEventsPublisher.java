package com.pillopl.messaging.card;

import com.pillopl.messaging.card.model.DomainEvent;

/**
 * @author Jakub Pilimon
 */
public interface DomainEventsPublisher {

    void publish(DomainEvent domainEvent);
}
