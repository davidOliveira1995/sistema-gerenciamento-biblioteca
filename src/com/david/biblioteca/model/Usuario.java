package com.david.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    String nome;
    String idUsuario;
    private List<Livro> livrosEmprestados;

    public Usuario(String nome, String idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void pegarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
        System.out.println("O livro, " + livro.getTitulo() + " foi adicionado aos empr´stimos do usuário, " + this.getNome());
    }

    public void devolverLivro(Livro livro) {

        Livro livroEncontradoNaLista = null;

        for (Livro l : livrosEmprestados) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                livroEncontradoNaLista = l;
                break;
            }
        }

        if (livroEncontradoNaLista != null) {
            livrosEmprestados.remove(livroEncontradoNaLista);
            System.out.println("com.david.biblioteca.model.Livro '" + livro.getTitulo() + "' devolvido com sucesso!");
        }
        else {
            System.out.println("Erro: O livro '" + livro.getTitulo() + "' não foi encontrado nos empréstimos deste usuário.");
        }
    }

    public void exibirLivrosEmprestados() {
        System.out.println("--- Livros emprestados por " + this.getNome() + " ---");

        if (!livrosEmprestados.isEmpty()) {
            System.out.println("Livros emprestados por, " + this.getNome());
            for (Livro l : livrosEmprestados) {
                System.out.println("com.david.biblioteca.model.Livro: " + l.getTitulo());
            }
        } else {
            System.out.println("No momento, " + this.getNome() + " não possui nenhum livro emprestado.");
        }
        System.out.println(" ------------------------------------------- ");
    }


}
