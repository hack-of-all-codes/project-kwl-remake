# iTunes Data Harvester
Harvester microservice for harvesting from iTunes Relational Data to HDFS

## Data Flow
```
itunes ---> itunes harvester ---> master data
```

## Data Sources:
- [iTunes Enterprise Partner Feed Relational](https://affiliate.itunes.apple.com/resources/documentation/itunes-enterprise-partner-feed/)

## Notable Frameworks
- [Spring for Hadoop](http://docs.spring.io/spring-hadoop/docs/2.5.0.RELEASE/reference/html/introduction.html)