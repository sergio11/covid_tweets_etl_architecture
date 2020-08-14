# Covid Tweets ETL Architecture (A Spring Cloud Stream project)

A microservices ETL architecture for the ingestion and analysis of Tweets about the COVID-19.

## Architecture Overview

<img width="auto" src="./covid_tweets_etl_architecture.png" />

## Applications

* *covid-tweets-api*
`Spring Boot` Web Java application that allows to retrieve and view the tweets processed through a `REST API` or `STOMP over WebSocket`. 

* *covid-tweets-collector*
`Spring Boot` Web Java application that listens to news messages in `processed-tweets` topic in `Kafka`,  saves them in `Elasticsearch`. 

* *covid-tweets-ingest*
`Spring Boot` Web Java application that implement a Twitter client that receives the latest tweets about COVID-19, creates the data model associated with the tweet, and posts it to the topic `tweets-ingest`in `Kafka`.

* *covid-tweets-processor*
`Spring Boot` Web Java application that listens to news messages in `tweets-ingest` topic in `Kafka`and it make the analysis of the text through the analysis service implemented on `Standford Core NLP`.

## Used technology

* Spring Boot 2.3.2 / Apache Maven 3.6.3.
* Spring Cloud Stream (to build highly scalable event-driven applications connected with shared messaging systems)
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

## Some screenshots

### Deploy with Docker Compose.

<img width="auto" src="./screenshots/platform_containers.PNG" />

### Using Akhq dashboard for topics management and kafka broker.

<img width="auto" src="./screenshots/kafka_topics.PNG" />

### Tweets processed will be stored to elasticsearch index and visualize with Kibana.

<img width="auto" src="./screenshots/tweets_indexed.PNG" />

<img width="auto" src="./screenshots/tweet_processed_kibana.PNG" />

### Tweets processed can be get through the REST API / WebSockets offered from the Covid Tweets Microservice API.

<img width="auto" src="./screenshots/covid_tweets_rest_api.PNG" />

<img width="auto" src="./screenshots/swagger_rest_api.PNG" />

### Visualization of the general sentiment and the most frequent terms.

<img width="auto" src="./screenshots/kibana_visualization.PNG" />
<img width="auto" src="./screenshots/kibana_visualization_2.PNG" />
<img width="auto" src="./screenshots/kibana_visualization_3.PNG" />
<img width="auto" src="./screenshots/kibana_visualization_4.PNG" />








