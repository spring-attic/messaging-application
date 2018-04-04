package com.pillopl.messaging.card.application;

import com.pillopl.messaging.ConsumerMessagingApplication;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerMessagingApplication.class)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
	ids = "com.pillopl:messaging-producer")
public class ListenerStubRunnerTests {

	@Rule public OutputCapture capture = new OutputCapture();

	@Autowired StubTrigger stubTrigger;

	@Test
	public void should_log_card_granted() {
		stubTrigger.trigger("card_granted");

		BDDAssertions.then(this.capture.toString()).contains("GRANTED [86010197600]");
	}

	@Test
	public void should_log_card_rejected() {
		stubTrigger.trigger("card_rejected");

		BDDAssertions.then(this.capture.toString()).contains("REJECTED [86010156812]");
	}
}
