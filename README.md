# Covid Tweets ETL Platform (A Spring Cloud Stream project)

A microservices ETL architecture for the ingestion and analysis of Tweets about the COVID-19.

## Used technology

* Spring Boot 2.3.2 / Apache Maven 3.6.3.
* Spring Cloud Stream.
* Spring Cloud Starter Stream Kafka.
* lombok.
* Twitter4j Stream.
* Mapstruct.
* Elasticsearch oss 7.6.2.
* Spring Boot Starter Data Elasticsearch.
* kibana oss 7.6.2.
* Spring Boot Starter Web.
* Springdoc Openapi UI.
* Spring Boot Starter Websocket.
* Stanford Corenlp.


## Deploy with Docker Compose.

<img width="auto" src="./screenshots/platform_containers.PNG" />

## Using Akhq dashboard for topics management and kafka broker.

<img width="auto" src="./screenshots/kafka_topics.PNG" />

## Tweets will be stored to elasticsearch index and visualize with Kibana.

<img width="auto" src="./screenshots/tweets_indexed.PNG" />

<img width="auto" src="./screenshots/tweet_processed_kibana.PNG" />




