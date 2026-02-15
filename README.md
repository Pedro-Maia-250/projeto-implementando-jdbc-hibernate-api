# DAO

> Implementacao da camada de persistencia utilizando JDBC.

Esta branch demonstra a aplicacao da arquitetura base utilizando:

- JDBC (Java Database Connectivity)
- Maven, MySQL Connector/J e JUnit 5
- MySQL/MariaDB (schema `javadao`, script `javadao.sql`)

---

## Objetivo desta Implementacao

Esta versao resolve a persistencia das formas geometricas com DAOs dedicados por tipo,
mantendo regras de dominio separadas de acesso a dados.

A tecnologia JDBC foi escolhida para dar controle direto sobre conexoes, SQL e fluxo de persistencia,
com baixo acoplamento a frameworks.

O foco arquitetural e explicitar a camada DAO e o contrato de persistencia por entidade.

---

## Estrutura de Camadas

Entities  
DAO / Repository  
Factory de DAO  
App (ponto de entrada para execucao)

Aplicacao nesta versao:

- `src/main/java/com/lunarvoid/entities`: modelo de dominio (`Forma`, `Circulo`, `Quadrado`, `Retangulo`)
- `src/main/java/com/lunarvoid/dao`: contratos DAO e fabrica (`DaoFactoryForma`)
- `src/main/java/com/lunarvoid/dao/impl`: implementacoes JDBC (`CirculoJDBC`, `QuadradoJDBC`, `RetanguloJDBC`)
- `src/main/java/com/lunarvoid/db/DB.java`: provedor de conexao compartilhada via `DriverManager`
- `src/main/java/com/lunarvoid/App.java`: uso da camada DAO para insert e listagem

Nao ha camada de controller/resource nesta branch.

---

## Modelagem de Dominio

O dominio base permanece o mesmo:

- Forma (classe abstrata)
- Circulo
- Quadrado
- Retangulo
- TipoFormas (enum)

Adaptacoes para persistencia:

- Cada subtipo possui tabela propria (`circulo`, `quadrado`, `retangulo`)
- Persistencia orientada a composicao por DAO especifico, sem heranca ORM
- O script `javadao.sql` cria estrutura com `id` auto incremento e colunas de medidas

---

## Estrategia de Persistencia

- Entidades sao persistidas via comandos SQL `INSERT` em DAOs especificos
- Leitura e feita via `SELECT *` + mapeamento manual de `ResultSet` para objetos de dominio
- Conexoes sao obtidas por `DB.getConnection()` usando `DriverManager` e propriedades de configuracao
- Nao ha ORM nesta implementacao; o acesso e SQL manual com `PreparedStatement`

---

## Principais Caracteristicas Tecnicas

- [x] Controle manual de conexao
- [ ] Uso de ORM
- [ ] Injecao de dependencia
- [ ] Transacoes automaticas
- [x] Queries customizadas
- [x] Separacao clara entre dominio e infraestrutura

---

## Vantagens desta Abordagem

- Maior controle sobre SQL e performance por consulta
- Baixa dependencia de frameworks de persistencia
- Facilidade de entender o fluxo de dados ponta a ponta
- Estrutura objetiva para cenarios pequenos e didaticos

---

## Limitacoes ou Desafios

- Mais verbosidade e codigo repetitivo (CRUD manual por entidade)
- Necessidade de gerir detalhes de conexao e erros SQL manualmente
- Menor produtividade para evolucoes complexas em comparacao com ORM
- Ausencia de transacoes declarativas e gerenciamento de contexto de persistencia
- O codigo atual le `db.properties`, mas o projeto possui `application-dev.properties`; e necessario alinhar essa configuracao para execucao sem erro

---

## Como Executar

### 1. Clonar o repositorio e acessar a branch

```bash
git clone <url-do-repositorio>
cd projeto-hibernate-dao-api
git checkout dao
```

### 2. Criar o banco e tabelas

```bash
mysql -u root -p < javadao.sql
```

### 3. Configurar credenciais de banco

Crie `src/main/resources/db.properties` com o conteudo:

```properties
db.url=jdbc:mysql://localhost:3306/javadao?useSSL=false&serverTimezone=UTC
db.user=root
db.password=
```

### 4. Executar a aplicacao

```bash
mvn clean compile exec:java -Dexec.mainClass=com.lunarvoid.App
```

Se o plugin `exec-maven-plugin` nao estiver configurado no seu ambiente, execute pela IDE usando a classe `App`.
