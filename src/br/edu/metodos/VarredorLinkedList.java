package br.edu.metodos;

import java.util.LinkedList;

public class VarredorLinkedList extends VarredorListAbstract {

    @Override
    protected void setList() {
        super.lista = new LinkedList();
    }

}
