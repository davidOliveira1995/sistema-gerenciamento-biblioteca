package com.david.biblioteca.model;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private String genero;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, String genero, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void emprestar() {
        if (disponivel != false) {
            System.out.println("Você obteve o com.david.biblioteca.model.Livro emprestado!");
            disponivel = false;
        } else {
            System.out.println("Este livro não está disponível!");
        }
    }

    public void devolver() {
        if (disponivel != true) {
            System.out.println("Você devolveu o livro, obrigado!");
            disponivel = true;
        } else {
            System.out.println("Esse livro não está emprestado!");
        }
    }

    public void exibirDetalhes() {
        String disponibilidade = "indisponível";
        if (disponivel != false) {
            disponibilidade = "disponível";
        }

        System.out.println("O livro, " + this.titulo + " está " + disponibilidade);
        System.out.println("Autor: " + this.autor);
        System.out.println("isbn: " + this.isbn);
        System.out.println("Ano de publicação: " + this.anoPublicacao);
        System.out.println("Genero: " + this.genero);
    }


}
