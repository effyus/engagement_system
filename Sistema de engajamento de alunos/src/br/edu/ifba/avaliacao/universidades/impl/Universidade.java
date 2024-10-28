package br.edu.ifba.avaliacao.universidades.impl;

public class Universidade implements Comparable<Universidade>{

    private String identificacao = "";
    private String nome = "";

    public Universidade(String identificacao, String nome) {
        this.identificacao = identificacao;
        this.nome = nome;
    }
    
    public String getIdentificacao() {
        return identificacao;
    }

    public String getNome() {
        return nome;
    } 
    @Override
    public String toString() {
        return "id: " + identificacao + ", nome: " + nome;
    }

    @Override
    public int compareTo(Universidade o) {
        return this.identificacao.compareTo(o.getIdentificacao());
    }

}
