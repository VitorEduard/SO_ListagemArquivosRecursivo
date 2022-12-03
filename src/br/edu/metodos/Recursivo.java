package br.edu.metodos;

import java.io.File;

public class Recursivo extends VarredorArquivosAbstract {

    @Override
   protected void executarVarredura(String caminho) {
        File file = new File(caminho);
        executarVarreduraRecursiva(file, 0);
    }

    private void executarVarreduraRecursiva(File file, int qtdTabs) {
        for (int i = 0; i < qtdTabs; i++) {
            super.arquivosStr.append("\t");
        }
        super.arquivosStr.append(file.getName());
        super.arquivosStr.append("\n");
        if (file.isDirectory()) {
            qtdTabs++;
            super.qtdPastasEncontradas++;
            for (File umFile : file.listFiles()) {
                executarVarreduraRecursiva(umFile, qtdTabs);
            }
        } else {
            super.qtdArquivosEncontrados++;
        }
        qtdTabs--;
    }

}
