package local.it;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ArquillianIT {

	@Deployment
	public static WebArchive createArchive() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
		return archive;
	}

	@Test
	public void test1() {
		
	}

}
