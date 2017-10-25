## Deploy to local running EAP
	mvn widlfly:deploy -DskipTests=true


## Docker compose

# Clean up and start new containers
# You can ignore the 'Mount point not found' messages. See https://issues.jboss.org/browse/WFCORE-2301

	docker-compose down
	docker-compose up --build
	
# Main user interface
<http://localhost:8180/jee-template-webapp/>

# Admin user interface (admin/admin)
http://localhost:8180/jee-template-webapp/admin/

# JSF Gallery (admin/admin)
http://localhost:8180/jee-template-webapp/gallery/

# Postgres server
host:localhost port:5532 login:postgres/postgres


