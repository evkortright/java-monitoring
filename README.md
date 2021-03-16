# java-monitoring

## Create database and user

mysql> create database db_example; 

mysql> create user 'springuser'@'%' identified by 'ThePassword'; 

mysql> grant all on db_example.* to 'springuser'@'%'; 

## Build and run mysqlservice
cd mysql-service

mvn clean package 

java -jar target/mysql-service-0.0.1-SNAPSHOT.jar 

## Add some friends
curl localhost:8080/friend/add -d name=John 

curl localhost:8080/friend/add -d name=Jane 

curl localhost:8080/friend/all 

## Run mysqlservice instrumented with the Elastic Java Agent
java -javaagent:../agent/elastic-apm-agent-1.17.0.jar \
 -Delastic.apm.service_name=mysqlservice \
 -Delastic.apm.server_urls=<YOUR_APM_SERVER_URL> \
 -Delastic.apm.secret_token=<YOUR_SECRET_TOKEN> \
 -Delastic.apm.application_packages=com.example \
 -jar target/mysql-service-0.0.1-SNAPSHOT.jar 

