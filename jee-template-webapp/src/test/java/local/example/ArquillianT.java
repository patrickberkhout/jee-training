package local.example;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianT {

	@Inject
	InjectedResource test;

	@Deployment
	public static WebArchive createArchive() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
		archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");  
		archive.addClasses(InjectedResource.class);
		System.out.println("Arquillian arhive:" + archive.toString(true));
		return archive;
	}

	@Test
	public void test1() {
		System.out.println(test.getClass());
	}

}
