package br.edu.ifrs.projetoexemplomd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.edu.ifrs.projetoexemplomd.model.Mensagem;
import br.edu.ifrs.projetoexemplomd.util.BDUtil;

public class MensagemRepository {

    private BDUtil bdUtil;

    public MensagemRepository(Context context) {
        bdUtil = new BDUtil(context);
    }

    public Mensagem getMensagem(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM MENSAGEM WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Mensagem m = new Mensagem();
        m.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        m.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
        bdUtil.close();
        return m;
    }

}
