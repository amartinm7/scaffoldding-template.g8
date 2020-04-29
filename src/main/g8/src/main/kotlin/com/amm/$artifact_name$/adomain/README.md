put here the domain classes

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
  