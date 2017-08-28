# CDI example
	
	docker build -t local/wildfly .
	docker run -it --rm -p 8181:8080 -p 9991:9990 local/wildfly
	mvn clean wildfly:deploy

Check out deployment in  <http://localhost:9991/console/App.html#home> login `admin/jboss@dm1n`
	
	
# Learnings

### Activate CDI using beans.xml (can be empty)
	webapp/WEB-INF/beans.xml 

### For entitymanager injection you also need persistence.xml and producer.
	@Inject
	private EntityManager em;
	
	resources/META-INF/persistence.xml
	
	@Produces
    @PersistenceContext 
    private EntityManager em;
    
### When you have multiple persistence units, use qualifiers and unitName.
	@Inject @ExampleEntityManager
	private EntityManager em;
	
	@Produces @ExampleEntityManager
    @PersistenceContext(unitName="training-persistence-unit") 
    private EntityManager trainingEntityManager;
    
    
### CDI events
	@Inject
	private Event<YourClass> eventSender;

### JSF injection

Using EL you can inject beans into your JSF page. Make sure the injected component have `@Named` and/or `@Produces` annotations.  
 
 
 
