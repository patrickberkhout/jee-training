## Deploy to local running EAP
	mvn jboss-as:deploy -DskipTests=true


## Docker compose

# Clean up and start new containers
# You can ignore the 'Mount point not found' messages. See https://issues.jboss.org/browse/WFCORE-2301

	docker-compose down
	docker-compose up --build
