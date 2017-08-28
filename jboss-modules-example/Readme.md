# Module example
	
	docker build -t local/wildfly .
	docker run -it --rm -p 8181:8080 -p 9991:9990 local/wildfly
	mvn clean wildfly:deploy
	
<http://localhost:8181/jboss-modules-example/rest/service/jgroups>
	
	
# Learnings

### module dependency in
	webapp/WEB-INF jboss-deployment-structure.xml

### Rest application class annotation
	@ApplicationPath(value="/rest")

### Rest endpoint class annocation
	@Path("/service")

### Rest endpoint method annotation
	@GET
	@Path("/jgroups")
	@Produces({ "application/json" })

### JSON builder
	JsonObject model = Json.createObjectBuilder().add("result", "Hello, world").build();
