# Notes for Spring Boot 3: desenvolvendo uma API Rest em Java

> Basicamente, o Spring Boot é um framework que facilita absurdamente a configuração de aplicações.

Vamos ver alguns conceitos de desenvolvimento de uma API Rest, de CRUD (Create, Read, Update and Delete), assim como validações e paginação.

## Tecnologias utilizadas
- Spring Boot 3 e Java 17
- Lombok para geração de códigos repetitivos
- MySQL e Flyway para armazenar as informações da nossa API
- JPA / Hibernate camada de persistência com pos módulos do Sprint Boot
- maven para gerenciamento de dependências
- Insomnia para testar a nossa API, já que não vamos ter interface gráfica

## Projeto
Clínica médica, precisa de um aplicativo para controlar o agendamento e o cancelamentode  consultas, os cadastros de pacientes e de médicos.

### Descrição de funcionalidades do projeto
- Funcionalidade "Cadastro de médicos":
```
O sistema deve possuir uma funcionalidade de cadastro de médicos, na qual as seguintes informações deverão ser preenchidas:

 Nome
 E-mail
 Telefone
 CRM
 Especialidade (Ortopedia, Cardiologia, Ginecologia ou Dermatologia)
 Endereço completo (logradouro, número, complemento, bairro, cidade, UF e CEP)

Todas as informações são de preenchimento **obrigatório**, exceto o número e o complemento do endereço
```

Eu simulo o envio das informações usando o Insomnia, com a seguinte mensagem JSON:
```
{
"nome": "Rodrigo Ferreira",
"email": "rodrigo.ferreira@voll.med",
"crm": "123456",
"especialidade": "ortopedia",
"endereco": {
    "logradouro": "rua 1",
    "bairro": "bairro",
    "cep": "12345678",
    "cidade": "Brasilia",
    "uf": "DF",
    "numero": "1",
    "complemento": "complemento"
    }
}
```


## Anotações
### Spring e Spring Boot 
O framework Spring foi desenvolvido de maneira modular, na qual cada recurso que ele disponibiliza é representado por um módulo, que pode ser adicionado em uma aplicação conforme as necessidades. Com isso, em cada aplicação podemos adicionar apenas os módulos que fizerem sentido, fazendo assim com que ela seja mais leve. Existem diversos módulos no Spring, cada um com uma finalidade distinta, como por exemplo: o módulo MVC, para desenvolvimento de aplicações Web e API's Rest; o módulo Security, para lidar com controle de autenticação e autorização da aplicação; e o módulo Transactions, para gerenciar o controle transacional.

Entretanto, um dos grandes problemas existentes em aplicações que utilizavam o Spring era a parte de configurações de seus módulos, que era feita toda com arquivos XML, sendo que depois de alguns anos o framework também passou a dar suporte a configurações via classes Java. Justamente para resolver tais dificuldades é que foi criado um novo módulo do Spring, chamado de Boot, em meados de 2014, com o propósito de agilizar a criação de um projeto que utilize o Spring como framework, bem como simplificar as configurações de seus módulos.

### Spring Initializer
Usamos a plataforma [https://start.spring.io/](https://start.spring.io/) para gerar as configurações básicas:
- Maven Project, Java language, Spring Boot 3.1.5, Voll.mep application, version 17 of Java, compiling in JAR. Adicionamos também algumas depenedências: lombok, Spring Boot DevTools e Spring Web.

## Execução da nossa aplicação
Diferente do Spring normal, onde precisávamos iniciar um servidor, como o Tomcat ou Glassfish, para executar nossa aplicação, o Spring Boot possui o próprio servidor de aplicações dentro das dependências do framework (Tomcat).

### DAO, JPA, Repository e DTO

O padrão de projeto DAO, conhecido também por Data Access Object, é utilizado para persistência de dados, onde seu principal objetivo é separar regras de negócio de regras de acesso a banco de dados. Nas classes que seguem esse padrão, isolamos todos os códigos que lidam com conexões, comandos SQLs e funções diretas ao banco de dados, para que assim tais códigos não se espalhem por outros pontos da aplicação, algo que dificultaria a manutenção do código e também a troca das tecnologias e do mecanismo de persistência.

O Repository é um mecanismo para encapsular armazenamento, recuperação e comportamento de pesquisa, que emula uma coleção de objetos. Simplificando, um repositório também lida com dados e oculta consultas semelhantes ao DAO. No entanto, ele fica em um nível mais alto, mais próximo da lógica de negócios de uma aplicação. Um repositório está vinculado à regra de negócio da aplicação e está associado ao agregado dos seus objetos de negócio, retornando-os quando preciso.

Por que o padrão repository ao invés do DAO utilizando Spring?

O padrão de repositório incentiva um design orientado a domínio, fornecendo uma compreensão mais fácil do domínio e da estrutura de dados. Além disso, utilizando o repository do Spring não temos que nos preocupar em utilizar diretamente a API da JPA, bastando apenas criar os métodos que o Spring cria a implementação em tempo de execução, deixando o código muito mais simples, menor e legível.