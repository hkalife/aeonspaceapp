package br.edu.ifrs.projetoexemplomd.util;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguraFirebase {
    //A linha DatabaseReference reference estabelece uma referência a base do firebase, relacionada ao projeto
    //Para isso utiliza o pacote que foi configurado quando o projeto foi criado
    private static DatabaseReference reference = null;

    public static DatabaseReference getNoRaiz(){
        reference = FirebaseDatabase.getInstance().getReference();
        return reference;
    }

    public static DatabaseReference getNo(String no){
        reference = FirebaseDatabase.getInstance().getReference(no);
        return reference;
    }
}
