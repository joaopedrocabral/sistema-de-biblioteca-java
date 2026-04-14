package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, int anoPublicacao){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = true;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public void emprestar(){
        this.disponivel = false;
    }

    public void devolver(){
        this.disponivel = true;
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

    @Override
    public String toString(){
        return "ID: " + id + " | " +
                "Título: " + titulo + " | " +
                "Autor: " + autor + " | " +
                "Ano: " + anoPublicacao + " | " +
                "Disponível: " + (disponivel? "Sim" : "Não");

    }
}


