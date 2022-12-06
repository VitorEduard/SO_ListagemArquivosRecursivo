package br.edu.metodos;

import br.edu.main.Varredura;

public abstract class VarredorAbstract {
    protected StringBuilder arquivosStr = new StringBuilder();
    protected Integer qtdArquivosEncontrados = 0;
    protected Integer qtdPastasEncontradas = 0;

    protected Long tempoDecorridoEmOperacoesCollections = 0L;

    private Long tempMetodo;


    protected void iniTemp() {
        this.tempMetodo = System.nanoTime();
    }

    protected void fimTemp() {
        tempoDecorridoEmOperacoesCollections += System.nanoTime() - this.tempMetodo;
    }

    public Varredura executarVarreduraCalculandoTempo(String caminho){
        Long inicio = System.nanoTime();
        this.executarVarredura(caminho);
        Long tempoDecorrido = System.nanoTime() - inicio;
        return new Varredura(this.arquivosStr.toString(), tempoDecorrido, this.qtdArquivosEncontrados, this.qtdPastasEncontradas, this.tempoDecorridoEmOperacoesCollections);
    }

    protected abstract void executarVarredura(String caminho);


}
