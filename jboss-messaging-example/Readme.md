# JMS client example
	mvn compile exec:java -DVMHOST=eap7-9f00.rhpds.opentlc.com
	
	
# Learnings

#### Artimes data directory configuration needs xml editing, not cli based
`see standalone.conf` and `standalone-full.xml`

#### to connect you need use with the `guest` role
	/opt/jboss/wildfly/bin/add-user.sh -a -u jmsuser -g guest -p Welkom01!
	
#### Queues can be defined using

	/opt/jboss/wildfly/bin/jboss-cli.sh --connect --file=/opt/jboss/artemis-config.cli