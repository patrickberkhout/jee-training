package local.it;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import local.Main;

@RunWith(Arquillian.class)
public class GrapheneIT {

	@Drone
	private WebDriver browser;

	@ArquillianResource
	private URL url;

	@FindBy(id = "loginForm:userName") 
	private WebElement userName;

	@Deployment(testable = false)
	public static WebArchive createArchive() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
		archive.addClass(Main.class);
		return archive;
	}

	@Test
	public void test1() {
		browser.get(url.toExternalForm());
		//userName.sendKeys("demo");                                     
	}

}
