package local.cdi.impl;

import local.cdi.GreetingsRepository;

public class DefaultGreetingsRepository implements GreetingsRepository{

	@Override
	public String hello() {
		return "Hello";
	}

}
