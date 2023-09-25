Projeto de Gerenciamento de Pagamentos de Time de Vôlei
Este projeto Java 17 é uma API que oferece recursos para o gerenciamento de pagamentos de um time de vôlei. A API permite que os usuários se registrem, entrem em times de vôlei e efetuem pagamentos e tenham controle do restante que faltam para pagar.

Tecnologias Utilizadas
Java 17: Linguagem de programação base do projeto.
Spring Boot: Framework utilizado para o desenvolvimento da aplicação.
Swagger: Ferramenta para documentação e teste da API.
Lombok: Biblioteca para redução de código boilerplate.
PostgreSQL: Banco de dados utilizado para armazenar informações dos usuários e pagamentos.
Como Iniciar
Siga as instruções abaixo para iniciar o projeto em sua máquina local:
Docker: Ferramento de Banco de dados relacional

Pré-requisitos
Java 17 JDK instalado em sua máquina.
PostgreSQL instalado e configurado.
Uma IDE Java, como o IntelliJ IDEA ou Eclipse.
Configuração do Banco de Dados
Rode o arquivo docker.compose   volaje-main-api\docker\docker-compose.yml
Abra o arquivo src/main/resources/application.properties e configure as propriedades spring.datasource.url, spring.datasource.username, e spring.datasource.password de acordo com as configurações do seu banco de dados.
Executando o Projeto
Abra o projeto em sua IDE Java.
Execute a classe principal Application.java.
A aplicação será iniciada na porta padrão 8080.
Documentação da API
A documentação da API pode ser acessada através do Swagger. Após iniciar a aplicação, acesse http://localhost:8080/swagger-ui.html em seu navegador para visualizar e testar os endpoints da API.

Uso da API
A API oferece os seguintes endpoints principais:

Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas (issues) e enviar solicitações de pull (pull requests) para melhorar este projeto.
