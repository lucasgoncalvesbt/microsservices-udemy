package br.com.lucas.greetingservice.controllers;

import br.com.lucas.greetingservice.config.GreetingConfig;
import br.com.lucas.greetingservice.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	private final GreetingConfig config;

	public GreetingController(GreetingConfig config) {
		this.config = config;
	}

	@GetMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value="name",
			defaultValue = "") String name
	) {
		if(name.isEmpty()) name = config.getDefaultValue();

		return new Greeting(
					counter.incrementAndGet(),
					String.format(TEMPLATE, config.getGreeting(), name)
				);
	}
}
