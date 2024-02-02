# Curso Java Expert da plataforma DevSuperior #

Inicialmente foi criada uma API Rest denominada DS-catalog. Foi implementado um CRUD completo com camadas de desenvolvimento (Entities, Controllers, Repositories, Services e DTO). 

Posteriormente foram realizados os testes automatizados utilizando JUnit e Mockito.
- Os testes foram feitos com Fixtures para evitar repetições e melhor orgnanização (@BeforeAll, @AfterAll, @BeforeEach, @AfterEach).
- Foi criada uma classe Factory para a criação de entidades e DTOs utilizados nos testes, conferindo maior organização e melhor legibilidade.
- Banco de dados utilizado: H2.
- Camadas testadas: repositories, services, controllers.
  
Adiante, foi implementado login e controle de aceso utilizando JWT e OAuth2. 
- Foram realizados alguns testes de integração e foi criada uma classe utilitária (TokenUtil) para gerar um token dinâmico, permitindo que os testes requisições que exigem autenticação passem.
- Todos os endpoints também foram testados via postman durante o desenvolvimento da API.

Foi implementado caso de uso signup, fluxo de e-mail com SMTP do Gmail e de recuperação de senha, assim como a obtenção de usuário logado.

Foram realizados testes automatizados com JUnit e Mockito com JaCoCo no projeto <b>DSCommerce</b> para validação de cobertura. 
- Camadas testadas: <b>Authservice, CategoryService, ProductService, UserService, OrderService.</b>

Foram feitos desafios práticos referente ao conteúdo do curso. Todos os desafios passam pela avaliação e aprovação dos instrutores para a obtenção do certificado.
