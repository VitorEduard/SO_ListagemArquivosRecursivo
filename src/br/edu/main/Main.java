package br.edu.main;

import br.edu.metodos.Recursivo;

public class Main {

    public static void main(String[] args) {
        String caminho = "\\E:\\Emuladores";
        Recursivo pilha = new Recursivo();
        Varredura varredura = pilha.executarVarreduraCalculandoTempo(caminho);
        System.out.println(varredura.getArquivosEncontradosStr());
        System.out.println("Quantidade de Arquivos Encontrados: " + varredura.getQtdArquivosEncontrados());
        System.out.println("Quantidade de Pastas Encontradas: " + varredura.getQtdPastasEncontradas());
        System.out.println("Tempo Decorrido para Operação: " + varredura.getTempoDecorridoSegundos() + "s");
    }

}