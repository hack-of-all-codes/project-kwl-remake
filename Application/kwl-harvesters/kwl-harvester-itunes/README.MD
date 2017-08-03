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

## Guides
- [Spring HDFS](http://docs.spring.io/spring-hadoop/docs/current/reference/html/springandhadoop-fs.html)
- [Spring for Hadoop Samples](https://github.com/spring-projects/spring-hadoop-samples)
- [Hadoop: Hortonworks Data Platform](https://github.com/spring-projects/spring-hadoop/wiki/Build-with-Hortonworks-HDP-2.2)
- [Spring Hadoop Config](http://docs.spring.io/autorepo/docs/spring-hadoop/current/reference/html/springandhadoop-config.html)
- [Secured HDFS Access Using Knox and Ranger](https://hortonworks.com/hadoop-tutorial/manage-security-policy-hive-hbase-knox-ranger/)
- [WebHDFS](https://hadoop.apache.org/docs/r1.0.4/webhdfs.html)
- [Mounting NFS](https://hortonworks.com/blog/how-to-enable-nfs-access-to-hdfs-in-hortonworks-sandbox/)