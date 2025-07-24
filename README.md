# Sistema de Gerenciamento de Biblioteca em Java OOP para Iniciantes

## 📚 Visão Geral do Projeto

Este projeto é um Sistema de Gerenciamento de Biblioteca simples, desenvolvido em Java utilizando os princípios da Programação Orientada a Objetos (POO). Ele foi criado com o objetivo de servir como um projeto prático para iniciantes em Java, demonstrando conceitos fundamentais como:

- **Classes e Objetos:** Representação de entidades do mundo real (Livros, Usuários, Biblioteca) como objetos no código.
- **Encapsulamento:** Proteção dos dados internos das classes através de atributos privados e métodos públicos (getters e setters).
- **Abstração:** Foco nos detalhes essenciais de cada entidade, escondendo a complexidade interna.
- **Delegação de Responsabilidades:** Como as classes interagem e delegam tarefas umas às outras para realizar operações complexas (ex: a Biblioteca delega ao Livro a ação de `emprestar()` e ao Usuario a ação de `pegarLivroEmprestado()`).
- **Listas e Coleções:** Utilização de `ArrayList` para gerenciar coleções de objetos (Livros na Biblioteca, Usuários na Biblioteca, Livros emprestados por um Usuário).

## ✨ Funcionalidades Principais

O sistema permite realizar as seguintes operações básicas de uma biblioteca:

### Gerenciamento de Livros:
- Adicionar novos livros à biblioteca.
- Remover livros da biblioteca por ISBN.
- Exibir detalhes de um livro.

### Gerenciamento de Usuários:
- Registrar novos usuários.
- Remover usuários por ID.
- Exibir livros atualmente emprestados por um usuário.

### Gerenciamento de Empréstimos e Devoluções:
- Emprestar um livro a um usuário específico, verificando a disponibilidade.
- Devolver um livro, garantindo que o usuário realmente o possuía.
