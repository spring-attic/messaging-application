package com.pillopl.messaging.card.model;

import java.time.Instant;

public class CardApplicationRejected implements DomainEvent {

    String clientPesel;
    Instant timestamp;
    String type;

    public CardApplicationRejected() {
    }

    public CardApplicationRejected(String clientPesel) {
        this.clientPesel = clientPesel;
        this.timestamp = Instant.now();
        this.type = "card-application-rejected";
    }

    public String getClientPesel() {
        return clientPesel;
    }

    public void setClientPesel(String clientPesel) {
        this.clientPesel = clientPesel;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    @Override public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
