package com.pillopl.messaging.card;

import com.pillopl.messaging.card.model.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
