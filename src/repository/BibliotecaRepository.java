package repository;

import model.Livro;
import model.Usuario;
import java.util.ArrayList;

public class BibliotecaRepository {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    private int proximoId = 1;

    public BibliotecaRepository(){
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public int gerarProximoId(){
        return proximoId++;
    }

    public void validarLivroNulo(Livro livro){
        if(livro == null){
            throw new IllegalArgumentException("ERRO! Livro Inválido!");
        }
    }

    public void adicionarLivro(Livro livro){
        validarLivroNulo(livro);
        livros.add(livro);
    }

    public ArrayList<Livro> listarLivros(){
        return new ArrayList<>(livros);
    }

    public Livro buscarLivroPorId(int id){

        for (Livro livro : livros) {

            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }
}
