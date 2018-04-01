package com.pillopl.messaging.card.infrastructure;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.List;

interface DomainEventStorage extends CrudRepository<StoredDomainEvent, Long> {
    List<StoredDomainEvent> findAllBySentOrderByTimestampDesc(boolean sent);
}

@Entity
class StoredDomainEvent {

    @Id @GeneratedValue Long id;
    private String content;
    private boolean sent;
    private Instant timestamp = Instant.now();

    StoredDomainEvent(String content) {
        this.content = content;
    }

    private StoredDomainEvent() {
    }

    void sent() {
        sent = true;
    }

    String getContent() {
        return content;
    }
}