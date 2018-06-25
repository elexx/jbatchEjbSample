# JBatch Runner with EJBs and Batches

To run a JBatch without an full blown JavaEE Application Server, we utilize the Apache BatchEE CLI Runner. This particular demo batch also needs a remote EJB (in a real world application this could be some storage/non-jdbc connector for example).

This projects showcases this setup with Apache BatchEE CLI Runner.

From a software architecture perspective:
* The runner is the base. It rarly changes and has zero dependencies on the applications it runs.
* The plugins/EJBs are JavaEE EJBs. They do nothing special regarding the runner.
* The Batch-WAR is the bundle of batch applications.

This sample differs from a real world application as the EJB and the WAR are created within the same project. Normally we would have a long-living, rarly-changing EJB project and a more frequently changing WAR project. Those the EJB is put in the runner as plugin, whereas the WAR is passed as commandline parameter, see below.

## Setup the BatchEE CLI Runner

Download and unzip [Apache JBatch CLI](http://central.maven.org/maven2/org/apache/batchee/batchee-cli/0.5-incubating/batchee-cli-0.5-incubating.zip)

Modify `conf/openejb.xml` to contain:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<openejb>
	<Deployments dir="plugins/" />
</openejb>
```

Create a folder `plugins`


## Setup the demo batch

Build this project with `mvn install`

Copy `ejb/ear/target/ear-0.0.1-SNAPSHOT.ear` to the previously created `plugins/` folder in the runner

## Startup

Start the runner with:
```bash
./bin/batchee start -archive /PATH_TO_JBATCHSAMPPLE/batchwar/target/batchwar-0.0.1-SNAPSHOT.war -name samplebatch
```
