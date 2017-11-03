package local.cdi;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import local.cdi.impl.ApplicationBean;
import local.cdi.impl.GermanGreetingsRepository;


@RunWith(Arquillian.class)
public class CDIExampleIT {

	@Inject
	ApplicationBean webapp;

	@Inject 
	GreetingsRepository defaultGreetings;

	@Inject 
	GermanGreetingsRepository germanGreetings;

	@Inject @Dutch
	GreetingsRepository dutchGreetings;

	@Inject @French
	GreetingsRepository frenchGreetings;


	@Inject @Greek
	GreetingsRepository greekGreetings;

	
	@Deployment
	public static WebArchive createArchive() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
		archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		archive.addPackages(true, "local.cdi");
		System.out.println("Arquillian archive:" + archive.toString(true));
		return archive;
	}

	@Test
	public void testHello() {
		Assert.assertEquals("Hello",webapp.hello());
	}

	@Test
	public void testGreetings() {
		Assert.assertEquals("Hello",defaultGreetings.hello());
		Assert.assertEquals("Hallo",dutchGreetings.hello());
		Assert.assertEquals("Bonjour",frenchGreetings.hello());
		Assert.assertEquals("Guten Tag",germanGreetings.hello());
		Assert.assertEquals("Yasou",greekGreetings.hello());
	}
}
