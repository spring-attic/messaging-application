package com.pillopl.messaging.card.model;

import java.time.Instant;

public class CardApplicationRejected implements DomainEvent {

    final String clientPesel;
    final Instant timestamp = Instant.now();
    final String type = "card-application-rejected";

    public CardApplicationRejected(String clientPesel) {
        this.clientPesel = clientPesel;
    }

    public String getClientPesel() {
        return clientPesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }
}
