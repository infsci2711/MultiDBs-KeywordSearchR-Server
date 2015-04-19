#!/bin/bash
#install 

sudo apt-get install maven
sudo apt-get install git
sudo apt-get install openjdk-7-jdk
sudo apt-get install mysql-server
sudo apt-get install nginx

#folders and environments
cd /opt
sudo mkdir project
cd project

#clone project
sudo git clone https://github.com/infsci2711/MultiDBs-KeywordSearchR-Server.git
sudo git clone https://github.com/infsci2711/MultiDBs-KeywordSearchR-WebClient.git
sudo git clone https://github.com/infsci2711/MultiDBs-Utils.git


mysql -u root -proot < db.sql
cd /usr/share/nginx
sudo rm -R html
sudo ln -sv /opt/project/MultiDBs-KeywordSearchR-WebClient html

cd /opt/project/MultiDBs-Utils
mvn install

cd /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServer
mvn install
cd /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI
mvn install 

#kill -9 $(ps aux | grep java | grep multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar | awk '{print $2}')
nohup java -jar MultiDBsKeywordSearchRServerAPI/target/multidbskeywordsearchrserverapi-0.1-SNAPSHOT.jar /opt/project/MultiDBs-KeywordSearchR-Server/MultiDBsKeywordSearchRServerAPI/src/main/resources/config.properties> log.out 2> error.log < /dev/null &
