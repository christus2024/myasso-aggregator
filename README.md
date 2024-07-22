# Socle applicatif du projet myAsso 

## Note importante: ce projet se base sur les preconisation 
du livre microservices-with-spring-boot-3-and-spring-cloud-third-edition [Microservice-Spring-Boot3.pdf](docs%2FMicroservice-Spring-Boot3.pdf)  
et du repo [Github](https://github.com/mohamed-taman/Springy-Store-Microservices/tree/master)


### Structure du projet 


```
Myasso-aggregator--> Repertoire parent. 
|- config --> Tous les fichiers de configurations gérés par spring-cloud-config
  |- .m2 -->  le dossier contenant le fichier settings.xml permetant de configurer l'accès au repo nexus et au serveur sonarqube
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


### Executer l'application en local

Build de l'application

    mvn clean install 

executer l'application en mode dev
    
    mvn spring-boot:run
    ou
    java -jar target/myasso-association-service-1.0.0-SNAPSHOT.jar 

tester l'application sur un navigateur avec les adresses suivantes:

    http://localhost:8082/v3/api-docs
    http://localhost:8082/swagger-ui/index.html

Creer une image docker avec le fichier Dockerfile à la racine de chaque µservice


    docker build -t christus/myasso-association-service:1.0.0 .   

Creer une image docker avec l'outils buildpack. Depuis la version 3 springboot
le plugin spring-boot-maven-plugin intègre nativement la generation des images docker via l'outils paketobuildpacks/builder
(le plugin maven va télécharger ce conteneur et l'executer pour generer l'image de l'application).
   Configurer l'image à generer avec la balise image

      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
            <image>
                <name>christus/${project.name}:${project.version}</name>
            </image>
            <excludes>
                <exclude>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                </exclude>
            </excludes>
        </configuration>
      </plugin>
   
Executer la commande maven suivante pour generer l'image docker

    mvn spring-boot:build-image

Creer une image docker avec le plugin maven jib-maven-plugin. nous n'allons pas l'utiliser dans ce projet
Nous le documentons à des fins de memoire
https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

Ajouter le plugin jib-maven-plugin et configurer le nom de l'image

      <plugin>
        <groupId>com.google.cloud.tools</groupId>
        <artifactId>jib-maven-plugin</artifactId>
        <version>3.4.3</version>
        <configuration>
          <to>
            <image>christus/${project.name}:${project.version}</image>
          </to>
        </configuration>
      </plugin>

Executer la commande maven suivante pour generer l'image docker

    mvn compile jib:dockerBuild 

Pousser l'image sur notre repository dockerhub

    docker image push docker.io/christus/myasso-association-service:1.0.0   

Exécuter le conteneur :
  
    docker run -p externalPort:containerPort --name containerName imageName
    docker run -p 8082:8082 --name myasso-association-service  christus/myasso-association-service:1.0.0

### Quelques tips sur la configuration du projet


#### Pour utiliser les propriétés définies dans votre pom.xml dans le fichier application.properties 
nous devons configurer le filtrage des ressources dans Maven. Voici les étapes à suivre :

1. Configurer le filtrage des ressources dans pom.xml : Ajoutez la configuration suivante dans la section <build> de votre pom.xml :


    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>


2. Configurer le plugin Maven Resources : Ajoutez le plugin suivant dans la section <plugins> de votre pom.xml :
    

    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-resources-plugin</artifactId>
            <version>2.7</version>
            <configuration>
                <delimiters>
                    <delimiter>@</delimiter>
                </delimiters>
                <useDefaultDelimiters>false</useDefaultDelimiters>
            </configuration>
        </plugin>
    </plugins>

3. Utiliser les propriétés dans application.properties : 
utilisez les délimiteurs @..@ pour référencer les propriétés Maven lorsque la balise useDefaultDelimiters est à false ou utiliser ${} lorsqu'elle est à true


    myasso.application.version=${project.version}

4. Pour recuperer la date du dernier build, rajouter la proprieté <build.timestamp>${maven.build.timestamp}</build.timestamp> dans les <properties> du pom
et referencer la variable dans le fichier de configuration application.properties


    myasso.application.lastbuild=@build.timestamp@

#### Ajouter un fichier de configuration personnaliser pour les configurations liés à AWS

1. Ajouter un nouveau fichier de configuration dans le src/main/ressource nommé application-aws.properties
2. Creer une classe de configuration pour binder les differentes propriétés de configuration


      @Component
      @ConfigurationProperties(prefix = "aws")
      @PropertySource("classpath:application-aws.properties")
      public class AWSConfig {
         public String accessKey;
         public String secretKey;
         public String s3Bucket;
      }
3. Activer le scan sur la classe de configuration en rajoutant à notre classe main l'annotation @EnableConfigurationProperties


    @SpringBootApplication
    @EnableConfigurationProperties(AWSConfig.class)
    public class MyassoAssociationServiceApplication {...}


###  TODO


API JpaStream
https://medium.com/codex/streaming-with-jpastreamer-b7116609138

-- TODO Mettre en place un hook git de pre-commit pour verifier et interdir le commit de secret
----autoriser uniquement les secrets dans un fichier vault chiffré(utiliser ansible-vault, ou mozilla vault ou gitcript, git-secret, passwordstore).

https://stackoverflow.com/questions/3298135/how-to-specify-mavens-distributionmanagement-organisation-wide

TODO utiliser le plugin log Explorer sur docker dekstop

Spring et l'interface @HttpExchange pour la communication asynchronne entre microservice
https://www.youtube.com/watch?v=uDo3Q02_ano

spring Auth2 server
https://www.youtube.com/watch?v=0C9S1yBSSO8
https://www.youtube.com/watch?v=IIFAiNMiywQ
https://www.youtube.com/watch?v=DaUGKnA7aro
https://www.youtube.com/watch?v=FoyAvzU5fO0

