# FitCoach SaaS - Monólito Spring Boot

## 🎯 Objetivo da Etapa
Desenvolver uma aplicação monolítica simples em **Spring Boot**, que permita cadastrar alunos, registrar medicalHistory e montar treinos básicos. Esta etapa prepara a base para evoluir para um Micro SaaS no futuro.

---

## 📌 Subcompetências Desenvolvidas
- Implementação de aplicação em Spring Boot com **camadas Controller, Service e Repository**.
- Criação de **APIs REST** usando Spring MVC.
- Aplicação de princípios de **código limpo e SOLID**.
- Modelagem de domínio simplificada (DDD): domínios, subdomínios e bounded contexts.
- Gerenciamento de dependências com **Maven**.

---

## 🏗️ Estrutura da Aplicação

### Camadas
- **Controller:** Recebe requisições HTTP
- **Service:** Regras de negócio
- **Repository:** Persistência de dados
- **Entity:** Modelagem das tabelas

### Domínio e Subdomínios
- **Domínio:** Gestão de Treinos
- **Subdomínios:**
    - Alunos: cadastro e medicalHistory
    - Exercícios: cadastro simples
    - Treinos: associação de exercícios a alunos

### Diagrama de Sequência Simplificado
Aluno -> AnamneseController -> AnamneseService -> AnamneseRepository -> Banco de Dados
Banco de Dados -> AnamneseRepository -> AnamneseService -> AnamneseController -> Aluno

---

## ⚙️ Tecnologias
- Java 21, Spring Boot 3.5.4
- PostgreSQL (ou H2 para teste rápido)
- Maven
- JUnit 5
- Git + GitHub

---

## 🔌 Endpoints Implementados

### Role Instructor
- `POST /instructor/trainee` → Cadastrar trainee

```
{
  "nome": "João Silva",
  "cpf": "XXX.XXX.XXX-XX"
}
```

- `GET /instructor/trainee/` → Ver todos os trainee
- `GET /instructor/trainee/{id}` → Ver um trainee em especifico
- `GET /instructor/history/{traineeId}` → Ver anamnese do trainee

### Role Trainee
- `GET /trainee/history/{id}` → Responder a anamnese
- `GET /workout/{id}` → Ver o treino associado ao trainee