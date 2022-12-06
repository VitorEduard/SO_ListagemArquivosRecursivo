package br.edu.main;

import br.edu.metodos.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        //INICIALIZACAO
        String caminho = "\\E:\\Arquivos de Programas"; //Caminho a ser realizado as varreduras
        int numeroExecucoes = 5; //Número total de varreduras a serem realizadas
        int numeroDescarteMinimasMaximas = 1; //Número de amostras minimas e maximas a serem descartadas

        numeroExecucoes = numeroExecucoes + numeroDescarteMinimasMaximas * 2;

        //EXECUCAO PILHA
        VarredorStack pilha = new VarredorStack();
        var varredurasPilha = new ArrayList<Varredura>();
        String relatorioExecucao =
                "Caminho: " + caminho + "\n" +
                "N Execucoes: " + numeroExecucoes + "\n" +
                "Exexcao em Pilha\n\n";

        for (int i = 0; i < numeroExecucoes; i++) {
            Varredura varredura = pilha.executarVarreduraCalculandoTempo(caminho);
            varredurasPilha.add(varredura);

            relatorioExecucao += varredura.getTempoDecorridoSegundos() + "s\n";
        }

        //ANALISE PILHA
        for (int j = 0; j < numeroDescarteMinimasMaximas; j++) {
            varredurasPilha.remove(Collections.max(varredurasPilha));
            varredurasPilha.remove(Collections.min(varredurasPilha));
        }

        Collections.sort(varredurasPilha);
        int metade = varredurasPilha.size() / 2;
        metade = metade > 0 && metade % 2 == 0 ? metade - 1 : metade;

        double mediana = varredurasPilha.get(metade).getTempoDecorridoSegundos();
        double media = varredurasPilha.stream().mapToDouble(Varredura::getTempoDecorridoSegundos).sum() / varredurasPilha.size();

        relatorioExecucao +=
                "Media: " + media + "\n" +
                "Mediana: " + mediana;

        //CRIACAO RELATORIO DE EXECUCAO
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter(dtf.format(now) + ".txt");

            myWriter.write(relatorioExecucao);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        VarredorAbstract varredor = new VarredorStack();
        Varredura varredura = varredor.executarVarreduraCalculandoTempo(caminho);
        System.out.println("Stack: " + varredura.getTempoDecorridoEmOperacoesCollections());

        varredor = new VarredorLinkedList();
        varredura = varredor.executarVarreduraCalculandoTempo(caminho);
        System.out.println("LinkedList: " + varredura.getTempoDecorridoEmOperacoesCollections());

        varredor = new VarredorArrayList();
        varredura = varredor.executarVarreduraCalculandoTempo(caminho);
        System.out.println("ArrayList: " + varredura.getTempoDecorridoEmOperacoesCollections());

        varredor = new VarredorHashSet();
        varredura = varredor.executarVarreduraCalculandoTempo(caminho);
        System.out.println("HashSet: " + varredura.getTempoDecorridoEmOperacoesCollections());

        varredor = new VarredorRecursivo();
        varredura = varredor.executarVarreduraCalculandoTempo(caminho);
        System.out.println(varredura.getQtdArquivosEncontrados());
        System.out.println(varredura.getQtdPastasEncontradas());
        System.out.println(varredura.getTempoDecorridoEmOperacoesCollections());


    }
}