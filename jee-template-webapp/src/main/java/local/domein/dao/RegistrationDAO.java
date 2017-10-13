package local.domein.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.domein.Registration;

@Dependent
public class RegistrationDAO extends BaseDAO implements DAO<Registration> {

	@PersistenceContext(name = "webapp")
	EntityManager em;

	@Override
	public List<Registration> findAll() {
		TypedQuery<Registration> query = em.createNamedQuery("Registration.findAll", Registration.class);
		List<Registration> results = query.getResultList();
		return results;
	}

	public List<Registration> findByUsername(String username) {
		TypedQuery<Registration> query = em.createNamedQuery("Registration.findByUsername", Registration.class);
		query.setParameter("username", username);
		List<Registration> results = query.getResultList();
		return results;
	}

	@Override
	public void delete(Registration t) {
		em.remove(em.find(Registration.class, t.getRegistrationId()));
	}

	@Override
	public void save(Registration t) {
		em.persist(t);
	}
	
}
