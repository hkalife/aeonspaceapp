package br.edu.ifrs.projetoexemplomd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.projetoexemplomd.R;

public class CadCampeonatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadcampeonato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button buttonCadastrar = findViewById(R.id.btnCadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("boolCriouCampeonato", true);
                startActivity(intent);
            }
        });
    }

}
