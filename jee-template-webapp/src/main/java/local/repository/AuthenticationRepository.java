package local.repository;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import local.domein.Registration;
import local.domein.Role;
import local.domein.dao.RegistrationDAO;
import local.domein.dao.RoleDAO;

@Stateless
public class AuthenticationRepository {

	@Inject
	RegistrationDAO registrationDAO;

	@Inject
	RoleDAO roleDAO;

	
	public List<Registration> retrieveAllRegistrations() {
		return registrationDAO.findAll();
	}

	public AuthenticationRepository() {

	}

	public void deleteRegistration(String username) {
		List<Registration> registrations = registrationDAO.findByUsername(username);
		registrations.forEach(r -> registrationDAO.delete(r));
	}

	public void saveRegistration(Registration registration) {
		registrationDAO.save(registration);
		Role r = new Role();
		r.setRegistration(registration);
		r.setRole("user");
		r.setRoleId(UUID.randomUUID().toString());
		roleDAO.save(r);
	}
}
