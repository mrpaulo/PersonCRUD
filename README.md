PersonCRUD

Este é um projeto em Java Spring Boot de um cadastro de pessoas com uma autenticação basic e para persistir os dados foi usado o PostgresSQL.
Possui as seguintes características de cadastro e validações nele:
- Nome com no máximo 100 caracteres e de preenchimento obrigatório;
- CPF com um número válido, não pode ter outra pessoa já cadastrada com o mesmo número e de preenchimento obrigatório;
- Data de nascimento ser uma data válida e não posterior a data do cadastro e de preenchimento obrigatório;
- E-mail com no máximo 100 caracteres;
- Informação de sexo, M para masculino e F para feminino;
- Informação de cidade de nascimento com no máximo 100 caracteres;
- Informação de país de nascimento com no máximo 100 caracteres;

O PersonCRUD integra com meu projeto Front Person CRUD [https://github.com/mrpaulo/front_person_crud] (front_person_crud)que foi feito em ReactJS e para fazer a ligação entre os dois foi utilizado o Nginx..

Foram feitas as configurações necessárias para criar uma imagem dele com Docker e colocá-lo em um conteiner para rodar juntamente com o Front Person CRUD (frontend);

Instruções para instalação: visite https://github.com/mrpaulo/front_person_crud e siga de lá! 	