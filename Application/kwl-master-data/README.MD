# Master Data

## Local Development Prerequisites
- [MongoDB 3.2+](https://github.com/hack-of-all-codes/notes-database/blob/master/MongoDB/Setup.md)
- configure MongoDB admin
```sh
mongo
use admin
db.createUser({
    user:'kwl2',
    pwd:'kwl2password',
    roles:[{
        role:'userAdminAnyDatabase', 
        db: 'admin'
    }]
})
```
- create posgresql user and database
```sql
CREATE ROLE kwl2 PASSWORD 'kwl2password' VALID UNTIL 'infinity';
ALTER ROLE kwl2 WITH LOGIN;

CREATE DATABASE kwl2
  WITH ENCODING='UTF8'
       OWNER=kwl2
       CONNECTION LIMIT=-1
       TABLESPACE=pg_default;

```


## Useful Guides
- [Application Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html)
- [Spring Boot Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)