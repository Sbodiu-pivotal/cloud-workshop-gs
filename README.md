Cloud workshop getting started guide

What you’ll need to work your way through the guide.

- About 15 minutes
- A favorite text editor or IDE [Spring Tool Suite](https://spring.io/tools/sts/all) or [JetBrains IDEA](https://www.jetbrains.com/idea/)
- Download [Oracle JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
- Build tools [Gradle 2.3+](http://www.gradle.org/downloads) or [Maven 3.0+](http://maven.apache.org/download.cgi)
- Git client [Installation Guide](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

Setup an account with [Pivotal Web Services](http://run.pivotal.io/).
Welcome to PWS! and use this guide for help [getting started](http://docs.run.pivotal.io/starting/index.html)

## Test hello world application

1 Change to the lab directory:


    $ cd hello

2 Build the application:

    $ ./gradle assemble


3 Run the application:

    $ java -jar build/libs/hello-0.0.1-SNAPSHOT.jar

## Pushing to Cloud Foundry

1 Inspect the manifest _manifest.yml_:

    ---
    applications:
    - name: hello
      memory: 512M
      instances: 1
      host: hello-${random-word}
      path: build/libs/hello-0.0.1-SNAPSHOT.jar

2 Push to Cloud Foundry:

    $ cf push
    ...
    1 of 1 instances running
    
    App started
    
    
    OK
    
    App hello was started using this command `CALCULATED_MEMORY=$($PWD/.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-1.1.1_RELEASE -memorySizes=metaspace:64m.. -memoryWeights=heap:75,metaspace:10,stack:5,native:10 -totMemory=$MEMORY_LIMIT) && SERVER_PORT=$PORT $PWD/.java-buildpack/open_jdk_jre/bin/java -cp $PWD/.:$PWD/.java-buildpack/spring_auto_reconfiguration/spring_auto_reconfiguration-1.7.0_RELEASE.jar -Djava.io.tmpdir=$TMPDIR -XX:OnOutOfMemoryError=$PWD/.java-buildpack/open_jdk_jre/bin/killjava.sh $CALCULATED_MEMORY org.springframework.boot.loader.JarLauncher`
    
    Showing health and status for app hello in org APJ / space production as sbodiu@pivotal.io...
    OK
    
    requested state: started
    instances: 1/1
    usage: 512M x 1 instances
    urls: hello-nonappropriable-beverage.cfapps.io
    last uploaded: Fri Jul 3 05:31:39 UTC 2015
    stack: cflinuxfs2
    
         state     since                    cpu    memory           disk           details
    #0   running   2015-07-03 01:32:22 PM   1.4%   347.3M of 512M   133.3M of 1G

3 Access the application at the random route provided by CF eg: http://hello-nonappropriable-beverage.cfapps.io


