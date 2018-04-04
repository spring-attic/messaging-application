package com.pillopl.messaging.card.model;

/**
 * Marker interface for domain events
 *
 * @author Marcin Grzejszczak
 */
public interface DomainEvent {
	String getType();
}
