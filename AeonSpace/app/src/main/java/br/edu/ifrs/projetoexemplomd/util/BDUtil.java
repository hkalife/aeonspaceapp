package br.edu.ifrs.projetoexemplomd.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.ifrs.projetoexemplomd.dao.MensagemRepository;

public class BDUtil extends SQLiteOpenHelper {

    private static final String BASE_DE_DADOS = "SOBRE";
    private static final int VERSAO = 1;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE MENSAGEM (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" DESCRICAO  TEXT    NOT NULL)");
        db.execSQL(criarTabela.toString());

        StringBuilder insertTabelaTituloDisciplina = new StringBuilder();
        insertTabelaTituloDisciplina.append("INSERT INTO MENSAGEM VALUES (1, 'Programação para Web III')");
        db.execSQL(insertTabelaTituloDisciplina.toString());

        StringBuilder insertTabelaNomeDev = new StringBuilder();
        insertTabelaNomeDev.append("INSERT INTO MENSAGEM VALUES (2, 'Desenvolvido por Henrique Kalife')");
        db.execSQL(insertTabelaNomeDev.toString());
    }

    /*Método abaixo é executado quando troa a versão do BD*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MENSAGEM");
        onCreate(db);
    }

    /*Método usado para obter a conexão com o BD*/
    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }

}
