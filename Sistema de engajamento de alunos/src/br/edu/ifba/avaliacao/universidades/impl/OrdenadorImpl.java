package br.edu.ifba.avaliacao.universidades.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.avaliacao.universidades.ordenador.Ordenador;

public class OrdenadorImpl extends Ordenador<Acessos>{
    
    public OrdenadorImpl(List<Acessos> quantidadeAcessos){
        super(quantidadeAcessos);
    }
    /*COMPLEXIDADE EXPONENCIAL, O(2^N) */

    @Override
    public void ordenar() {
       ordenar(0, quantidadeAcessos.size() - 1);
    }
  /**
     * complexidade exponencial, O(2^N)
     * 
     * @param inicio
     * @param fim
     */
    public void ordenar(int inicio, int fim) {
        if (inicio < fim && (fim - inicio) >= 1) {
            int meio = (fim + inicio) / 2;
            
            ordenar(inicio, meio);
            ordenar(meio + 1, fim);

            ordenar(inicio, meio, fim);
        }
    }

    
    /**
     * complexidade linear, O(N)
     * 
     * @param inicio
     * @param meio
     * @param fim
     */
    public void ordenar(int inicio, int meio, int fim) {
        List<Acessos> quantidadeAcessosTemp = new ArrayList<>();

        int esquerda = inicio;
        int direita = meio + 1;

        while (esquerda <= meio && direita <= fim) {
            if (quantidadeAcessos.get(esquerda).getValor() <= quantidadeAcessos.get(direita).getValor()) {
                quantidadeAcessosTemp.add(quantidadeAcessos.get(esquerda));
                esquerda++;
            } else {
                quantidadeAcessosTemp.add(quantidadeAcessos.get(direita));
                direita++;
            }
        }

        while (esquerda <= meio) {
            quantidadeAcessosTemp.add(quantidadeAcessos.get(esquerda));
            esquerda++;
        }

        while (direita <= fim) {
            quantidadeAcessosTemp.add(quantidadeAcessos.get(direita));
            direita++;
        }

        for (int i = 0; i < quantidadeAcessosTemp.size(); inicio++) {
            quantidadeAcessos.set(inicio, quantidadeAcessosTemp.get(i++));
        }
    }
}
