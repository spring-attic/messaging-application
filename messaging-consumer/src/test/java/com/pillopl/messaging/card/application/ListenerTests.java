package com.pillopl.messaging.card.application;

import com.pillopl.messaging.ConsumerMessagingApplication;
import com.pillopl.messaging.card.model.CardApplicationRejected;
import com.pillopl.messaging.card.model.CardGranted;

import java.math.BigDecimal;
import java.util.UUID;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerMessagingApplication.class)
public class ListenerTests {

	@Rule public OutputCapture capture = new OutputCapture();

	@Autowired Sink sink;

	@Test
	public void should_log_card_granted() {
		sink.input().send(MessageBuilder.withPayload(
				new CardGranted(UUID.randomUUID(), BigDecimal.ONE, "123")).build());

		BDDAssertions.then(this.capture.toString()).contains("GRANTED");
	}

	@Test
	public void should_log_card_rejected() {
		sink.input().send(MessageBuilder.withPayload(
				new CardApplicationRejected("123")).build());

		BDDAssertions.then(this.capture.toString()).contains("REJECTED");
	}
}
