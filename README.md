# Project User With Mongodb

User Management API 🚀
Uma API REST robusta desenvolvida com Java 21, Spring Boot 4 e MongoDB para operações de CUD (Create, Update, Delete) de usuários.

## 🛠️ Tecnologias Utilizadas
Java 21: Utilizando as últimas funcionalidades da linguagem (Virtual Threads prontos para uso).
Spring Boot 3.x: Framework base para a construção da microserviço.
Spring Data MongoDB: Abstração de persistência para o banco de dados NoSQL.
Spring Doc / OpenAPI (Swagger): Documentação interativa da API.
Lombok: Redução de código boilerplate.
Docker: Containerização para facilitar o setup do banco de dados.

## 📋 Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:
JDK 21
Maven 3.9+
Docker (opcional, para o MongoDB)
<br><br/>

# 🚀 Começando

1. Clonar o repositório
   ```
   git clone https://github.com/seu-usuario/user-management-api.git
   cd user-management-api
   ```
2. Configurar o Banco de Dados
Se você tiver o Docker instalado, pode subir uma instância do MongoDB rapidamente:
   ```
    docker run -d -p 27017:27017 --name mongodb-api mongo:latest
   ```

3. Configuração do application.properties
   ```
   spring.data.mongodb.uri=mongodb://localhost:27017/user_db
   ```

4. Executar a aplicação
   ```
   mvn spring-boot:run
   ```

