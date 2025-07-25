package com.david.biblioteca.service;

import com.david.biblioteca.model.Livro;
import com.david.biblioteca.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> listaLivros;
    private List<Usuario> listaUsuarios;

    public Biblioteca() {
        this.listaLivros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
        System.out.println("Livro com o titulo, " + livro.getTitulo() + " adicionado com sucesso!");
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
            System.out.println("Livro com ISBN, " + isbn + " removido com sucesso!");
        } else {
            System.out.println("Erro: Livro com ISBN " + isbn + " não encontrado na biblioteca.");
        }
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
        System.out.println("Usuário, " + usuario.getNome() + " registrado com sucesso!");
    }

    public void removerUsuario(String idUsuario) {
        Usuario removerUsuario = null;

        for (Usuario u : listaUsuarios) {
            if (u.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                removerUsuario = u;
                break;
            }
        }
        if (removerUsuario != null) {
            listaUsuarios.remove(removerUsuario);
            System.out.println("Usuário com ID '" + idUsuario + "' foi removido com sucesso!");
        } else {
            System.out.println("Error: Usuário com ID '" + idUsuario + "' não foi encontrado na biblioteca.");
        }
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
        System.out.println("Livro disponível para empréstimo.");

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
            System.out.println("Erro: Livro com isbn, " + isbn + " não está emprestado!");
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

        livroEmprestado.devolver();
        usuarioEncontrado.devolverLivro(livroEmprestado);

        System.out.println("O livro foi devolvido com sucesso!");
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        Livro livroBuscado = null;

        for (Livro c : listaLivros) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                livroBuscado = c;
                break;
            }
        }
        if (livroBuscado != null) {
            System.out.println("Livro " + livroBuscado.getTitulo() +"encontrado com sucesso!");
        } else {
            System.out.println("Erro: livro com título " + titulo + " não foi encontrado na Biblioteca.");
        }
        return livroBuscado;
    }

    public List<Livro> buscarLivroPorAutor(String autor) {

        List<Livro> livrosEncontradorPorAutor = new ArrayList<>();

        for (Livro c : listaLivros) {
            if (c.getAutor().equalsIgnoreCase(autor)) {
                livrosEncontradorPorAutor.add(c);
            }
        }

        if (!livrosEncontradorPorAutor.isEmpty()) {
            System.out.println("Foram encontrados " + livrosEncontradorPorAutor.size() + " livros do autor " + autor);
        } else {
            System.out.println("Erro: O livro com o autor '" + autor + "' não foi encontrado!");
        }
        return livrosEncontradorPorAutor;
    }

    public Usuario buscarUsuarioPorId(String idUsuario) {
        Usuario usuarioEncontrado = null;

        for (Usuario u : listaUsuarios) {
            if (u.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado != null) {
            System.out.println("O usuário " + usuarioEncontrado.getIdUsuario() + " foi encontrado com sucesso!");
        } else {
            System.out.println("Erro: O usuário " + idUsuario + " não foi encontrado!");
        }
        return usuarioEncontrado;
    }

    public void listarTodosLivros() {
        if (listaLivros.isEmpty()) {
            System.out.println("A biblioteca não possui nenhum livro cadastrado no momento!");
        } else {
            System.out.println("--- Livros Atualmente na Biblioteca ---");

            for (Livro l : listaLivros) {
                l.exibirDetalhes();
            }
            System.out.println("--------------------------------------");
        }
    }

    public void listarTodosUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado no momento!");
        } else {
            System.out.println("--- Lista de usuários ---");

            for (Usuario u : listaUsuarios) {
                u.exibirDetalhes();
            }
            System.out.println("--------------------------------------");
        }
    }
}
