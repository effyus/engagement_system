package br.edu.ifba.avaliacao.universidades.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.avaliacao.universidades.operacoes.Operacoes;
import br.edu.ifba.avaliacao.universidades.ordenador.Ordenador;

public class OperacoesImpl implements Operacoes<Universidade, Acessos>{
    
/*imprime o paciente - complexidade O(N) */
@Override
public void imprimir(List<Universidade>coletados){
    for (Universidade universidade: coletados){
        System.out.println("Dados coletados da universidade: " + universidade);
    }
}
/*COMPLEXIDADE QUADRATICA O(N2) */
@Override
public void imprimir(Map<Universidade, List<Acessos>> quantidadeAcessos){
    for (Universidade universidade: quantidadeAcessos.keySet()){
        System.out.println("Quantidade de acessos da universidade " + universidade + ":");
        for(Acessos quantidadeAcesso: quantidadeAcessos.get(universidade)){
            System.out.println(quantidadeAcesso);
        }
    }
}
/* COMPLEXIDADE O(N2^N) */

@Override
public Map<Universidade, List<Acessos>> ordenar(Map<Universidade, List<Acessos>>quantidadeAcessos){
    Map<Universidade, List<Acessos>> quantidadeAcessosOrdenados = new TreeMap<>();

    for (Universidade universidade: quantidadeAcessos.keySet()) {
        System.out.println("Acessos da " +universidade+ " ordenada:");

        List<Acessos> acessos = quantidadeAcessos.get(universidade);
        Ordenador<Acessos> ordenador = new OrdenadorImpl(acessos);
        ordenador.ordenar();

        quantidadeAcessosOrdenados.put(universidade, acessos);
    }

    return quantidadeAcessosOrdenados;
}
/**
     * complexidade cubica, O(N^3)
     * 
     * tem a possibilidade de gerar uma situacao de brute force, porque exige
     * avaliar uma sequencia de dados biometricos de todos os pacientes monitorados. Dependendo da quantidade de pacientes e leituras realizadas, a execucao deste algoritmo pode elevar o seu tempo/custo e torna-lo ineficiente e ineficaz.
     */
    //FALTA ESSA PARTE

}
