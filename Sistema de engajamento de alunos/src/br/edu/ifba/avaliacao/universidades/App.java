package br.edu.ifba.avaliacao.universidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.avaliacao.universidades.impl.Acessos;
import br.edu.ifba.avaliacao.universidades.impl.OperacoesImpl;
import br.edu.ifba.avaliacao.universidades.impl.SensoriamentoImpl;
import br.edu.ifba.avaliacao.universidades.impl.Universidade;
import br.edu.ifba.avaliacao.universidades.operacoes.Operacoes;
import br.edu.ifba.avaliacao.universidades.sensoriamento.Sensoriamento;

public class App {
    private static final int TOTAL_UNIVERSIDADES = 10;
    private static final int TOTAL_ACESSO = 10;

    public static void main(String[] args) throws Exception {
        Sensoriamento<Acessos> sensoriamento = new SensoriamentoImpl();

        //gerando leitura de 10 universiades
        Map<Universidade, List<Acessos>> quantidadeAcessos = new TreeMap<>();
        for (int i = 0; i < TOTAL_UNIVERSIDADES; i++){
            quantidadeAcessos.put(new Universidade(i + "", "UESB #" + i), sensoriamento.gerar(TOTAL_ACESSO));
        }

        Operacoes<Universidade, Acessos> operacoes = new OperacoesImpl();

        //IMPRIMINDO LISTA DE UNIVERSIDADES
        //D.1
        System.out.println("**************************************************");
        System.out.println("UNIVERSIDADES QUE UTILIZAM O SISTEMA");
        operacoes.imprimir(new ArrayList<Universidade>(quantidadeAcessos.keySet()));
        System.out.println("\n**************************************************");
        //IMPRIMINDO QUANTIDADE DE ACESSO POR UNIVERSIDADE
        //D.2
        
        System.out.println("\nQUANTIDADE DE ACESSO DE CADA UNIVERSIDADE");
        operacoes.imprimir(quantidadeAcessos);
        System.out.println("\n**************************************************");

        //ORDENANDO OS DADOS DOS ACESSOS
        //D.3
        System.out.println("\nORDENANDO OS ACESSOS DAS UNIVERSIDADES");
        Map<Universidade, List<Acessos>> quantidadeAcessosOrdenados = operacoes.ordenar(quantidadeAcessos);
        operacoes.imprimir(quantidadeAcessosOrdenados);
        System.out.println("\n**************************************************");
        

    }
}
