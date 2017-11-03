package local.cdi.impl;

import local.cdi.French;
import local.cdi.GreetingsRepository;

@French
public class FrenchGreetingsRepository implements GreetingsRepository {
	@Override
	public String hello() {
		return "Bonjour";
	}

}
