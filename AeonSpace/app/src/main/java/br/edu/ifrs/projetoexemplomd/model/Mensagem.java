package br.edu.ifrs.projetoexemplomd.model;

public class Mensagem {

    private int _id;
    private String descricao;

    public Mensagem() {}

    public Mensagem(int _id, String descricao) {
        this._id = _id;
        this.descricao = descricao;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
