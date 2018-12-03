REST API with cars data (manufactor, brand and model).

Application supports GET, POST, PUT, DELETE operations on car manufactors, brands and models. 
  path: http://localhost:8080/producers/{producerId}/brands/{brandId}/models/{modelId}

Stack:
- JavaEE,
- Wildfly Swarm application server, 
- JAX-RS API, 
- Hibernate,
- Postgres, 

How2run? 
- configure [src/main/resources/META-INF/] persistence.xml file,
- use mvn wildfly-swarm:run command to start application,

created by: 
- Monika Górecka
- Filip Szczęski
- Bart Petka



