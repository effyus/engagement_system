package br.edu.ifba.avaliacao.universidades.impl;

public class Acessos implements Comparable<Acessos> {
    private Integer valor = 0;
    private final int dia; //variável para acrescimo de dia 

    public Integer getValor() {
        return valor;
    }


    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public int getDia(){
        return dia;
    }

    public Acessos(Integer acessos, int dia) {
        this.valor = acessos;
        this.dia = dia;
    }
    
    @Override
    public String toString() {
        return "Acessos do dia "+dia+": " + valor;
    }

    @Override
    public int compareTo(Acessos o) {
        return Integer.valueOf(valor).compareTo(o.getValor());
    }
    
    

}
