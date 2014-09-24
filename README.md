presentation-deploying-docker-apps
==================================

This is a presentation on using Docker to deploy applications. 
It provides and introductory example with a Java application deployed to Docker as an executable jar file (as a Spring Boot app).
The example is extended to publish messages to a Redis server running in docker, which is linked to the application.

Start with the [presenation.html](presentation.html) file which is implemented in [Remark](https://github.com/gnab/remark).
Hitting P will bring up the speaker notes, which provide additional context.

The following branches are used in the presenation
* master: presentation, plus a base Dockerfile for a Centos image w/ an Oracle JVM running in it.
* simplepixel: The code and Dockerfile in the "pixel" subdirectory for a standalone app that logs hits it gets on it's HTTP port.
* redispixel: The code for a server that publishes the "pixel" hits it gets to a linked Redis docker container.

This presentation was developed for [Vermont Code Camp](http://vtcodecamp.org/) and first presented on September, 20 2014.
