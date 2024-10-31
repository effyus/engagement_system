package br.edu.ifba.avaliacao.universidades.operacoes;

import java.util.List;
import java.util.Map;

import br.edu.ifba.avaliacao.universidades.impl.Acessos;
import br.edu.ifba.avaliacao.universidades.impl.Universidade;

public interface Operacoes<Coletados, Sensor> {
    
    //IMPLEMENTANDO D.1
    public void imprimir(List<Coletados> coletados);

    //IMPLEMENTANDO D.2
    public void imprimir(Map<Coletados, List<Sensor>> quantidadeAcessos);

    //IMPLEMENTANDO D.4
    public Map<Coletados, List<Sensor>> ordenar(Map<Coletados, List<Sensor>> quantidadeAcessos);
    
    //IMPLEMENTAÇÃO D.4 
    public Map<Integer, Acessos> encontrarDiaMaisAcessadoPorSemana(Map<Universidade, List<Acessos>> quantidadeAcessos);

    
    
    
    


}
