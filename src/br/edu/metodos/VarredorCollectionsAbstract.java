package br.edu.metodos;

import java.io.File;
import java.util.Objects;

public abstract class VarredorCollectionsAbstract extends VarredorAbstract {

    private Boolean encontrouPasta = null;
    private String ultDiretorioLido = null;


    private String getURL(String baseUrl) {
        StringBuilder urlCaminho = new StringBuilder(baseUrl);
        super.iniTemp();
        this.getURLAbs(urlCaminho);
        super.fimTemp();
        return urlCaminho.toString();
    }
    protected abstract void getURLAbs(StringBuilder baseUrl);
    private void add(String nomePasta) {
        super.iniTemp();
        this.addAbs(nomePasta);
        super.fimTemp();
    }
    protected abstract void addAbs(String nomePasta);
    private String remove() {
        super.iniTemp();
        String retorno = this.removeAbs();
        super.fimTemp();
        return retorno;
    }
    protected abstract String removeAbs();
    private boolean isEmpty(){
        super.iniTemp();
        boolean retorno = this.isEmptyAbs();
        super.fimTemp();
        return retorno;
    }
    protected abstract boolean isEmptyAbs();
    private boolean nonEmpty() {
        super.iniTemp();
        boolean retorno = this.nonEmptyAbs();
        super.fimTemp();
        return retorno;
    }
    protected abstract boolean nonEmptyAbs();


    @Override
    protected void executarVarredura(String caminho) {
        boolean avancouNivelPasta = true;
        do {
            encontrouPasta = false;
            File file = new File(this.getURL(caminho));
            varrerPasta(file, avancouNivelPasta);
            if (!encontrouPasta) {
                if (this.isEmpty()) {
                    encontrouPasta = null;
                } else {
                    ultDiretorioLido = this.remove();
                }
            }

            avancouNivelPasta = Boolean.TRUE.equals(encontrouPasta);
        } while (this.nonEmpty() || Objects.nonNull(encontrouPasta));
    }

    private void varrerPasta(File pastaArquivos, boolean avancouNivelPasta) {
        boolean passouUltDiretorioLido = false;
        for (File arquivo : pastaArquivos.listFiles()) {
            if (avancouNivelPasta && arquivo.isFile()) {
                qtdArquivosEncontrados++;
            }
            if (!encontrouPasta) {
                if (Objects.isNull(ultDiretorioLido) || passouUltDiretorioLido) {
                    if (arquivo.isDirectory()) {
                        this.add(arquivo.getName());
                        ultDiretorioLido = null;
                        encontrouPasta = true;
                        qtdPastasEncontradas++;
                    }
                } else if (Objects.nonNull(ultDiretorioLido) && Objects.equals(arquivo.getName(), ultDiretorioLido)) {
                    passouUltDiretorioLido = true;
                }
            }
        }
    }

}
