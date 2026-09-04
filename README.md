# ProductGo

API REST para cadastro e gerenciamento de produtos, desenvolvida com Spring Boot.

## Tecnologias

- Java 21
- Spring Boot 3.5.10
- Spring Web
- Spring Data JPA
- H2 Database
- Maven Wrapper
- Lombok

## Pré-requisitos

- JDK 21 ou superior
- Git

O projeto inclui o Maven Wrapper, portanto não é necessário instalar o Maven separadamente.

## Como executar

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/CassioPassosP/springLearn.git
cd productGo
```

No Windows, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS, execute:

```bash
./mvnw spring-boot:run
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

## Testes

Para executar os testes automatizados:

```powershell
.\mvnw.cmd test
```

No Linux ou macOS:

```bash
./mvnw test
```

## API

A entidade `Produto` possui os seguintes campos:

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | `String` | Identificador único gerado pela API |
| `name` | `String` | Nome do produto |
| `descricao` | `String` | Descrição do produto |
| `preco` | `Number` | Preço do produto |

### Criar produto

`POST /produtos`

```bash
curl -X POST http://localhost:8080/produtos ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"Notebook\",\"descricao\":\"Notebook para estudos\",\"preco\":3500.00}"
```

Exemplo de resposta:

```json
{
  "id": "gerado-pela-api",
  "name": "Notebook",
  "descricao": "Notebook para estudos",
  "preco": 3500.0
}
```

### Buscar produtos por nome

`GET /produtos?name={nome}`

```bash
curl "http://localhost:8080/produtos?name=Notebook"
```

### Buscar produto por ID

`GET /produtos/{id}`

```bash
curl http://localhost:8080/produtos/ID_DO_PRODUTO
```

### Atualizar produto

`PUT /produtos/{id}`

```bash
curl -X PUT http://localhost:8080/produtos/ID_DO_PRODUTO ^
  -H "Content-Type: application/json" ^
  -d "{\"name\":\"Notebook atualizado\",\"descricao\":\"Nova descricao\",\"preco\":3200.00}"
```

### Excluir produto

`DELETE /produtos/{id}`

```bash
curl -X DELETE http://localhost:8080/produtos/ID_DO_PRODUTO
```

## Banco de dados H2

A aplicação utiliza um banco H2 em memória. A tabela `produto` é criada a partir do arquivo `src/main/resources/data.sql` e os dados são perdidos quando a aplicação é encerrada.

O console do H2 está disponível em:

```text
http://localhost:8080/h2-console
```

Use os dados abaixo para conexão:

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:produtos` |
| Usuário | `sa` |
| Senha | `password` |

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/io/github/cs/productGo/
│   │   ├── controller/ProdutoController.java
│   │   ├── model/Produto.java
│   │   ├── repository/ProdutoRepository.java
│   │   └── ProductGoApplication.java
│   └── resources/
│       ├── application.yml
│       └── data.sql
└── test/
    └── java/io/github/cs/productGo/
        └── ProductGoApplicationTests.java
```

## Licença

Este projeto foi desenvolvido para fins de estudo.
