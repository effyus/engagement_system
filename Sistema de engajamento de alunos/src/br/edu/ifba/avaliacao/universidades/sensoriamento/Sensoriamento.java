package br.edu.ifba.avaliacao.universidades.sensoriamento;

import java.util.List;

public interface Sensoriamento<TipoDado> {

    public List<TipoDado> gerar(int quantidadeAcessosTotal);
    
}
