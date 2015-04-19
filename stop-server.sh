#!/bin/bash

#start or (restart) KeywordSearchR

#stop the running server
kill -9 $(ps aux | grep java | grep multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar | awk '{print $2}')

#install mvn to rebuild java code, prepare for next start
cd /opt/project/MultiDBs-Utils
mvn install
cd /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServer
mvn install
cd /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI
mvn install 
