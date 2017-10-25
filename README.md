# mysql-mongodb
ELC1071 Disciplina de Projeto e Gerência de Banco de Dados | 5° semestre do curso de Sistemas de Informação UFSM
#### Grupo: Isabella Sakis, Rhauani Fazul
	
Em desenvolvimento...

#### Descrição

Criar uma aplicação que consiga se comunicar com dois SGBDs diferentes, sendo um relacional e um orientado a documento.

O sistema deve ser projetado de modo que haja separação entre as camadas de persistência e aplicação, possibilitando que a mesma aplicação funcione independente do banco de dados, trocando apenas a camada de persistência. Em uma aplicação onde essas camadas são independentes, é possível trocar a forma com que os dados são persistidos, sem que isso influencie nos detalhes de exibição dos dados.

- O sistema deve ser usado em navegador Web;
- O sistema pode possuir mais de um CRUD, embora isso não seja necessário;
- A troca entre SGBDs deve ser feita a partir de uma funcionalidade própria da aplicação.

#### Uso:
...
...
...

------------------------------------------------------------------

#### Apresentação

- Detalhes pertinentes quanto à implementação:
	+ Decisões de projeto;
	+ Arquitetura;
	+ Apis usadas;
	+ SGBDs usados;
- A execução da ferramenta.

#### Dev

- Foi escolhido realizar a divisão em camadas a partir da estaca zero (sem uso de frameworks), para isso foram utilizados aguns padrões de projeto, como por exemplo:
	+ DAO;
	+ Abstract Factory;
	+ Singleton.

- SGBDS escolhidos:
	+ Relacional
		- MySQL
	+ NoSQL orientado a documento
		- MongoDB

- LP escolhida:
	+ Java Web.

- Gerenciamento de dependências:
	+ Maven.
