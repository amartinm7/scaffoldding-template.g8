# $project_name$

# kotlin dsl

create ms from scratch
```
spring init  --build gradle --name=kotlin-dsl --dependencies=web,data-jpa,mysql,devtools,thymeleaf --package-name=com.amm.kotlin.dsl
```

### hexagonal + DDD: three layers
* domain: 
    - domain, 
    - interface ports, 
    - domain services
* application
    - use cases or services
    - application services
* infrastructure.framework
    - framework services
    - controller
    - implement ports as repositories
    - spring config classes to define the @bean services and dependencies
    - classes with dependencies with spring, kafka, postgres and so on
    