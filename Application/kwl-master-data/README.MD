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


## Useful Guides
- [Application Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html)
- [Spring Boot Common Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)