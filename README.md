# 🚀 Spring Security Template - Thalisson Damião

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring)
![Spring Security](https://img.shields.io/badge/Spring_Security-6.x-red?style=for-the-badge&logo=springsecurity)
![JWT](https://img.shields.io/badge/JWT-Auth-black?style=for-the-badge&logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

## 📖 Sobre o Projeto

Este projeto é um **Boilerplate de Autenticação e Autorização** robusto, desenvolvido com **Spring Boot** e **Spring Security**. Ele implementa as melhores práticas de segurança modernas, incluindo:
- **Autenticação Stateless** via JWT (JSON Web Tokens).
- **Controle de Acesso Baseado em Funções (RBAC)** dinâmico.
- **Gerenciamento Completo de Usuários e Roles**.
- **Tratamento Global de Exceções**.

O objetivo é servir como uma base sólida e escalável para iniciar novos projetos que necessitem de um sistema de segurança confiável desde o primeiro dia.

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas bem definida para garantir a manutenibilidade e escalabilidade:

```text
spring-security/
├── src/main/java/com/springsecurity/
│   ├── controllers/      # Camada de Apresentação (REST APIs)
│   ├── services/         # Regras de Negócio
│   ├── repositories/     # Acesso a Dados (JPA)
│   ├── models/
│   │   ├── entity/       # Entidades do Banco de Dados (User, Role)
│   │   └── dto/          # Objetos de Transferência de Dados (Requests/Responses)
│   ├── mappers/          # Conversores Entity <-> DTO (MapStruct)
│   ├── infra/
│   │   ├── security/     # Configurações de Segurança (Filter, TokenService)
│   │   └── config/       # Configurações Gerais
│   ├── handlers/         # Tratamento Global de Erros
│   └── exceptions/       # Exceções Personalizadas
└── src/main/resources/
    └── application.yaml  # Configurações da Aplicação
```

## 🚀 Tecnologias Utilizadas

### Backend Core
- **Java 21**: Versão LTS mais recente para alta performance.
- **Spring Boot 3+**: Framework base para desenvolvimento ágil.
- **Spring Security 6**: Framework de segurança padrão de mercado.
- **Spring Data JPA**: Abstração para persistência de dados.
- **H2 Database**: Banco de dados em memória para desenvolvimento rápido (facilmente substituível por PostgreSQL/MySQL).

### Ferramentas & Utilitários
- **JWT (Java-JWT)**: Geração e validação segura de tokens.
- **Lombok**: Redução de boilerplate code (Getters, Setters, Builders).
- **MapStruct**: Mapeamento eficiente entre Entidades e DTOs.
- **Bean Validation**: Validação automática de dados de entrada.
- **Maven**: Gerenciamento de dependências e build.

## ⚙️ Instalação e Configuração

### Pré-requisitos
- **Java 21** instalado.
- **Maven** instalado (ou use o wrapper `mvnw` incluído).

### Passo a Passo

1. **Clone o repositório**
```bash
git clone https://github.com/Thalisson-DEV/spring-security-boilerplate.git
cd spring-security-boilerplate
```

2. **Configure as variáveis de ambiente (Opcional)**
   O projeto vem configurado com defaults seguros para desenvolvimento em `src/main/resources/application.yaml`.

3. **Execute a aplicação**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Acesse a API**
   - Base URL: [http://localhost:8080](http://localhost:8080)
   - H2 Console (Banco de Dados): [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 📱 Funcionalidades & Endpoints

### Autenticação (`/auth`)
- **POST /auth/login**: Autentica um usuário e retorna um JWT.
- **POST /auth/register**: Cria uma nova conta de usuário.

### Usuários (`/users`)
- **GET /users/me**: Retorna os dados do usuário logado.
- **GET /users**: Lista todos os usuários (Requer role ADMIN).

### Gerenciamento de Roles (`/roles`)
- **POST /roles**: Cria uma nova role no sistema.
- **GET /roles**: Lista todas as roles disponíveis.

### Teste (`/hello-world`)
- **GET /hello-world**: Endpoint público para teste de disponibilidade.

## 🛡️ Segurança

- **BCrypt**: Hashing de senhas antes da persistência.
- **Stateless Session**: O servidor não armazena estado da sessão, garantindo escalabilidade.
- **CORS Config**: Configurado para permitir integração com frontends modernos.
- **Protection**: Proteção contra CSRF (desabilitado para APIs stateless conforme padrão), e headers de segurança padrão.

## 🧪 Desenvolvimento Local

Para rodar os testes unitários e de integração:

```bash
./mvnw test
```

## 🤝 Contribuição

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/NovaFeature`)
3. Faça o Commit (`git commit -m 'feat: Adiciona nova feature'`)
4. Faça o Push (`git push origin feature/NovaFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto é desenvolvido para fins de estudo e portfólio.

---
<p align="center">
  Desenvolvido com ☕ e muito código por <strong>Thalisson Damião</strong>
</p>
