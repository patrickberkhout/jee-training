# JMS server example
	docker build -t local/wildfly-full --no-cache .
	docker run -it --rm -p 8181:8080 -p 9991:9990 -p 61616:61616 local/wildfly-full
	mvn clean wildfly:deploy

Check out deployment in  <http://localhost:9991/console/App.html#home> login `admin/jboss@dm1n`
	
	
# Learnings

#### Artimes data directory configuration needs xml editing, not cli based
`see standalone.conf` and `standalone-full.xml`

#### to connect you need use with the `guest` role
	/opt/jboss/wildfly/bin/add-user.sh -a -u jmsuser -g guest -p Welkom01!
	
#### Queues can be defined using

	/opt/jboss/wildfly/bin/jboss-cli.sh --connect --file=/opt/jboss/artemis-config.cli
	
#### Connecting to a Artemis server in a docker container needs extra configuration

Not yet working ...
<https://access.redhat.com/solutions/2675391>

and

<https://developer.jboss.org/thread/266416>



