package training.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import training.domain.SimpleProperty;
import training.repository.RepositoryManager;

/**
 * Rquest scope bean to provide a list of properties to JSF Page.
 *
 */
@RequestScoped
public class PropertyListManager {

	@Inject
	RepositoryManager db;

	private List<SimpleProperty> propertyList;

	public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final SimpleProperty member) {
		System.out.println("Producer received the event..");
		retrieveAllProperties();
	}

	@Produces
	@Named
	public List<SimpleProperty> getPropertyList() {
		return propertyList;
	}

	public void setProperty(List<SimpleProperty> propertyList) {
		this.propertyList = propertyList;
	}

	@PostConstruct
	public void retrieveAllProperties() {
		propertyList = db.queryCache();
	}
}
