# Resteasy server example
	
	docker build -t local/wildfly .
	docker run -it --rm -p 8181:8080 -p 9991:9990 local/wildfly
	mvn clean wildfly:deploy

Check out deployment in  <http://localhost:9991/console/App.html#home> login `admin/jboss@dm1n`

See customers in <http://localhost:8181/jboss-resteasy-example/rest-service/customers>
	
# Learnings

### 