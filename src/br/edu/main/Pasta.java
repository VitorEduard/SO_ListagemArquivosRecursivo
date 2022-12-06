package br.edu.main;

public class Pasta {

    private int ordemPasta;
    private String nomePasta;

    public Pasta(int ordemPasta, String nomePasta) {
        this.ordemPasta = ordemPasta;
        this.nomePasta = nomePasta;
    }

    public String getNomePasta() {
        return nomePasta;
    }

    @Override
    public int hashCode(){
        return this.ordemPasta;
    }

    @Override
    public boolean equals(Object o) {
        return o.equals(this.ordemPasta+"");
    }

    @Override
    public String toString() {
        return this.ordemPasta+"";
    }

}
