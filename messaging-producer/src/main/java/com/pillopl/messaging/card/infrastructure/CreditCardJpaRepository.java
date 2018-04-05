package com.pillopl.messaging.card.infrastructure;

import com.pillopl.messaging.card.model.CreditCard;
import com.pillopl.messaging.card.model.CreditCardRepository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Jakub Pilimon
 */
interface CreditCardJpaRepository extends CrudRepository<CreditCard, UUID>, CreditCardRepository {
}
