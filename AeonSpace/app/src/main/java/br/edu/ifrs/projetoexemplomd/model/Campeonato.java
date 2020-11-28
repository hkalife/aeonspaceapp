package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    private String id;
    private String nomeCampeonato;
    private String descricaoCampeonato;
    private String dataInicio;
    private String dataFim;
    private String levelMinimo;

    public Campeonato(){}

    public Campeonato(String nomeCampeonato, String descricaoCampeonato, String dataInicio, String dataFim, String levelMinimo) {
        this.id = id;
        this.nomeCampeonato = nomeCampeonato;
        this.descricaoCampeonato = descricaoCampeonato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.levelMinimo = levelMinimo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
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
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", levelMinimo='" + levelMinimo + '\'' +
                '}';
    }

    /*
    public static List<Pessoa> inicializaLista(){
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Silvia", "20/12/2000", "Rua x, 10"));
        pessoas.add(    new Pessoa("Maria", "20/11/2001", "Rua Vicente Monteggia, 20"));
        pessoas.add(    new Pessoa("José", "20/10/2002", "Avenida Ipirange, 3030, apto 500"));
        pessoas.add(    new Pessoa("Mário", "20/12/2000", "Rua Otávio Francisco Caruso da Rocha, 40"));
        pessoas.add(     new Pessoa("Juca", "20/11/2001", "Rua Coronel Vicente, 50, apto 230"));
        pessoas.add(    new Pessoa("Jane", "20/10/2002", "Rua p, 60"));
        return pessoas;
    }
    * */

    public static List<Campeonato> inicializaListaCampeonatos() {
        List<Campeonato> campeonatos = new ArrayList<>();

        Campeonato campeonato1 = new Campeonato();
        campeonato1.setNomeCampeonato("Primeiro Campeonato");
        campeonato1.setDescricaoCampeonato("Este é o primeiro campeonato");
        campeonato1.setDataInicio("25/04/2020");
        campeonato1.setDataFim("31/12/2020");
        //campeonato1.setLevelMinimo("1");
        campeonatos.add(campeonato1);

        Campeonato campeonato2 = new Campeonato();
        campeonato2.setNomeCampeonato("Segundo Campeonato");
        campeonato2.setDescricaoCampeonato("Este é o segundo campeonato");
        //campeonato2.setDataInicio(new String());
        campeonato2.setLevelMinimo("10");
        campeonatos.add(campeonato2);

        return campeonatos;
    }
}
