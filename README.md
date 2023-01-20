# Spring-API-Clients

API REST em spring boot (java) que realiza o gerenciamento de clientes.

Esta API permite:  
    
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa  

Pessoa tem os seguintes campos:  
- Nome
- Data de nascimento
- Endereço:
    - Logradouro
    - CEP
    - Número
    - Cidade

Requisitos:
- Todas as respostas da API são JSON  
- Banco de dados H2

# Como utilizar a API:
- Adicionei um arquivo do insomnia que exemplifica (insomnia-tests.json) com utilizar a API.
- Consultar todas as Pessoas: Realizar um GET em `localhost:8080/clients` para receber um json com uma lista de pessoas.
- Consultar um pessoa: Realizar um GET em `localhost:8080/clients/{id}` para receber um json com os campos da pessoa, onde o id é o identificador númerico do cliente.
- Adicionar Pessoa: Realizar um POST em `localhost:8080/client` e pasando no body o seguinte json:
    ```
    {
        "name": "Tiago",
        "birthdate": "1996-03-03",
        "mainAdress":1,
        "adresses":[
            {
                "street":"Rua a",
                "cep":"89222333",
                "number":"123",
                "city":"Joinville"
            }
        ]
    }
- Excluir Pessoa: Realizer um DELETE em `localhost:8080/clients/{id}`, onde o id é o identificador númerico do cliente.
- Alterar Pessoa: Realizar um PUT em `localhost:8080/clients` e pasando no body o seguinte json (se atentar para o campo id, que deve conter um valor de id existente):
    ```
    {
        "id":1,
        "name": "Tiago Funk",
        "birthdate": "1996-03-03",
        "mainAdress":1,
        "adresses":[
            {
                "street":"Rua abc",
                "cep":"89222333",
                "number":"123",
                "city":"Joinville"
            },
            {
                "street":"Rua xyz",
                "cep":"89222333",
                "number":"123",
                "city":"Curitiba"
            }
        ]
    }
- Lista endereços da pessoa: Realizar um GET em `localhost:8080/clients/adresses/{id}` para receber um json com uma lista de endereços, onde o id é o identificador númerico do cliente.
- Adicionar endereços: Realizar um PUT em `localhost:8080/clients/adresses/1`, onde o id é o identificador númerico do cliente e passando o seguinte json no body:
    ```
    {
	"street": "Rua b",
	"cep": "89222333",
	"number": "123",
	"city": "Joinville"
    }
- Editar endereço principal:Realizar um PUT em `localhost:8080/clients/createMainAdress/{idCliente}-{indexAdress}`, onde idCliente é o identificador do cliente e index é o indice do endereço (se a pessoa tem dois endereços, os valores válidos para o índica são 1 ou 2).