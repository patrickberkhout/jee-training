package local.admin;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import local.admin.domain.AdminRepository;
import local.admin.domain.Registration;

/*
https://github.com/jboss-developer/jboss-eap-quickstarts/blob/7.1.0.Beta/tasks
	*/
@RunWith(Arquillian.class)
public class AdminRepositoryIT {

	@Inject
	AdminRepository repo;

	@Deployment
	public static WebArchive createArchive() {
		WebArchive archive = DefaultDeployment.deployment();
		archive.addPackage("local.admin.domain");
		archive.addPackage("local.admin.dao");
		archive.addPackage("local.common");
		System.out.println("Arquillian archive:" + archive.toString(true));
		return archive;
	}

	@Test
	public void test1() {
		System.out.println(repo.getClass());
		List<Registration> registrations = repo.retrieveAllRegistrations();
		Assert.assertEquals(4, registrations.size());
	}

}
