package com.pillopl.messaging;

import com.pillopl.messaging.card.model.CardApplicationRejected;
import com.pillopl.messaging.card.model.CardGranted;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Jakub Pilimon
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerMessagingApplication {

    public static void main(String[] args) {
		SpringApplication.run(ConsumerMessagingApplication.class, args);
	}

}

/**
 * @author Jakub Pilimon
 */
@Component
class Listener {
	private static final Logger log = LoggerFactory.getLogger(Listener.class);


	@StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'card-granted'")
	public void receiveGranted(@Payload CardGranted granted) {
		log.info("\n\nGRANTED [" + granted.getClientPesel() + "] !!!! :) :) :)\n\n");
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['type'] == 'card-application-rejected'")
	public void receiveRejected(@Payload CardApplicationRejected rejected) {
		log.error("\n\nREJECTED [" + rejected.getClientPesel() + "] !!!! :( :( :(\n\n");
	}
}

