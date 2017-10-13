package local.view;

import java.util.List;
import java.util.UUID;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import local.domein.Registration;
import local.repository.AuthenticationRepository;

@Model
public class RegistrationsModel {

	@Inject
	private AuthenticationRepository authenticationRepository;

	List<Registration> registrations;

	@Produces
	@Named("newRegistration")
	Registration registration = new Registration();

	public List<Registration> getRegistrations() {
		return authenticationRepository.retrieveAllRegistrations();
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public String delete(Registration r) {
		if (r.getRole().equals("admin")){
			return "index";
		}
		authenticationRepository.deleteRegistration(r.getUsername());
		return "index";
	}
	
	public String save(Registration registration){
		registration.setRegistrationId(UUID.randomUUID().toString());
		authenticationRepository.saveRegistration(registration);
		return "index";
	}

}
