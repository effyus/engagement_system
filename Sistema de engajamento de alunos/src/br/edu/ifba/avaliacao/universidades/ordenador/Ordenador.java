package br.edu.ifba.avaliacao.universidades.ordenador;

import java.util.List;

public abstract class Ordenador<TipoDado> {
    protected List<TipoDado> quantidadeAcessos = null;

    public Ordenador(List<TipoDado> quantidadeAcessos){
        this.quantidadeAcessos = quantidadeAcessos;
    }
    
    public List<TipoDado> getQuantidadeAcessos(){
        return quantidadeAcessos;
    }

    public abstract void ordenar();
}
