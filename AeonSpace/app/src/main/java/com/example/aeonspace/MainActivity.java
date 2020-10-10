package com.example.aeonspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listaLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        if (b.getBoolean("boolCriouCampeonato")) {
            //mostrar toast campeonato criado
            String campeonatoCriado = "Campeonato criado!";
            Toast.makeText(getApplicationContext(), campeonatoCriado, Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_main);
        listaLayouts = findViewById(R.id.listaLayouts);
        listaLayouts.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            Intent intent = new Intent(this, CriarCampeonato.class);
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hkalife/aeonspaceapp"));
            startActivity(intent);
        }
        if (position == 2) {
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
        }
    }

}