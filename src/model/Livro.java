package model;

import java.time.Year;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;
    private Usuario usuarioEmprestado;

    public Livro(int id, String titulo, String autor, int anoPublicacao){
        this.id = id;
        validarTexto(titulo, "título");
        this.titulo = titulo;
        validarTexto(autor, "autor");
        this.autor = autor;
        validarAnoPublicacao(anoPublicacao);
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    private void validarTexto(String valor, String nomeCampo){
        if(valor == null || valor.trim().isEmpty()){
            throw new IllegalArgumentException("ERRO! O " + nomeCampo + " do livro não pode ser nulo ou vazio!");
        }
    }

    private void validarAnoPublicacao(int anoPublicacao){
        if(anoPublicacao <= 0 || anoPublicacao > Year.now().getValue()){
            throw new IllegalArgumentException("ERRO! O ano digitado é inválido!");
        }
    }

    public void setTitulo(String titulo){
        validarTexto(titulo, "título");
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        validarTexto(autor, "autor");
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao){
        validarAnoPublicacao(anoPublicacao);
        this.anoPublicacao = anoPublicacao;
    }

    public void emprestar(Usuario usuario){
        this.disponivel = false;
        this.usuarioEmprestado = usuario;
    }

    public void devolver(){
        this.disponivel = true;
        this.usuarioEmprestado = null;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getAnoPublicacao(){
        return anoPublicacao;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    public Usuario getUsuarioEmprestado(){
        return usuarioEmprestado;
    }

    @Override
    public String toString(){
        return "ID: " + id + " | " +
                "Título: " + titulo + " | " +
                "Autor: " + autor + " | " +
                "Ano: " + anoPublicacao + " | " +
                (disponivel?
                        "Disponível: Sim" :
                        "Emprestado para: " +  usuarioEmprestado.getNome());
    }
}


