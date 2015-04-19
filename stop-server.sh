#!/bin/bash

#start or (restart) KeywordSearchR

#stop the running server
kill -9 $(ps aux | grep java | grep multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar | awk '{print $2}')
