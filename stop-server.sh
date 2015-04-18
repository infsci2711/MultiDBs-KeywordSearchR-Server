#!/bin/bash

#start or (restart) KeywordSearchR

#start our jerseyjetty server
kill -9 $(ps aux | grep java | grep multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar | awk '{print $2}')
