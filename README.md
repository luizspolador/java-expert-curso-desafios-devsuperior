# Curso Java Expert da plataforma DevSuperior #

Inicialmente foi criada uma API Rest denominada DS-catalog. Foi implementado um CRUD completo com camadas de desenvolvimento (Entities, Controllers, Repositories, Services e DTO). 

Posteriormente foram realizados os testes automatizados utilizando JUnit e Mockito.
- Os testes foram feitos com Fixtures para evitar repetições e melhor orgnanização (@BeforeAll, @AfterAll, @BeforeEach, @AfterEach).
- Foi criada uma classe Factory para a criação de entidades e DTOs utilizados nos testes, conferindo maior organização e melhor legebilidade.
- Banco de dados utilizado: H2.
- Camadas testadas: repositories, services, controllers.
- Foi implementado login e controle de aceso utilizando JWT e OAuth2. 
- Foram realizados alguns testes de integração e foi criada uma classe utilitária (TokenUtil) para gerar um token dinâmico, permitindo que os testes requisições que exigem autenticação passem.
- Todos os endpoints foram testados via postman durante o desenvolvimento da API.

Foi implementado caso de uso signup, fluxo de e-mail com SMTP do Gmail e de recuperação de senha, assim como a obtenção de usuário logado.

Foram realizados testes automatizados com JaCoCo no projeto DSCommerce para validação de cobertura.
