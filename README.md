# Remake: KWL Project
Got bored today and decided to make some Evil Plans for Remaking the KWL Project from the ground up.
Just 1 rule/constraint that I need to follow: Only use EC2 machines for everything

## Wishlist: Data Harvesting
- Create separate Spring Boot modules for each type of harvesting
- Use Spring Boot + Whatever Framework for scraping sites (check out Nutch)
- Scraper should harvest and store data without processing its contents
- Harvested Data should be stored in CassandraDB

## Wishlist: Data Processing
- Use Spring Cloud Dataflow instead of Pentaho
- Use a Spark Cluster for Stream Processing
- Use a Hadoop Cluster for large batch jobs
- Use a Messaging Bus for Asyn Workflow
- Possibility of using TensorFlow for analyzing sites for data

## Wishlist: Platform
- Use Spring Boot as the main framework
- Use Spring Data for Mongo: less code means less bugs, more productivity
- Use Spring HATEOAS for exposing data: way less code than having to manually write every endpoint
- Separate Master Data and Metrics
- Use a Gateway Server
- Use OAuth2: huge security risk with writing up our own security framework
- Use Reactive endpoints for Server-to-Server communication
- Mockito and JUnit5 Tests!!!
- Payment and User Accounts should be stored in a transactional database
- Use MyBatis for Metrics query
- Cache Metrics Results (Possibly in Redis), or export as Mongo Document, whatever makes sense
- Liquibase for schema version control

## Wishlist: Front End
- Use ReactJS + Flux instead of Angular as the app framework
- Unit Tests (Karma?)
- Use Polymer/WebComponents for the Admin just for fun

## Wishlist: Everything Else
- Unit and Integrations Tests
- Jenkins CI

## Things that I would personally love to keep
- ElasticSearch: freakin awesome
- MongoDB: best storage for master data, we just didnt use async, sad :(
- Ansible

# The Plan
## Phase 1: Make It Work
- Figure out the following technologies
```
Spring Cloud DataFlow
Spring Security OAuth2
Kafka
Spark
Hadoop
Nutch
TensorFlow
Spring + MyBatis
Kafka - no idea where to use this
```
- Start with the Master Data and Auth Server
- Harvest and Process iTunes Data
- Harvest Data from APIs
- Implement Scraper
```
Hystrix
```
## Phase 2: Automate Build
- Setup Jenkins

## Phase 3: Make it Fault Tolerant
- Setup Fault Tolerance

# The Unknowns
- How to schedule batch jobs (check DataFlow)
- Smart way to scale up on scraping sites: we wont survive having to code a new script everytime we add a new site

# Important Resources
```
Spring Security
https://spring.io/guides/tutorials/spring-security-and-angular-js/
https://github.com/spring-guides/tut-spring-security-and-angular-js
https://projects.spring.io/spring-security-oauth/docs/oauth2.html
```
