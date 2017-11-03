package local.cdi.impl;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import local.cdi.Greek;

@Singleton
public class GreetingsProducer {

	@Produces
	@Greek
	String greekGreeting() {
		return "Yasou";
	}
}
