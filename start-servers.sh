#!/bin/bash

#start or (restart) KeywordSearch

#start our jerseyjetty server
cd /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI/target
nohup java -jar multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI/src/main/resources/config.properties > log.out 2> error.log < /dev/null &
