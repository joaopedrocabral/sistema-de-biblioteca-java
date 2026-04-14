package model;

public class Usuario {
    private int id;
    private String nome;

    private void validarNome(String nome){

        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("ERRO! Nome não pode ser nulo ou vazio.");
        }
    }

    public Usuario(int id, String nome){
        validarNome(nome);
        this.id = id;
        this.nome = nome;
    }

    public void setNome(String nome){
        validarNome(nome);
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString(){
        return "ID: " + id + " | " + "Nome: " + nome;
    }
}
