# Socle applicatif du projet myAsso 

## Note importante: ce projet se base sur les preconisation du livre microservices-with-spring-boot-3-and-spring-cloud-third-edition [Microservice-Spring-Boot3.pdf](docs%2FMicroservice-Spring-Boot3.pdf)  et du repo [Github](https://github.com/mohamed-taman/Springy-Store-Microservices/tree/master)


### Structure du projet 


```
Myasso-aggregator--> Repertoire parent. 
|- config --> Tous les fichiers de configurations gérés par spring-cloud-config 
|- docs --> Toutes documentations et  diagrammes associés. 
|- myasso-base 
  |- myasso-build-chassis --> Super POM Parent, contenant les informations de build
  |- myasso-cloud-chassis --> POM parent des services Cloud, herite du build-chassis et contient toutes les librairies cloud
  |- myasso-service-chassis --> POM parent, herite du cloud-chassis et contient toutes les librairies et dependances des microservices metier 
|-myasso-cloud-infra 
  |- authorization-server --> Authorization server
  |- edge-server --> API Gateway server
  |- eureka-server --> Service discovery server
  |- config-server --> Centralized Configuration server
|-myasso-common 
  |- myasso-api -->Endpoint API et definitions de services pour tous les microservices 
  |- myasso-utils --> utilitaires partagés par tous les microservices 
|-myasso-services 
  |- association-service --> Gestion des  associations 
  |- membre-service --> Gestion des  membres/adherants 
  |- presence-service --> Gestion des présences 
  |- sanction-service --> Gestion des sanctions 
  |- communication-service --> Gestion des communications mails, taches planifiées 
  |- cagnote-service --> Gestion des cagnotes 
  |- tontine-service --> Gestion des tontines 
  |- banque-service --> Gestion des banques 
```

### Initialisation du repo
    git flow init
