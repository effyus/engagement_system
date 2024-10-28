package br.edu.ifba.avaliacao.universidades.operacoes;

import java.util.List;
import java.util.Map;

public interface Operacoes<Coletados, Sensor> {
    
    //implementando D.1
    public void imprimir(List<Coletados> coletados);

    //implementando D.2
    public void imprimir(Map<Coletados, List<Sensor>> quantidadeAcessos);

    //implementando D.3
    public Map<Coletados, List<Sensor>> ordenar(Map<Coletados, List<Sensor>> quantidadeAcessos);

    //implementando D.4 
    // FALTA ESSA PARTE

}
