package local.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDAO<T> implements DAO<T> {

	protected abstract EntityManager getEntityManager();

	@Override
	public List<T> findAll(Class<T> tClass) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(tClass);
		Root<T> rootEntry = cq.from(tClass);
		CriteriaQuery<T> all = cq.select(rootEntry);
		TypedQuery<T> allQuery = getEntityManager().createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public void create(T t) {
		getEntityManager().persist(t);
	}

	@Override
	public void read(Class<T> tClass, Object key) {
		getEntityManager().find(tClass, key);
	}

	@Override
	public void update(T t) {
		getEntityManager().merge(t);
	}

	@Override
	public void delete(T t) {
		getEntityManager().remove(t);
	}
}
