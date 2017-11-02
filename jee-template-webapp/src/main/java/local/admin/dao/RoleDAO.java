package local.admin.dao;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import local.AbstractDAO;
import local.DAO;
import local.admin.domain.Role;

@Dependent
public class RoleDAO extends AbstractDAO<Role> implements DAO<Role> {

	@PersistenceContext(name = "adminPersistenceUnit")
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
