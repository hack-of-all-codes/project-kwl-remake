# Project: KWL Remake
- Got bored today and decided to make some awesome plans for remaking the KWL Project from the ground up.
- [Business Rules](BUSINESS_RULES.md): A short definition
- [What Went Wrong](WENT_WRONG.md): A list of rants
- Just 1 minor change that I need to follow: Use GCP since they locked me out of the AWS Admin privileges, GCP has a generous trial package that I can utilize without spending a dime 

## Wishlist: Data Harvesting
- Simplify the data harvesting process
- A separate project for API harvests and web page harvests
- Use Google Cloud Functions [Node.js](POC/poc-headless-chrome) for harvesting web pages
- Use another Cloud Function to harvest API data sources (for POC)
- Store Results in MongoDB and S3

## Wishlist: Data Processing
- Use Spring Cloud Dataflow instead of Pentaho
- Use a Spark Cluster for Stream Processing
- Use a Hadoop Cluster for large batch jobs
- Use a Messaging Bus for Async Workflow
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
- Use Firebase hosting
- Use Angular, its the simplest framework that is available in the market right now
- Unit Tests (Karma?)
- Use Polymer/WebComponents for the Admin just for fun

## Wishlist: Everything Else
- Unit and Integrations Tests
- Travis CI
- Use Spring Config server

## Things that I would personally love to keep
- ElasticSearch: freakin awesome
- MongoDB: best storage for master data, we just didnt use async, sad :(
- Ansible

# The Plan
## Phase 1: Harvest All the Data!!!
Harvest the data and store it somewhere
```
GCP Cloud Functions
MongoDB
Cloud Storage
```
- Start with the Master Data and Auth Server
- Harvest and Process iTunes Data
- Harvest Data from APIs
- Implement Scraper

## Phase 2: Process All the Data!!!
- Setup a Monitoring Service

## Phase 3: Display All the Data!!!
- Build the Frontend
- 

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
