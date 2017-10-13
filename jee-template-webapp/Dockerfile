FROM jboss/wildfly

RUN echo 100

USER root
COPY container/webapp /opt/webapp/
RUN chown -R jboss /opt/webapp
USER jboss
WORKDIR /opt/webapp

RUN cp -r modules/ /opt/jboss/wildfly/

RUN curl -o /opt/jboss/wildfly/modules/org/postgresql/main/postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.1.4.jar

RUN bash run_cli_script.sh datasources.cli

# http://stackoverflow.com/questions/20965737/
RUN rm -rf /opt/jboss/wildfly/standalone/configuration/standalone_xml_history/current

RUN /opt/jboss/wildfly/bin/add-user.sh admin jboss@dm1n --silent
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]