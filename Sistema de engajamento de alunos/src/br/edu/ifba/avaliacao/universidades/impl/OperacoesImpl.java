package br.edu.ifba.avaliacao.universidades.impl;

import java.util.HashMap;
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
    public Map<Integer, Acessos> encontrarDiaMaisAcessadoPorSemana(Map<Universidade, List<Acessos>> quantidadeAcessos) {
        Map<Integer, Acessos> diaMaisAcessadoPorSemana = new HashMap<>();
        Map<Integer, Integer> totalAcessosPorDia = new HashMap<>();

        // Itera sobre as universidades
        for (Universidade universidade : quantidadeAcessos.keySet()) {
            List<Acessos> acessos = quantidadeAcessos.get(universidade);

            // Itera sobre os acessos
            for (Acessos acesso : acessos) {
                int dia = acesso.getDia();
                int quantidade = acesso.getValor();

                // Adiciona a quantidade de acessos ao dia
                totalAcessosPorDia.put(dia, totalAcessosPorDia.getOrDefault(dia, 0) + quantidade);
            }
        }

        // Verifica o dia com mais acessos para cada semana
        for (int semana = 1; semana <= 52; semana++) { // Assume que há 52 semanas
            int diaMaisAcessado = -1;
            int maxAcessos = -1;

            // Itera sobre os dias (1 a 7, supondo que os dias estão representados por números)
            for (int dia = 1; dia <= 7; dia++) {
                int acessosNoDia = totalAcessosPorDia.getOrDefault(dia + (semana - 1) * 7, 0); // Ajusta o dia para a semana
                if (acessosNoDia > maxAcessos) {
                    maxAcessos = acessosNoDia;
                    diaMaisAcessado = dia + (semana - 1) * 7; // Ajusta o dia
                }
            }

            // Armazena o dia mais acessado e o respectivo valor
            if (diaMaisAcessado != -1) {
                diaMaisAcessadoPorSemana.put(semana, new Acessos(maxAcessos, diaMaisAcessado));
            }
        }

        return diaMaisAcessadoPorSemana;
    }

}
