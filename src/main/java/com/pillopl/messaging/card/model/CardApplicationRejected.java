package com.pillopl.messaging.card.model;

import java.time.Instant;

public class CardApplicationRejected implements DomainEvent {

    private final String clientPesel;
    private final Instant timestamp = Instant.now();
    private final String type = "card-application-rejected";

    public CardApplicationRejected(String clientPesel) {
        this.clientPesel = clientPesel;
    }
}
