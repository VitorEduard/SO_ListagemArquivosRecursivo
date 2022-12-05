package br.edu.main;

public class Varredura implements Comparable<Varredura> {

    public Varredura(String arquivosEncontradosStr, Long tempoDecorridoNanoSegundos, Integer qtdArquivosEncontrados, Integer qtdPastasEncontradas) {
        this.arquivosEncontradosStr = arquivosEncontradosStr;
        this.qtdArquivosEncontrados = qtdArquivosEncontrados;
        this.tempoDecorridoNanoSegundos = tempoDecorridoNanoSegundos;
        this.qtdPastasEncontradas = qtdPastasEncontradas;
    }

    private Long tempoDecorridoNanoSegundos;
    private String arquivosEncontradosStr;
    private Integer qtdArquivosEncontrados;
    private Integer qtdPastasEncontradas;


    public Long getTempoDecorridoNanoSegundos() {
        return tempoDecorridoNanoSegundos;
    }

    public Float getTempoDecorridoSegundos() {
        return tempoDecorridoNanoSegundos / 1_000_000_000f;
    }

    public String getArquivosEncontradosStr() {
        return arquivosEncontradosStr;
    }

    public Integer getQtdArquivosEncontrados() {
        return qtdArquivosEncontrados;
    }

    public Integer getQtdPastasEncontradas() {
        return qtdPastasEncontradas;
    }

    @Override
    public int compareTo(Varredura v) {
        if (this.getTempoDecorridoSegundos() > v.getTempoDecorridoSegundos()) {
            return 1;
        } else if (this.getTempoDecorridoSegundos() < v.getTempoDecorridoSegundos()) {
            return -1;
        }
        return 0;
    }
}

