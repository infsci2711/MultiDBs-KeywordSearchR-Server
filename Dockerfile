FROM ubuntu:14.04
MAINTAINER Evgeny Karataev <Karataev.Evgeny@gmail.com>

RUN apt-get update && apt-get install -y \
    openssh-server \
    openjdk-7-jdk \
    curl \
    git

RUN mkdir -p /var/run/sshd

ENV MAVEN_VERSION 3.2.5

RUN curl -sSL http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

ENV MAVEN_HOME /usr/share/maven
ENV M2_HOME /usr/share/maven
ENV M2 $M2_HOME/bin

ENV PATH $M2:$PATH

RUN useradd -d /home/keyworkdsearchr keyworkdsearchr
RUN mkdir -p /home/keyworkdsearchr
RUN chown keyworkdsearchr /home/keyworkdsearchr

RUN echo "keyworkdsearchr:keyworkdsearchr" | chpasswd

COPY docker-entrypoint.sh /home/keyworkdsearchr/entrypoint.sh
COPY db.sql /home/keyworkdsearchr/dbinit.sql

RUN chmod -R 777 /home/keyworkdsearchr

ENTRYPOINT ["/home/keyworkdsearchr/entrypoint.sh"]

EXPOSE 22
EXPOSE 7654

VOLUME /opt/project/deployed

CMD ["/usr/sbin/sshd", "-D"]
