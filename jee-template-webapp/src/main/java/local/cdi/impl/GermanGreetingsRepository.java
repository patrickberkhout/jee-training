package local.cdi.impl;

import javax.enterprise.inject.Typed;

import local.cdi.GreetingsRepository;

@Typed(GermanGreetingsRepository.class)
public class GermanGreetingsRepository implements GreetingsRepository {

	@Override
	public String hello() {
		return "Guten Tag";
	}

}
