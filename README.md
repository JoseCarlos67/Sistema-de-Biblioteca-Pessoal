# 📚 Sistema de Biblioteca Pessoal

![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-purple?logo=intellij-idea&logoColor=white)
![POO](https://img.shields.io/badge/Paradigma-POO-orange)
![Status](https://img.shields.io/badge/Status-Concluído-green)

Um sistema de gerenciamento de biblioteca pessoal desenvolvido em **Java** para praticar conceitos de **Programação Orientada a Objetos (POO)**.

---

## 🎯 Objetivo

O projeto foi criado para fortalecer o aprendizado em **Java**, simulando um sistema de gerenciamento de biblioteca pessoal via **terminal**.
O sistema permite **cadastrar livros, autores e usuários (amigos)** e **gerenciar empréstimos** de forma simples e organizada.

---

## ⚙️ Funcionalidades

- 📖 **Cadastro de Livros:** Registro completo com título, gênero e data de publicação.
- ✍️ **Cadastro de Autores:** Os autores são cadastrados durante o registro dos livros.
- 👥 **Cadastro de Usuários:** Registro de amigos para controle de empréstimos.
- 🔄 **Empréstimos:** Sistema com data de devolução automática (7 dias após o empréstimo).
- 📊 **Relatórios:** Exibição do estado atual da biblioteca, incluindo todos os livros cadastrados e os empréstimos ativos.

---

## 🚀 Tecnologias Utilizadas

- **Linguagem:** Java (Zulu 17 LTS)
- **IDE:** IntelliJ IDEA
- **Paradigma:** Programação Orientada a Objetos (POO)

---

## 📋 Conceitos de POO Praticados

- **Classes e Objetos:** Modelagem de entidades como `Book`, `Author`, `User`, `Loan`.
- **Enumeração:** `BookGenre` para categorização de livros.
- **Tratamento de Exceções:** `DomainException` para regras de domínio personalizadas.
- **Encapsulamento, Herança e Polimorfismo:**
  - Encapsulamento com modificadores de acesso (`private`, `protected`, `public`).
  - Herança: `Person → User` e `Person → Author`.
  - Polimorfismo com classes abstratas.
- **Composição:**
  - `Library` composta por listas de `Book`, `User`, `Loan`.
  - `Loan` composto por `Book` e `User`.
  - `Book` composto por `Author`.
- **Composição vs. Herança:** Uso consciente de ambos os conceitos.
- **Pacotes e Organização de Código:** Estrutura modular (`entities`, `enums`, `exceptions`, `application`).
- **LocalDate:** Manipulação de datas para publicação e controle de empréstimos.

---

## 📁 Estrutura do Projeto

```
src/
├── application/
│   └── Program.java          # Classe principal e interface do usuário
├── entities/
│   ├── Library.java          # Gerenciamento principal da biblioteca
│   ├── Book.java             # Entidade livro
│   ├── Author.java           # Entidade autor
│   ├── User.java             # Entidade usuário
│   ├── Person.java           # Classe abstrata pessoa
│   └── Loan.java             # Entidade empréstimo
├── enums/
│   └── BookGenre.java        # Enumeração de gêneros literários
└── exceptions/
    └── DomainException.java  # Exceção personalizada para regras de domínio
```

---

## 🎮 Como Executar

### 🔧 Pré-requisitos
- **Java JDK 17** (Zulu LTS recomendado)
- **IDE:** IntelliJ IDEA ou qualquer editor com suporte a Java

### ▶️ Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoseCarlos67/Sistema-de-Biblioteca-Pessoal.git
   ```
2. Abra o projeto na sua IDE.
3. Execute a classe `Program.java`, localizada em `src/application/`.
4. Caso queira digitar manualmente, comente a linha 18 e 19 na classe Program.

---

## 📝 Regras de Negócio

✅ Um autor só pode ser cadastrado durante o cadastro de um livro.  
✅ A data de devolução é sempre **7 dias após o empréstimo**. 

---

## 👨‍💻 Desenvolvido por

**José Carlos da Silva Esteves**  
[GitHub: @JoseCarlos67](https://github.com/JoseCarlos67)
