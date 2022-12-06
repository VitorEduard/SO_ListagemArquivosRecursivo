package br.edu.metodos;

import java.util.List;

public abstract class VarredorListAbstract<E extends List> extends VarredorCollectionsAbstract {

    protected List<String> lista;

    protected VarredorListAbstract() {
        this.setList();
    }

    protected abstract void setList();

    @Override
    protected void getURLAbs(StringBuilder baseUrl) {
        this.lista.forEach(pasta -> baseUrl.append("\\").append(pasta));
    }

    @Override
    protected void addAbs(String nomePasta) {
        this.lista.add(nomePasta);
    }

    @Override
    protected String removeAbs() {
        return this.lista.remove(this.lista.size()-1);
    }

    @Override
    protected boolean isEmptyAbs() {
        return this.lista.isEmpty();
    }

    @Override
    protected boolean nonEmptyAbs() {
        return !this.lista.isEmpty();
    }
}
