package training.web.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Producer;
import javax.inject.Inject;
import javax.inject.Named;

import training.domain.SimpleProperty;
import training.ejb.ServiceBean;

/**
 * Request scoped backing bean. This bean is injected into a JSF page. page.
 */
@RequestScoped
@Named("manager")
public class PropertyManager {

	@Inject
	ServiceBean ejb;

	/**
	 * Produce a bean to be used in JSF page.
	 */
	@Produces
	@Named
	SimpleProperty property;

	@Inject
	PropertyListManager propertyListManager;

	/**
	 * Initialize the 'property' after thet BeanManager creation. If you do no
	 * do this, 'property' will be NULL.
	 */
	@PostConstruct
	public void initNewProperty() {
		property = new SimpleProperty();
	}

	public void save() {
		System.out.println("Calling ServiceBean.put operation.  Property = " + property);
		ejb.put(property);
		initNewProperty();
	}

	public void clear(SimpleProperty property) {
		System.out.println("Calling ServiceBean.clear operation.  Property = " + property);
		ejb.delete(property);
	}

}