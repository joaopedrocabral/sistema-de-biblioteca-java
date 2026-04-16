package service;
import repository.BibliotecaRepository;
import model.Livro;
import model.Usuario;
import java.util.ArrayList;

public class BibliotecaService {
    private BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository){
        this.repository = repository;
    }

    public void cadastrarLivro(String titulo, String autor, int anoPublicacao){
        int id = repository.gerarProximoIdLivro();

        Livro livro = new Livro(id, titulo, autor, anoPublicacao);

        repository.adicionarLivro(livro);
    }

    public ArrayList<Livro> listarLivros(){
        return repository.listarLivros();
    }

    public void emprestarLivro(int idLivro, int idUsuario){
        Livro livro = repository.buscarLivroPorId(idLivro);
        Usuario usuario = repository.buscarUsuarioPorId(idUsuario);

        if(livro == null){
            throw new IllegalArgumentException("ERRO! Não existe livro com esse ID");
        }

        if(!livro.isDisponivel()){
            throw new IllegalArgumentException("ERRO! O livro não está disponível");
        }

        livro.emprestar(usuario);
    }

    public void devolverLivro(int id){
        Livro livro = repository.buscarLivroPorId(id);

        if(livro == null){
            throw new IllegalArgumentException("ERRO! Não existe livro com esse ID");
        }

        if(livro.isDisponivel()){
            throw new IllegalArgumentException("ERRO! O livro já está disponível");
        }

        livro.devolver();
    }

    public void cadastrarUsuario(String nome){
        int id = repository.gerarProximoIdUsuario();

        Usuario usuario = new Usuario(id, nome);

        repository.adicionarUsuario(usuario);
    }

    public ArrayList<Usuario> listarUsuarios(){
         return repository.listarUsuarios();
    }

    public Usuario buscarUsuarioPorId(int id){
        return repository.buscarUsuarioPorId(id);
    }


}


