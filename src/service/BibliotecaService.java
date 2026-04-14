package service;
import repository.BibliotecaRepository;
import model.Livro;
import java.util.ArrayList;

public class BibliotecaService {
    private BibliotecaRepository repository;

    public BibliotecaService(BibliotecaRepository repository){
        this.repository = repository;
    }

    public void cadastrarLivro(String titulo, String autor, int anoPublicacao){
        int id = repository.gerarProximoId();

        Livro livro = new Livro(id, titulo, autor, anoPublicacao);

        repository.adicionarLivro(livro);
    }

    public ArrayList<Livro> listarLivros(){
        return repository.listarLivros();
    }

    public void emprestarLivro(int id){
        Livro livro = repository.buscarLivroPorId(id);

        if(livro == null){
            throw new IllegalArgumentException("ERRO! Não existe livro com esse ID");
        }

        if(!livro.isDisponivel()){
            throw new IllegalArgumentException("ERRO! O livro não está disponível");
        }

        livro.emprestar();
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
}


