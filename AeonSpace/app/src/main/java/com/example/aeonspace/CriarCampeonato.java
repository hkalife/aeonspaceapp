package com.example.aeonspace;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CriarCampeonato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_campeonato);
    }

    public void irParaMenuPrincipal(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("boolCriouCampeonato", true);
        startActivity(intent);
    }

}