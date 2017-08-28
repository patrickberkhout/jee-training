# JBoss EAP Services
Extensions, Profiles, Subsystems

Services provide capabilities of application server

From configuration point of view, user does not interact directly with services

 User interacts with:

* Extensions
	* Extend base functionalities of application server
   * Define one or more subsystems

* Subsystems
	* Sets of capabilities added by extension
	* Install services in MSC

* Profiles
	* Sets of subsystems and their configurations

## Implicit dependencies
* Have a look here a the list of modules that are implicitely loaded

https://docs.jboss.org/author/display/AS71/Implicit+module+dependencies+for+deployments

## Explicit dependencies
Explicit Dependencies

    Four ways to explicitly define dependencies:

        In META-INF/MANIFEST.MF using Dependency property

        In META-INF/MANIFEST.MF using Class-Path property

        Using jboss-deployment-structure.xml in META-INF or WEB-INF of top-level deployment

        Using global modules

jboss-deployment-structure.xml Location

 Must be in top-level archive

Example: Inside WEB-INF WAR archive

Archive must be deployed as WAR

If same WAR archive embedded in EAR archive, jboss-deployment-structure.xml is ignored

Solution: Move file to METE-INF folder in EAR archive

		<jboss-deployment-structure>
		    <deployment>
		        <exclusion>
		            <module name="org.javassist" />
		            <module name="org.hibernate" slot="main" />
		        </exclusion>
		        <dependencies>
		            <module name="org.hibernate" slot="3.5" />
		        </dependencies>
		    </deployment>
		    <sub-deployment name="myapp.war">
		    ...
		    </sub-deployment>
		</jboss-deployment-structure>

Global Modules

    Least-recommended option for explicitly defining dependencies

        Easiest to abuse

    Configured as part of EE subsystem

        Visible to all deployments

        Equivalent to loading common libraries in common/lib in JBoss AS

        <subsystem xmlns="urn:jboss:domain:ee:1.0">
            <global-modules>
                <module name="org.apache.log4j"/>
            </global-modules>
        </subsystem>