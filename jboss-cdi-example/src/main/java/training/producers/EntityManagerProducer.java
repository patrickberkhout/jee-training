package training.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import training.qualifiers.Qualifiers.ExampleEntityManager;
import training.qualifiers.Qualifiers.TrainingEntityManager;

public class EntityManagerProducer {

	@Produces
	@ExampleEntityManager
	@PersistenceContext(unitName = "example-persistence-unit")
	private EntityManager exampleEntityManager;

	@Produces
	@TrainingEntityManager
	@PersistenceContext(unitName = "training-persistence-unit")
	private EntityManager trainingEntityManager;

}
