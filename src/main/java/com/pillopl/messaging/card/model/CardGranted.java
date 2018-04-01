package com.pillopl.messaging.card.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class CardGranted implements DomainEvent {

    private final UUID cardNo;
    private final BigDecimal cardLimit;
    private final String clientPesel;
    private final Instant timestamp = Instant.now();
    private final String type = "card-granted";

    public CardGranted(UUID cardNo, BigDecimal cardLimit, String clientPesel) {
        this.cardNo = cardNo;
        this.cardLimit = cardLimit;
        this.clientPesel = clientPesel;
    }
}
