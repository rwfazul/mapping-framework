# mysql-mongodb
ELC1071 Disciplina de Projeto e Gerência de Banco de Dados | 5° semestre do curso de Sistemas de Informação UFSM
#### Grupo: Isabella Sakis, Rhauani Fazul

#### Contexto da aplicação

Sistema para auxílio no gerenciamento de eventos na Universidade Federal de Santa Maria (UFSM). Um evento pode ser realizado fora ou dentro da universidade, caso seja interno, um dos prédios disponíveis na UFSM deve ser escolhido como sede principal do evento. 
Ao cadastrar um evento, o administrador do sistema pode adicionar as palestras que irão fazer parte de sua programação. Todas as palestras são realizadas em alguma sala, possuem um palestrante e fazem parte de um evento. 

#### Objetivo

Criar uma aplicação que consiga se comunicar com dois SGBDs diferentes, sendo um relacional e um orientado a documento.

O sistema deve ser projetado de modo que haja separação entre as camadas de persistência e aplicação, possibilitando que a mesma aplicação funcione independente do banco de dados, trocando apenas a camada de persistência. Em uma aplicação onde essas camadas são independentes, é possível trocar a forma com que os dados são persistidos, sem que isso influencie nos detalhes de exibição dos dados.

- O sistema deve ser usado em navegador Web;
- O sistema pode possuir mais de um CRUD, embora isso não seja necessário;
- A troca entre SGBDs deve ser feita a partir de uma funcionalidade própria da aplicação.

#### Uso:

- Executar scripts para criação do banco de dados relacional (PGBD/src/main/java/banco/relacional/mysql/sql/eventos_dql.sql);
- As classes 'BdMongo.java' e' BdMySQL.java' dentro do pacote 'banco' devem ser modificadas de acordo com a configuração da base de dados;
- As depêndencias são gerenciadas pelo Maven, logo não é preciso adicionar .JARs na BuildPath do projeto;
- O chaveamento dos SGBDs é realizado no controller 'DBConfig.java'.

------------------------------------------------------------------

#### Dev

- Para realizar a divisão em camadas sem o uso de frameworks foram adotados diversos padrões de projeto (Design Pattern) para a estruturação da aplicação. A análise do código irá mostrar alguns padrões e técnicas, como por exemplo:
	- Data Access Object (DAO); 
	- Abstract Factory;
	- Singleton;
	- Conversores e comparadores;
	- Classes genéricas com inferência de tipo e parâmetros limitados;
	- Classes abstratas e interfaces de uso comum aos dois SGBDs.

- SGBDS escolhidos:
	+ Relacional
		- MySQL
	+ NoSQL orientado a documento
		- MongoDB

- LP escolhida:
	+ Java 	(Plataforma Java EE);

- Servidor de aplicação:
	+ Glassfish;

- Container e APIs:
	+ JDBC e MongoDB Java Driver;
	+ Servlets (juntamente com JavaServer Pages - JSPs);

- Gerenciamento de dependências:
	+ Maven.

- Foi optado por não utilizar frameworks como Spring e Hibernate.

#### Apresentação

- Detalhes pertinentes quanto à implementação:
	+ Decisões de projeto;
	+ Arquitetura;
	+ Apis usadas;
	+ SGBDs usados;
- A execução da ferramenta.
