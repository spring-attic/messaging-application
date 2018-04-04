package com.pillopl.messaging.card.infrastructure;

import com.pillopl.messaging.card.model.CreditCard;
import com.pillopl.messaging.card.model.CreditCardRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface CreditCardJpaRepository extends CrudRepository<CreditCard, UUID>, CreditCardRepository {
}
