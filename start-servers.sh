#!/bin/bash

#start or (restart) KeywordSearch
#presto-server-0.97/bin/launcher restart
#start our jerseyjetty server
nohup java -jar MultiDBsKeywordSearchRServerAPI/target/multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI/src/main/resources/config.properties> log.out 2> error.log < /dev/null &
