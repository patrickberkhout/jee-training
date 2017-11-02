package local.admin.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.AbstractDAO;
import local.DAO;
import local.admin.domain.Registration;

@Dependent
public class RegistrationDAO extends AbstractDAO<Registration> implements DAO<Registration> {

	@PersistenceContext(name = "adminPersistenceUnit")
	EntityManager em;

	public List<Registration> findByUsername(String username) {
		TypedQuery<Registration> query = em.createNamedQuery("Registration.findByUsername", Registration.class);
		query.setParameter("username", username);
		List<Registration> results = query.getResultList();
		return results;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
