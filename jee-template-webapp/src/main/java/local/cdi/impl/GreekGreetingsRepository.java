package local.cdi.impl;

import javax.inject.Inject;

import local.cdi.Greek;
import local.cdi.GreetingsRepository;

@Greek
public class GreekGreetingsRepository implements GreetingsRepository {

	String greeting;

	@Inject
	public GreekGreetingsRepository(@Greek String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String hello() {
		return greeting;
	}

}
