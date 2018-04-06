package com.pillopl.messaging.card.model;

import java.time.Instant;

/**
 * @author Marcin Grzejszczak
 */
public class CardApplicationRejected {

    String clientPesel;
    Instant timestamp;

    public CardApplicationRejected() {
    }

    public CardApplicationRejected(String clientPesel) {
        this.clientPesel = clientPesel;
        this.timestamp = Instant.now();
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
}
