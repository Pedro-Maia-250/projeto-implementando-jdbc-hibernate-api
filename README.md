# Hibernate

> Implementacao da camada de persistencia utilizando JPA/Hibernate.

Esta branch demonstra a aplicacao da arquitetura base utilizando:

- JPA com Hibernate ORM
- Maven, Hibernate Core/EntityManager e MySQL Connector/J
- MySQL (schema `hibernate`)

---

## Objetivo desta Implementacao

Esta versao resolve a persistencia do dominio de formas geometricas usando ORM,
reduzindo o trabalho manual de SQL e mapeamento.

A tecnologia foi escolhida para centralizar o mapeamento objeto-relacional por anotacoes,
permitir gerenciamento de entidades e simplificar operacoes de persistencia.

O foco arquitetural desta branch e demonstrar persistencia orientada a entidades JPA
com transacoes locais (`RESOURCE_LOCAL`) e consultas por JPQL.

---

## Estrutura de Camadas

Entities  
App (fluxo de persistencia e consulta)

Aplicacao nesta versao:

- `src/main/java/com/lunarvoid/entities`: entidades e modelo de dominio (`Forma`, `Circulo`, `Quadrado`, `Retangulo`)
- `src/main/resources/META-INF/persistence.xml`: configuracao da unidade de persistencia `java-jpa`
- `src/main/java/com/lunarvoid/App.java`: abertura de `EntityManager`, transacao, `persist` e consultas

Nao ha camada DAO/Repository dedicada nesta branch.

---

## Modelagem de Dominio

O dominio base permanece o mesmo:

- Forma (classe abstrata)
- Circulo
- Quadrado
- Retangulo
- TipoFormas (enum)

Adaptacoes para persistencia:

- `Forma` esta como `@MappedSuperclass`, compartilhando `id` e `tipo`
- Subclasses anotadas com `@Entity` e `@Table` (`circulo`, `quadrado`, `retangulo`)
- `tipo` e persistido com `@Enumerated(EnumType.STRING)`

---

## Estrategia de Persistencia

- Entidades sao persistidas com `EntityManager.persist(...)`
- O mapeamento e feito por anotacoes JPA nas classes de dominio
- A conexao e configurada no `persistence.xml` (`javax.persistence.jdbc.*`)
- Ha uso de ORM (Hibernate), sem SQL manual no fluxo principal da aplicacao
- Consultas sao realizadas com JPQL (`From Circulo`, `From Quadrado`, `From Retangulo`)

---

## Principais Caracteristicas Tecnicas

- [ ] Controle manual de conexao
- [x] Uso de ORM
- [ ] Injecao de dependencia
- [x] Transacoes automaticas
- [x] Queries customizadas
- [x] Separacao clara entre dominio e infraestrutura

---

## Vantagens desta Abordagem

- Menos boilerplate de persistencia comparado a JDBC puro
- Mapeamento declarativo com anotacoes
- Maior produtividade para evolucao de entidades
- Melhor manutencao para cenarios com mais regras de persistencia

---

## Limitacoes ou Desafios

- Curva de aprendizado maior em JPA/Hibernate
- Ajuste fino de performance exige conhecimento de ORM
- Dependencia de configuracao correta da unidade de persistencia
- O `pom.xml` mistura artefatos Hibernate de geracoes diferentes, o que pode causar incompatibilidades em evolucoes futuras

---

## Como Executar

### 1. Clonar o repositorio e acessar a branch

```bash
git clone <url-do-repositorio>
cd projeto-hibernate-dao-api
git checkout hibernate
```

### 2. Criar o banco de dados

```sql
CREATE DATABASE hibernate;
```

As tabelas sao geradas/atualizadas automaticamente por `hibernate.hbm2ddl.auto=update`.

### 3. Configurar credenciais

Ajuste os valores em `src/main/resources/META-INF/persistence.xml`:

- `javax.persistence.jdbc.url`
- `javax.persistence.jdbc.user`
- `javax.persistence.jdbc.password`

### 4. Executar a aplicacao

```bash
mvn clean compile exec:java
```

O `exec-maven-plugin` ja esta configurado para iniciar `com.lunarvoid.App`.
