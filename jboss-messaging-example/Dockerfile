FROM jboss/wildfly
RUN /opt/jboss/wildfly/bin/add-user.sh admin jboss@dm1n --silent


# Copy standalone.conf which contains 
#JAVA_OPTS="$JAVA_OPTS -Djournal.path.relative.to.brick=artemis/journal"
#JAVA_OPTS="$JAVA_OPTS -Dpaging.path.relative.to.brick=artemis/paging"
#JAVA_OPTS="$JAVA_OPTS -Dlarge.messages.path.relative.to.brick=artemis/bindingsAndLargeMessages"
#JAVA_OPTS="$JAVA_OPTS -Dbinding.path.relative.to.brick=artemis/bindingsAndLargeMessages"
COPY standalone.conf /opt/jboss/wildfly/bin/standalone.conf 

# Copy standalone-full.xml which contains
#    <paths>
#	    <path path="/srv/messaging" name="brick1"/>
#	    <path path="/srv/messaging" name="brick2"/>
#	    <path path="/srv/messaging" name="brick3"/>
#	</paths>
#
#   <journal-directory path="${journal.path.relative.to.brick}" relative-to="brick1" />
#   <paging-directory path="${paging.path.relative.to.brick}" relative-to="brick2" />
#   <large-messages-directory path="${large.messages.path.relative.to.brick}" relative-to="brick3" />
#   <bindings-directory path="${binding.path.relative.to.brick}" relative-to="brick3" />

COPY standalone-full.xml /opt/jboss/wildfly/standalone/configuration/standalone-full.xml

# copy this so we can execute later inside the container..
COPY artemis-config.cli /opt/jboss

USER root
RUN mkdir -p /opt/messaging
RUN chown -R jboss:jboss /opt/messaging

USER jboss
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0" ,"--server-config=standalone-full.xml"]
