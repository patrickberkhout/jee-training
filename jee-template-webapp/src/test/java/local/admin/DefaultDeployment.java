package local.admin;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class DefaultDeployment {
	
	public static WebArchive deployment() {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "test.war");
		archive.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
		archive.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
		archive.addAsWebInfResource("test-ds.xml", "test-ds.xml");
		archive.addAsResource("import.sql");
		return archive;
	}
}
