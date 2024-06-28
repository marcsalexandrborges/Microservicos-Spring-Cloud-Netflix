
![Arquitetura](img.png)

# Projeto de Arquitetura de Microsserviços com Spring Cloud Netflix

## Introdução

Este projeto "Arquitetura de Microsserviços com Spring Cloud Netflix" demonstra como desenvolver e simular um sistema completo de vendas e pagamentos utilizando uma arquitetura baseada em microsserviços. O objetivo é mostrar a integração de diversas tecnologias para criar uma solução robusta e escalável.

## Tecnologias Utilizadas

- **Spring Boot:** Framework para facilitar a configuração e desenvolvimento de aplicações Spring.
- **Spring Security:** Para segurança e controle de acesso aos endpoints.
- **Spring Data JPA:** Para acesso e persistência de dados em bancos relacionais usando JPA.
- **Netflix Eureka:** Service registry para registro e descoberta de serviços.
- **Netflix Zuul:** Gateway para roteamento, monitoramento e segurança de microserviços.
- **RabbitMQ:** Broker de mensagens para comunicação assíncrona.
- **MySQL:** Banco de dados relacional para persistência de dados.

## Estrutura do Projeto

### Microserviço CRUD

Exemplo de microserviço CRUD desenvolvido com Spring Boot para gerenciar produtos.

#### Estrutura do Projeto

|-- src
| |-- main
| |-- java
| |-- com.ms.crud
| |-- controller
| |-- config
| |-- data.vo
| |-- entity
| |-- exception
| |-- jwt
| |-- message
| |-- repository
| |-- services
|-- src
| |-- main
| |-- resources
| |-- application.yml
|-- pom.xml


#### Descrição dos Componentes

- **Controller:** Define os endpoints para CRUD de produtos.
- **Configuração:** Configuração de segurança (Spring Security com JWT) e RabbitMQ.
- **Entity:** Representa a entidade JPA do produto.
- **JWT:** Provedor JWT para geração e validação de tokens.
- **Serviços:** Implementação dos serviços de CRUD.
- **Exceções:** Manipulação de exceções personalizadas.
- **Mensageria:** Envio de mensagens para RabbitMQ.

#### Exemplo de `application.yml`

```yaml
server:
  port: 8081
  servlet:
    context-path: /crud
    
spring:
  application:
    name: crud
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
  datasource:
    url: jdbc:mysql://localhost:3306/crud
    username: microservices
    password: microservices123

  rabbitmq:
    host: localhost 
    port: 5672
    username: admin
    password: admin 
    
crud:
  rabbitmq:
    exchange: crud.exchange
    routingkey: crud.produto.routingkey
    
security:
  jwt:
    token: 
      secret-key: chave_microservices
      
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/registry

Microserviço de Pagamento

Gerencia vendas e produtos vendidos em um sistema de e-commerce.
Estrutura do Projeto

    VendaController: Controlador REST para operações de vendas.
    VendaService: Serviço de operações de negócio relacionadas a vendas.
    Entidades: Venda, ProdutoVenda, Produto.

Endpoints Principais

    GET /venda/{id}: Retorna uma venda específica.
    GET /venda: Retorna uma lista paginada de vendas.
    POST /venda: Cria uma nova venda.

Microserviço de Descoberta (Discovery Server)

Implementa um servidor de descoberta usando Spring Cloud Netflix Eureka.
Exemplo de application.yml
server:
  port: 8761

spring:
  application:
    name: registry

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://localhost:${server.port}/eureka/

Microserviço de Autenticação (Auth Service)

Utiliza Spring Security para gerenciar a segurança e JWT para autenticação.
Exemplo de application.yml
server:
  port: 8083
  servlet:
    context-path: /auth

spring:
  application:
    name: auth
  jpa:
    show-sql: false
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
  datasource:
    url: jdbc:mysql://localhost:3306/auth?allowPublicKeyRetrieval=true&sslMode=DISABLED&useSSL=false&serverTimezone=UTC
    username: microservices
    password: microservices123

security:
  jwt:
    token:
      secret-key: chave_microservices
      expire-length: 360000

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/registry/eureka

Microserviço Gateway
Exemplo de application.yml

server:
  port: 8080
    
spring:
  application:
    name: gateway
    
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/registry/eureka
      
zuul:
  prefix: /api
  ignored-services: "*"
  
  routes:
    crud:
      path: /crud/**
      service-id: crud
      strip-prefix: false
      custom-sensitive-headers: true
      
    pagamento:
      path: /pagamento/**
      service-id: pagamento
      strip-prefix: false
      custom-sensitive-headers: true
      
    auth:
      path: /auth/**
      service-id: auth
      strip-prefix: false
      custom-sensitive-headers: true
Como Executar

Certifique-se de ter as dependências configuradas corretamente no ambiente de desenvolvimento. Utilize o comando mvn spring-boot:run ou execute a aplicação diretamente a partir da sua IDE.
Objetivos de Aprendizado

Ao concluir este projeto, você terá adquirido conhecimento e prática nas seguintes áreas:

    Arquitetura de Microsserviços: Entendimento dos conceitos, benefícios e desafios.
    Service Discovery com Netflix Eureka: Configuração e uso para registro e descoberta de serviços.
    Gateway com Netflix Zuul: Implementação para roteamento e segurança.
    Mensageria com RabbitMQ: Comunicação assíncrona entre microsserviços.
    Segurança com Spring Security e JWT: Autenticação e autorização robustas.
    Integração com Spring Data: Acesso e manipulação de dados com MySQL.
    Gerenciamento de Dependências com Maven: Configuração e construção do projeto.

Este projeto é uma oportunidade de aprender na prática como integrar diversas tecnologias modernas para criar uma arquitetura de microsserviços robusta, escalável e segura.










