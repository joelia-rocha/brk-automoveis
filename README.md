<h3 align="center">
  Challenge: API REST Autenticação de automóveis
</h3>
<br>

<p align="center">
  <a href="#car-sobre-o-desafio">Sobre o teste</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#configuração-do-projeto">Configuração do Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#rotas-da-api">Rotas da API</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
</p>

## 🚙 Sobre o teste  

Criar uma aplicação web de frotas onde o módulo a ser desenvolvido pelo programador é um CRUD de automóveis que contenha autenticação via login e senha, e que o usuário final consiga fazer o seu cadastro para acesso ao sistema.

## Configuração do Projeto

Visual Studio code para desenvolver a aplicação, Java 11, Spring Boot 2.7.2, Maven para gerenciamento de dependências, Insomnia para testar as requisições da API e MySQL Database para banco de dados.


### Rotas da API

  - **Rota `/usuario`**: POST - Cadastro de usuários e retorno de login e e-mail já cadastrados.

  - **Rota `/usuario/cadastrados`**: GET -Retorna todo usuario cadastrado na API.

  - **Rota `/usuario/id`**: GET - Retorna o usuario cadastrado na API baseado no `id`.

  - **Rota `/automoveis`**: POST - Cadastro de automóveis e retorno da placa já cadastrada.

  - **Rota `/automoveis`**: GET - Retorna todo automóvel cadastrado na API.
  

### Feito by Joélia Rocha 💙.
