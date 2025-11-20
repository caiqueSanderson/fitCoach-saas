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

### Aluno
- `POST /alunos` → Cadastrar trainee

```
{
  "nome": "João Silva",
  "idade": 25,
  "peso": 70,
  "altura": 1.75
}
```

- `GET /alunos/{id}` → Consultar trainee

### Anamnese
- `POST /medicalHistory` → Registrar respostas

```
{
  "alunoId": 1,
  "respostas": {
      "objetivo": "perda de peso",
      "frequenciaExercicio": "3x por semana"
  }
}
```
### Treinos
- `GET /treinos/{alunoId}` → Consultar treino