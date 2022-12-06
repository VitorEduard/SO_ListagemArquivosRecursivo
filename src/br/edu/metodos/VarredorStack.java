package br.edu.metodos;

import java.util.Stack;

public class VarredorStack extends VarredorCollectionsAbstract {

    private Stack<String> pilha = new Stack<>();

    @Override
    protected void getURLAbs(StringBuilder baseUrl) {
        this.pilha.elements().asIterator().forEachRemaining(pasta -> baseUrl.append("\\").append(pasta));
    }

    @Override
    protected void addAbs(String nomePasta) {
        this.pilha.push(nomePasta);
    }

    @Override
    protected String removeAbs() {
        return this.pilha.pop();
    }

    @Override
    protected boolean isEmptyAbs() {
        return this.pilha.empty();
    }

    @Override
    protected boolean nonEmptyAbs() {
        return !this.pilha.empty();
    }
}
