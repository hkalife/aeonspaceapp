package com.example.aeonspace;

import java.util.Date;

public class Campeonato {
    private String nomeCampeonato;
    private String descricaoCampeonato;
    private boolean possuiDataFinal;
    private Date dataInicio;
    private Date dataFim;
    private boolean possuiLevelMinimo;
    private String levelMinimo;

    public Campeonato(){}

    public Campeonato(String nomeCampeonato, String descricaoCampeonato, boolean possuiDataFinal, Date dataInicio, Date dataFim, boolean possuiLevelMinimo, String levelMinimo) {
        this.nomeCampeonato = nomeCampeonato;
        this.descricaoCampeonato = descricaoCampeonato;
        this.possuiDataFinal = possuiDataFinal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.possuiLevelMinimo = possuiLevelMinimo;
        this.levelMinimo = levelMinimo;
    }

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }

    public void setNomeCampeonato(String nomeCampeonato) {
        this.nomeCampeonato = nomeCampeonato;
    }

    public String getDescricaoCampeonato() {
        return descricaoCampeonato;
    }

    public void setDescricaoCampeonato(String descricaoCampeonato) {
        this.descricaoCampeonato = descricaoCampeonato;
    }

    public boolean isPossuiDataFinal() {
        return possuiDataFinal;
    }

    public void setPossuiDataFinal(boolean possuiDataFinal) {
        this.possuiDataFinal = possuiDataFinal;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isPossuiLevelMinimo() {
        return possuiLevelMinimo;
    }

    public void setPossuiLevelMinimo(boolean possuiLevelMinimo) {
        this.possuiLevelMinimo = possuiLevelMinimo;
    }

    public String getLevelMinimo() {
        return levelMinimo;
    }

    public void setLevelMinimo(String levelMinimo) {
        this.levelMinimo = levelMinimo;
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "nomeCampeonato='" + nomeCampeonato + '\'' +
                ", descricaoCampeonato='" + descricaoCampeonato + '\'' +
                ", possuiDataFinal=" + possuiDataFinal +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", possuiLevelMinimo=" + possuiLevelMinimo +
                ", levelMinimo='" + levelMinimo + '\'' +
                '}';
    }
}
