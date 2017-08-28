# CLI


#### start standalone, listen in all interfaces
./standalone.sh -b 0.0.0.0 -bmanagement 127.0.0.1

### start GUI
	$JBOSS_HOME/bin/jboss-cli.sh --connect --controller=$HOSTNAME:9990 --gui
	
### Example CLI
	=> cd /subsystem=datasources
	=> cd data-source=ExampleDS
	=> pwd
	/subsystem=datasources/data-source=ExampleDS
	=> :write-attribute(name=enabled,value=false)
	
### CLI Operations

    Operations depend on node

        :read-operation-names shows available operations
        :read-operation-description gets information on particular operation for resource
        :read-resource shows resource’s attribute values (similar to ls command output).
        :write-attribute shows resource’s attribute values.
 
### CLI script
 	
 	$JBOSS_HOME/bin/jboss-cli.sh –connect –controller=$HOSTNAME:9999 -c –file=myProject.cli
 	
#### batch - atomic action
	batch
	/...
	/...
	run-batch
 	
 	