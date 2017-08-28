package training.ejb;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import training.domain.SimpleProperty;
import training.qualifiers.Qualifiers.ExampleEntityManager;

@Stateless
public class ServiceBean {

	/**
	 * Inject entitymanager component, to perform database operations. 
	 */
	@Inject
	@ExampleEntityManager
	private EntityManager em;

	/**
	 * Inject Event component, to fire events. The events will be received by
	 * components with the appropiate @Observes annotation
	 */
	@Inject
	private Event<SimpleProperty> eventSender;

	public void put(SimpleProperty p) {
		em.persist(p);
		eventSender.fire(p);
	}

	public void delete(SimpleProperty p) {
		Query query = em.createQuery("DELETE FROM training.domain.SimpleProperty p where p.key='" + p.getKey() + "'");
		query.executeUpdate();
		eventSender.fire(p);
	}
}
