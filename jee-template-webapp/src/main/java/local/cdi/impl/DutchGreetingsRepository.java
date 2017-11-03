package local.cdi.impl;

import local.cdi.Dutch;
import local.cdi.GreetingsRepository;

@Dutch
public class DutchGreetingsRepository implements GreetingsRepository{

	@Override
	public String hello() {
		return "Hallo";
	}

}
