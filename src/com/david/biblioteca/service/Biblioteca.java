package com.david.biblioteca.service;

import com.david.biblioteca.model.Livro;
import com.david.biblioteca.model.Usuario;

import java.util.List;

public class Biblioteca {

    private List<Livro> listaLivros;
    private List<Usuario> listaUsuarios;

    public Biblioteca() {
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
        System.out.println("com.david.biblioteca.model.Livro, " + livro.getTitulo() + " adicionado com sucesso!");
    }

    public void removerLivro(String isbn) {

        Livro livroParaRemover = null;
        for (Livro c : listaLivros) {
            if (c.getIsbn().equals(isbn)) {
                livroParaRemover = c;
            }
        }
        if (livroParaRemover != null) {
            listaLivros.remove(livroParaRemover);
            System.out.println("com.david.biblioteca.model.Livro com ISBN, " + isbn + " removido com sucesso!");
        } else {
            System.out.println("Erro: com.david.biblioteca.model.Livro com ISBN " + isbn + " não encontrado na biblioteca.");
        }
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário, " + usuario.getNome() + " registrado com sucesso!");
    }

    public void emprestarLivro(String isbn, String idUsuario) {
        Livro livroParaEmprestar = null;

        // Iteração lista de livros
        for (Livro c : listaLivros) {
            if (c.getIsbn().equals(isbn)) {
                livroParaEmprestar = c;
                break;
            }
        }
        if (livroParaEmprestar == null) {
            System.out.println("Erro: O livro com ISBN," + isbn + " não foi encontrado.");
            return;
        }
        System.out.println("O livro com ISBN, " + isbn + " foi encontrado!");

        Usuario usuarioPermicao = null;

        // iteração lista de usuários
        for (Usuario c : listaUsuarios) {
            if (c.getIdUsuario().equals(idUsuario)) {
                usuarioPermicao = c;
                break;
            }
        }
        if (usuarioPermicao == null) {
            System.out.println("O usuário, " + idUsuario + " não foi encontrado.");
            return;
        }
        System.out.println("O usuário, " + idUsuario + " foi encontrado!");

            // verifica a disponíbilidade do livro
        if (!livroParaEmprestar.isDisponivel()) {
            System.out.println("Erro: O livro, " + livroParaEmprestar.getTitulo() + " está indisponível.");
            return;
        }
        System.out.println("com.david.biblioteca.model.Livro disponível para empréstimo.");

        livroParaEmprestar.emprestar();
        usuarioPermicao.pegarLivroEmprestado(livroParaEmprestar);

        System.out.println("Empréstimo realizado com sucesso! O livro '" + livroParaEmprestar.getTitulo() + "' foi emprestado para o usuário '" + usuarioPermicao.getNome() + "'.");
    }


    public void devolverLivro(String isbn, String idUsuario) {

        Livro livroEmprestado = null;

        for (Livro c : listaLivros) {
            if (c.getIsbn().equals(isbn)) {
                livroEmprestado = c;
                break;
            }
        }

        if (livroEmprestado == null) {
            System.out.println("Erro: com.david.biblioteca.model.Livro com isbn, " + isbn + " não está emprestado!");
            return;
        }

        System.out.println("O livro emprestado é, " + livroEmprestado.getTitulo());

        Usuario usuarioEncontrado = null;

        for (Usuario c : listaUsuarios) {
            if (c.getIdUsuario().equals(idUsuario)) {
                usuarioEncontrado = c;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Erro: O usuário, " + idUsuario + " não foi encontrado!");
            return;
        }
        System.out.println("Usuário, " + idUsuario + " foi encontrado com sucesso!");

    }

    public Livro buscarLivroPorTitulo(String Livro) {
        return null;
    }

    public Livro buscarLivroPorAutor(String autor) {
        return null;
    }

    public Usuario buscarUsuarioPorId(String idUsuario) {
        return null;
    }

    public void listarTodosLivros() {}

    public void listarTodosUsuarios() {

    }

    public boolean possuiLivroEmprestado(Livro livro) {
        return false;
    }

}
