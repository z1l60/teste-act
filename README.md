# Como executar o projeto

Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/z1l60/teste-act.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

Projeto está salvando no mongoDb no perfil de teste na porta 27017.

Requisições funcionando:

http://localhost:8080/usuario/salvar  
http://localhost:8080/usuario/{cep}  
http://localhost:8080/get/{cep}

Salva um usuário enviando um payload de entrada no seguinte formato:  

{
    "nomeUsuario": "Zildo",
    "dataDeNascimento": "16-07-1996",
    "cep": "88080901",
    "documento": "105.210.839-31"
}

Salva no banco:  

{
    "id": "60a523a5c04e4f5f51f1064c",
    "nomeUsuario": "Zildo",
    "dataDeNascimento": "16-07-1996",
    "cidade": "Florianópolis",
    "bairro": "Coqueiros",
    "estado": "SC",
    "documento": "105.210.839-31"
}

