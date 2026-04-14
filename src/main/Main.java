package main;
import model.Livro;
import repository.BibliotecaRepository;
import service.BibliotecaService;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        BibliotecaRepository repository = new BibliotecaRepository();
        BibliotecaService service = new BibliotecaService(repository);

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while(opcao != 0){
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("0 - Sair");

            System.out.println("\nDigite uma opcão: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1: {
                    System.out.println("===== Cadastro de Livros =====");

                    System.out.println("Digite o Título do Livro: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o Autor do Livro: ");
                    String autor = scanner.nextLine();

                    System.out.println("Digite o Ano de Publicação do Livro: ");
                    int anoPublicacao = scanner.nextInt();
                    scanner.nextLine();

                    service.cadastrarLivro(titulo, autor, anoPublicacao);

                    System.out.println("Livro cadastrado com sucesso!");

                    System.out.println();
                    break;
                }

                case 2: {
                    ArrayList<Livro> listaDeLivros = service.listarLivros();

                    if (listaDeLivros.isEmpty()) {
                        System.out.println("A lista de livros está vazia");
                        break;
                    }

                    System.out.println("===== Lista de Livros =====");

                    for (Livro livro : listaDeLivros) {
                        System.out.println(livro);
                    }

                    System.out.println();
                    break;
                }

                case 3: {
                    System.out.println("===== Emprestar Livro =====");

                    System.out.println("Digite o ID do Livro que deseja emprestar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        service.emprestarLivro(id);
                        System.out.println("Livro emprestado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                    break;
                }

                case 4: {
                    System.out.println("===== Devolver Livro =====");

                    System.out.println("Digite o ID do Livro que deseja devolver: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        service.devolverLivro(id);
                        System.out.println("Livro devolvido com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                    break;
                }

                case 0: {
                    System.out.println("Saindo...");
                    System.out.println();
                    break;
                }

                default: {
                    System.out.println("Opção Inválida!");
                    System.out.println();
                    break;
                }
            }
        }
        scanner.close();
    }
}
