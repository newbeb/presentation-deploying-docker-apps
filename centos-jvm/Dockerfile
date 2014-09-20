FROM centos
MAINTAINER Brian Lloyd-Newberry <newbeb@gmail.com>
ENV REFRESHED_AT 2014-09-18

WORKDIR /tmp

# Add a Pre-download the jdk8 JVM so we can do an offline demo
ADD jdk-8u11-linux-x64.tar.gz /opt/java

ENTRYPOINT ["/opt/java/jdk1.8.0_11/bin/java"]
CMD ["-version"]
