package br.edu.metodos;

import br.edu.main.Pasta;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VarredorHashSet extends VarredorCollectionsAbstract {

    private Set<Pasta> hashSet = new HashSet<>();

    @Override
    protected void getURLAbs(StringBuilder baseUrl) {
        this.hashSet.forEach(pasta -> baseUrl.append("\\").append(pasta.getNomePasta()));
    }

    @Override
    protected void addAbs(String nomePasta) {
        this.hashSet.add(new Pasta(this.hashSet.size(), nomePasta));
    }

    @Override
    protected String removeAbs() {
        Pasta pasta = new Pasta(this.hashSet.size()-1, "");
        Optional<Pasta> first = this.hashSet.stream().filter(pastaHash -> pastaHash.equals(pasta)).findFirst();
        this.hashSet.remove(pasta);
        return first.get().getNomePasta();
    }

    @Override
    protected boolean isEmptyAbs() {
        return this.hashSet.isEmpty();
    }

    @Override
    protected boolean nonEmptyAbs() {
        return !this.hashSet.isEmpty();
    }
}
