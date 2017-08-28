package training.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import training.domain.SimpleProperty;
import training.qualifiers.Qualifiers.ExampleEntityManager;

public class RepositoryManager {

	@Inject
	@ExampleEntityManager
	private EntityManager em;

	public List<SimpleProperty> queryCache() {
		Query query = em.createQuery("FROM training.domain.SimpleProperty");

		@SuppressWarnings("unchecked")
		List<SimpleProperty> list = query.getResultList();
		return list;
	}
}
