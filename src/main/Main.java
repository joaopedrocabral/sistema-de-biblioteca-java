package main;
import model.Livro;
import model.Usuario;
import repository.BibliotecaRepository;
import service.BibliotecaService;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static void listarLivros(BibliotecaService service){
        ArrayList<Livro> listaDeLivros = service.listarLivros();

        System.out.println("===== Lista de Livros =====");

        for (Livro livro : listaDeLivros) {
            System.out.println(livro);
        }

        System.out.println();
    }

    private static void listarUsuarios(BibliotecaService service){
        ArrayList<Usuario> listaDeUsuarios = service.listarUsuarios();

        System.out.println("===== Lista de Usuários =====");

        for(Usuario usuario : listaDeUsuarios){
            System.out.println(usuario);
        }

        System.out.println();
    }

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

            System.out.println("\n5 - Usuários");

            System.out.println("\n0 - Sair");

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
                    if (service.listarLivros().isEmpty()) {
                        System.out.println("A lista de livros está vazia");
                        break;
                    }

                    listarLivros(service);
                    break;
                }

                case 3: {

                    if(service.listarLivros().isEmpty() || service.listarUsuarios().isEmpty()){
                        System.out.println("É necessário ter livros e usuários cadastrados.");
                        break;
                    }

                    System.out.println("===== Emprestar Livro =====");

                    listarLivros(service);

                    System.out.println("Escolha um livro pelo ID: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    listarUsuarios(service);

                    System.out.println("Escolha um usuário pelo ID: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        service.emprestarLivro(idLivro, idUsuario);
                        System.out.println("Livro emprestado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                    break;
                }

                case 4: {
                    if (service.listarLivros().isEmpty()) {
                        System.out.println("A lista de livros está vazia");
                        break;
                    }

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

                case 5:

                    int opcaoUsuarios = -1;

                    while(opcaoUsuarios != 0){
                        System.out.println("===== MENU USUÁRIOS =====");
                        System.out.println("1 - Cadastrar Usuário");
                        System.out.println("2 - Listar Usuários");
                        System.out.println("0 - Voltar ao Menu Anterior");

                        System.out.println("\nDigite uma opcão: ");
                        opcaoUsuarios = scanner.nextInt();
                        scanner.nextLine();

                        switch(opcaoUsuarios){
                            case 1:{
                                System.out.println("===== Cadastro de Usuários ====");

                                System.out.println("Digite o nome do Usuário: ");
                                String nomeUsuario = scanner.nextLine();

                                try {
                                    service.cadastrarUsuario(nomeUsuario);
                                    System.out.println("Usuário cadastrado com sucesso!");
                                } catch (IllegalArgumentException e){
                                    System.out.println(e.getMessage());
                                }

                                System.out.println();
                                break;
                            }

                            case 2: {
                                if(service.listarUsuarios().isEmpty()){
                                    System.out.println("A lista de usuários está vazia!");
                                    break;
                                }

                                listarUsuarios(service);
                                break;
                            }

                            case 0: {
                                System.out.println("Voltando...");
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

                    break;

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
