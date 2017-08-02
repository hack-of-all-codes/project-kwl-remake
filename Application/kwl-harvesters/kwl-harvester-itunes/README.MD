# iTunes Data Harvester
Harvester microservice for harvesting from iTunes Relational Data to HDFS

## Data Flow
```
itunes ---> itunes harvester ---> master data
```

## Local Development Prerequisites
- [MongoDB 3.2+](https://github.com/hack-of-all-codes/notes-database/blob/master/MongoDB/Setup.md)
- configure MongoDB admin
```sh
mongo
use admin
db.createUser({
    user:'kwl2harvester',
    pwd:'kwl2harvesterpassword',
    roles:[{
        role:'userAdminAnyDatabase', 
        db: 'admin'
    }]
})
```

## Data Sources:
- [iTunes Enterprise Partner Feed Relational](https://affiliate.itunes.apple.com/resources/documentation/itunes-enterprise-partner-feed/)

## Notable Frameworks
- [Spring for Hadoop](http://docs.spring.io/spring-hadoop/docs/2.5.0.RELEASE/reference/html/introduction.html)