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
        String caminho = "\\C:\\Users\\USUARIO\\Downloads\\";
        int numeroExecucoes = 100;
        int numeroDescarteMinimasMaximas = 3;
        numeroExecucoes = numeroExecucoes + numeroDescarteMinimasMaximas * 2;
        String logVarredura = "Caminho: " + caminho + "\n";
        logVarredura += "N Execucoes: " + numeroExecucoes + "\n";
        logVarredura += "N Descartes Minimas Maximas: " + numeroDescarteMinimasMaximas + "\n";
        logVarredura += "------------------------------------------------\n";

        //EXECUCAO
        VarredorAbstract varredor = new VarredorStack();
        logVarredura += "Stack:\n";
        logVarredura += executarVarredura(varredor, caminho, numeroExecucoes, numeroDescarteMinimasMaximas);

        varredor = new VarredorLinkedList();
        logVarredura += "LinkedList:\n";
        logVarredura += executarVarredura(varredor, caminho, numeroExecucoes, numeroDescarteMinimasMaximas);

        varredor = new VarredorArrayList();
        logVarredura += "ArrayList:\n";
        logVarredura += executarVarredura(varredor, caminho, numeroExecucoes, numeroDescarteMinimasMaximas);

        varredor = new VarredorHashSet();
        logVarredura += "HashSet:\n";
        logVarredura += executarVarredura(varredor, caminho, numeroExecucoes, numeroDescarteMinimasMaximas);

        //CRIACAO RELATORIO DE EXECUCAO
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter(dtf.format(now) + ".txt");

            myWriter.write(logVarredura);

            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String executarVarredura(VarredorAbstract varredor, String caminho, int numeroExecucoes, int numeroDescarteMinimasMaximas){
        var varreduras = new ArrayList<Varredura>();

        String logVarredura = "";

        for (int i = 0; i < numeroExecucoes; i++) {
            Varredura varredura = varredor.executarVarreduraCalculandoTempo(caminho);
            varreduras.add(varredura);

            System.out.println(varredura.getQtdArquivosEncontrados());
            System.out.println(varredura.getQtdPastasEncontradas());
            System.out.println(varredura.getTempoDecorridoEmOperacoesCollections());

            logVarredura += varredura.getTempoDecorridoSegundos() + "s\n";

            varredor.iniTemp();
        }

        for (int j = 0; j < numeroDescarteMinimasMaximas; j++) {
            varreduras.remove(Collections.max(varreduras));
            varreduras.remove(Collections.min(varreduras));
        }
        Collections.sort(varreduras);
        int metade = varreduras.size() / 2;
        metade = metade > 0 && metade % 2 == 0 ? metade - 1 : metade;

        double mediana = varreduras.get(metade).getTempoDecorridoSegundos();
        double media = varreduras.stream().mapToDouble(Varredura::getTempoDecorridoSegundos).sum() / varreduras.size();

        logVarredura += "Media: " + media + "\n";
        logVarredura += "Mediana: " + mediana + "\n";
        logVarredura += "------------------------------------------------\n";

        return logVarredura;
    }
}