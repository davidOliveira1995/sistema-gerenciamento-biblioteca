import com.david.biblioteca.model.Livro;
import com.david.biblioteca.model.Usuario;
import com.david.biblioteca.service.Biblioteca;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        // Adicionando alguns dados iniciais para facilitar o teste
        Livro livro1 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "978-8578270690", 1943, "Ficção Infantil");
        Livro livro2 = new Livro("1984", "George Orwell", "978-8535914849", 1949, "Distopia");
        Livro livro3 = new Livro("Dom Casmurro", "Machado de Assis", "978-8573260790", 1899, "Romance");
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);

        Usuario user1 = new Usuario("Alice Silva", "U001");
        Usuario user2 = new Usuario("Bob Santos", "U002");
        biblioteca.registrarUsuario(user1);
        biblioteca.registrarUsuario(user2);

        boolean programaFinalizado = false;

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Biblioteca!");

        do {

            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Adicionar Novo Livro");
            System.out.println("2. Registrar Novo Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Buscar Livro por Título");
            System.out.println("6. Buscar Livro por Autor");
            System.out.println("7. Buscar Usuário por ID");
            System.out.println("8. Listar Todos os Livros");
            System.out.println("9. Listar Todos os Usuários");
            System.out.println("10. Exibir Livros Emprestados de um Usuário");
            System.out.println("11. Remover Livro");
            System.out.println("12. Remover Usuário");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1: // Adicionar Novo Livro
                    System.out.print("Título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Autor: ");
                    String autor = scan.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Ano de Publicação: ");
                    int ano = scan.nextInt();
                    scan.nextLine(); // Consome a quebra de linha
                    System.out.print("Gênero: ");
                    String genero = scan.nextLine();

                    Livro novoLivro = new Livro(titulo, autor, isbn, ano, genero);
                    biblioteca.adicionarLivro(novoLivro);
                    break;
                case 2: // Registrar Novo Usuário
                    System.out.print("Nome do Usuário: ");
                    String nomeUsuario = scan.nextLine();
                    System.out.print("ID do Usuário: ");
                    String idUsuario = scan.nextLine();

                    Usuario novoUsuario = new Usuario(nomeUsuario, idUsuario);
                    biblioteca.registrarUsuario(novoUsuario);
                    break;
                case 3: // Emprestar Livro
                    System.out.print("ISBN do Livro a emprestar: ");
                    String isbnEmprestimo = scan.nextLine();
                    System.out.print("ID do Usuário: ");
                    String idUsuarioEmprestimo = scan.nextLine();
                    biblioteca.emprestarLivro(isbnEmprestimo, idUsuarioEmprestimo);
                    break;
                case 4: // Devolver Livro
                    System.out.print("ISBN do Livro a devolver: ");
                    String isbnDevolucao = scan.nextLine();
                    System.out.print("ID do Usuário que devolve: ");
                    String idUsuarioDevolucao = scan.nextLine();
                    biblioteca.devolverLivro(isbnDevolucao, idUsuarioDevolucao);
                    break;
                case 5: // Buscar Livro por Título
                    System.out.print("Digite o título do livro para buscar: ");
                    String tituloBusca = scan.nextLine();
                    Livro livroBuscado = biblioteca.buscarLivroPorTitulo(tituloBusca);
                    // O método já imprime o feedback, então não precisamos de um if/else aqui.
                    // Se você precisar do objeto, 'livroBuscado' o conterá (ou será null).
                    break;
                case 6: // Buscar Livro por Autor
                    System.out.print("Digite o nome do autor para buscar: ");
                    String autorBusca = scan.nextLine();
                    List<Livro> livrosDoAutor = biblioteca.buscarLivroPorAutor(autorBusca);
                    if (!livrosDoAutor.isEmpty()) {
                        System.out.println("Livros encontrados para o autor '" + autorBusca + "':");
                        for (Livro l : livrosDoAutor) {
                            System.out.println("- " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ")");
                        }
                    } // O else já é tratado dentro de buscarLivroPorAutor
                    break;
                case 7: // Buscar Usuário por ID
                    System.out.print("Digite o ID do usuário para buscar: ");
                    String idUsuarioBusca = scan.nextLine();
                    Usuario userBuscado = biblioteca.buscarUsuarioPorId(idUsuarioBusca);
                    // O método já imprime o feedback.
                    break;
                case 8: // Listar Todos os Livros
                    biblioteca.listarTodosLivros();
                    break;
                case 9: // Listar Todos os Usuários
                    biblioteca.listarTodosUsuarios();
                    break;
                case 10: // Exibir Livros Emprestados de um Usuário
                    System.out.print("Digite o ID do usuário para ver os empréstimos: ");
                    String idUsuarioExibirEmprestimos = scan.nextLine();
                    Usuario userParaExibir = biblioteca.buscarUsuarioPorId(idUsuarioExibirEmprestimos); // Primeiro busca o usuário
                    if (userParaExibir != null) {
                        userParaExibir.exibirLivrosEmprestados();
                    } else {
                        System.out.println("Usuário com ID '" + idUsuarioExibirEmprestimos + "' não encontrado.");
                    }
                    break;
                case 11: // Remover Livro
                    System.out.print("Digite o ISBN do livro a ser removido: ");
                    String isbnRemoverLivro = scan.nextLine();
                    biblioteca.removerLivro(isbnRemoverLivro);
                    break;
                case 12: // Remover Usuário
                    System.out.print("Digite o ID do usuário a ser removido: ");
                    String idUsuarioRemover = scan.nextLine();
                    biblioteca.removerUsuario(idUsuarioRemover);
                    break;
                case 0: // Sair
                    programaFinalizado = true;
                    System.out.println("Saindo do programa. Obrigado por usar a Biblioteca!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 0 e 12.");
            }
        } while (!programaFinalizado);

        scan.close();
    }
}