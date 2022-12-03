package br.edu.metodos;

import br.edu.main.Varredura;

public abstract class VarredorArquivosAbstract {
    protected StringBuilder arquivosStr = new StringBuilder();
    protected Integer qtdArquivosEncontrados = 0;
    protected Integer qtdPastasEncontradas = 0;

    public Varredura executarVarreduraCalculandoTempo(String caminho){
        Long inicio = System.nanoTime();
        this.executarVarredura(caminho);
        Long tempoDecorrido = System.nanoTime() - inicio;
        return new Varredura(this.arquivosStr.toString(), tempoDecorrido, this.qtdArquivosEncontrados, this.qtdPastasEncontradas);
    }

    protected abstract void executarVarredura(String caminho);
}
