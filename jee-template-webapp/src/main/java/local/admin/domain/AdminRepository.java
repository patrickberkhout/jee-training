package local.admin.domain;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import local.admin.dao.RegistrationDAO;
import local.admin.dao.RoleDAO;

@Stateless
public class AdminRepository {

	@Inject
	RegistrationDAO registrationDAO;

	@Inject
	RoleDAO roleDAO;

	public List<Registration> retrieveAllRegistrations() {
		return registrationDAO.findAll(Registration.class);
	}

	public AdminRepository() {

	}

	public void deleteRegistration(String username) {
		List<Registration> registrations = registrationDAO.findByUsername(username);
		registrations.forEach(r -> registrationDAO.delete(r));
	}

	public void saveRegistration(Registration registration) {
		registrationDAO.create(registration);
		Role r = new Role();
		r.setRegistration(registration);
		r.setRole("user");
		r.setRoleId(UUID.randomUUID().toString());
		roleDAO.create(r);
	}
}
