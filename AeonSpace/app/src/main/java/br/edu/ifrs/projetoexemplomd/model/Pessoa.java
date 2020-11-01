package br.edu.ifrs.projetoexemplomd.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    private String endereco;

    public Pessoa(){}
    public Pessoa(String nome, String dataNascimento, String endereco) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

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

}
