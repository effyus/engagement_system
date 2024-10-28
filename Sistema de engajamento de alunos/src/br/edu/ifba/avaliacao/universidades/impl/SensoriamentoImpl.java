package br.edu.ifba.avaliacao.universidades.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.avaliacao.universidades.sensoriamento.Sensoriamento;



public class SensoriamentoImpl implements Sensoriamento<Acessos>{

    private static final int QUANTIDADE_ACESSOS_ACEITOS = 500;
    private static final int OSCILACAO_ACESSOS = 100;
    
    
    @Override
    public List<Acessos> gerar(int quantidadeAcessosTotal) {
        List<Acessos> quantidadeAcessos = new ArrayList<>();
        Random randomizador = new Random();
    
        for (int i = 0; i < quantidadeAcessosTotal; i++) {
            // Gera uma oscilação entre -1 e 1
            double oscilacao = (randomizador.nextDouble() * 2 - 1) * OSCILACAO_ACESSOS / 100;
            
            // Calcula a quantidade de acessos e limita a 1000
            int acessos = (int) (QUANTIDADE_ACESSOS_ACEITOS + QUANTIDADE_ACESSOS_ACEITOS * oscilacao);
            acessos = Math.min(acessos, 1000);
    
            // Cria o objeto Acessos com a quantidade calculada e adiciona à lista
            Acessos quantidadeAcesso = new Acessos(acessos, i +1);
            quantidadeAcessos.add(quantidadeAcesso);
        }
    
        return quantidadeAcessos;
    }
    
    
}
