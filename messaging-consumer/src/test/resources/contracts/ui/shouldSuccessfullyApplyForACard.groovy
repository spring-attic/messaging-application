package contracts.ui

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("""
An eligible client successfully applies for a card
""")
	request {
		url "/applications"
		method POST()
		headers {
			contentType(applicationJson())
		}
		body(pesel: "86010197600")
	}
	response {
		status OK()
	}
}