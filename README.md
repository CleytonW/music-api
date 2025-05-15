# music-api

Este projeto é uma API REST simples para cadastro de músicas, feita para fins de aprendizado. Aqui você pode cadastrar, listar, atualizar e remover músicas usando requisições HTTP. O projeto foi feito usando Spring Boot, Java 21, JPA, Flyway e banco de dados MySQL.

## Funcionalidades
- Listar todas as músicas
- Buscar música por ID
- Cadastrar nova música
- Atualizar apenas a duração de uma música
- Remover música por ID

## Como rodar o projeto
1. **Pré-requisitos:**
   - Java 21 instalado
   - MySQL rodando na porta padrão (3306)
   - Maven instalado
2. **Configuração do banco:**
   - O projeto já está configurado para criar a tabela e inserir alguns dados iniciais automaticamente usando Flyway.
   - As configurações de acesso ao banco estão no arquivo `src/main/resources/application.properties`.
3. **Rodando o projeto:**
   - No terminal, execute:
     ```
     ./mvnw spring-boot:run
     ```
     ou, no Windows:
     ```
     .\mvnw.cmd spring-boot:run
     ```

## Endpoints principais
- `GET /musica` — Lista todas as músicas
- `GET /musica/{id}` — Busca uma música pelo ID
- `POST /musica` — Cadastra uma nova música (enviar JSON no corpo)
- `PUT /musica/{id}/atualizar` — Atualiza só a duração da música
- `DELETE /musica/{id}` — Remove uma música

### Exemplo de JSON para cadastro
```json
{
  "nome": "Nome da música",
  "artista": "Nome do artista",
  "data_lancamento": "01/01/2020",
  "duracao": "03:30"
}
```

## Observações
- O projeto é simples e serve para quem está começando a aprender sobre APIs REST com Spring Boot.
- Se quiser mudar o banco, altere as configurações no `application.properties`.
- O código está comentado para facilitar o entendimento.

---

Se tiver dúvidas, pode abrir uma issue ou olhar os comentários no código.
