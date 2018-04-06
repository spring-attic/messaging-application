package com.pillopl.messaging.card.model;

import java.time.Instant;

/**
 * @author Jakub Pilimon
 */
public class CardApplicationRejected implements DomainEvent {

    final String clientPesel;
    final Instant timestamp = Instant.now();

    public CardApplicationRejected(String clientPesel) {
        this.clientPesel = clientPesel;
    }


    @Override public String getType() {
        return "card-application-rejected";
    }
}
