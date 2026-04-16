package repository;

import model.Livro;
import model.Usuario;
import java.util.ArrayList;

public class BibliotecaRepository {
    private ArrayList<Livro> livros;
    private ArrayList<Usuario> usuarios;

    private int proximoIdLivro = 1;
    private int proximoIdUsuario = 1;

    public BibliotecaRepository(){
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public int gerarProximoIdLivro(){
        return proximoIdLivro++;
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

    public Livro buscarLivroPorId(int idLivro){

        for (Livro livro : livros) {

            if (livro.getId() == idLivro) {
                return livro;
            }
        }
        return null;
    }

    public int gerarProximoIdUsuario(){
        return proximoIdUsuario++;
    }

    public void adicionarUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("Usuário Inválido");
        }
        usuarios.add(usuario);
    }

    public ArrayList<Usuario> listarUsuarios(){
        return new ArrayList<>(usuarios);
    }

    public Usuario buscarUsuarioPorId(int idUsuario){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == idUsuario){
                return usuario;
            }
        }
        return null;
    }
}

