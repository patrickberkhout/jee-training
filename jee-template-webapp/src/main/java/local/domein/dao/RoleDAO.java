package local.domein.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import local.domein.Role;

@Dependent
public class RoleDAO extends BaseDAO implements DAO<Role> {

	@PersistenceContext(name = "webapp")
	EntityManager em;

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
		List<Role> results = query.getResultList();
		return results;
	}

	@Override
	public void delete(Role t) {
		em.remove(em.find(Role.class, t.getRoleId()));

	}

	@Override
	public void save(Role r) {
		em.persist(r);
	}
}
