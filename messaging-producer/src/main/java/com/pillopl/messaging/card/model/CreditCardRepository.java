package com.pillopl.messaging.card.model;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Jakub Pilimon
 */
public interface CreditCardRepository {

    CreditCard save(CreditCard creditCard);

    Optional<CreditCard> findById(UUID uuid);
}
