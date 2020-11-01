package br.edu.ifrs.projetoexemplomd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.adapter.MyAdapter;
import br.edu.ifrs.projetoexemplomd.fragments.ListFragment;
import br.edu.ifrs.projetoexemplomd.model.Campeonato;

public class EditaCampeonatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_campeonato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextInputEditText nomeCampeonato = findViewById(R.id.txtNomeCampeonatoEditar);
        TextInputEditText descricaoCampeonato = findViewById(R.id.txtDescricaoCampeonatoEditar);
        TextInputEditText dataInicio = findViewById(R.id.txtDtInicioEditar);
        TextInputEditText dataFim = findViewById(R.id.txtDtFimEditar);
        TextInputEditText levelMinimo = findViewById(R.id.txtLevelMinimoEditar);

        Intent intent = getIntent();
        nomeCampeonato.setText(intent.getStringExtra("NOMECAMPEONATO"));
        descricaoCampeonato.setText(intent.getStringExtra("DESCRICAOCAMPEONATO"));
        dataInicio.setText(intent.getStringExtra("DATAINICIO"));
        dataFim.setText(intent.getStringExtra("DATAFIM"));
        levelMinimo.setText(intent.getStringExtra("LEVELMINIMO"));

        Button buttonConfirmarEdicao = findViewById(R.id.buttonConfirmarEdicao);
        buttonConfirmarEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(v.getContext(), EditaCampeonatoActivity.class);
                intent.putExtra("NOMECAMPEONATO", listaCampeonato.get(i).getNomeCampeonato());
                intent.putExtra("DESCRICAOCAMPEONATO", listaCampeonato.get(i).getDescricaoCampeonato());
                intent.putExtra("DATAINICIO", listaCampeonato.get(i).getDataInicio());
                intent.putExtra("DATAFIM", listaCampeonato.get(i).getDataFim());
                intent.putExtra("LEVELMINIMO", listaCampeonato.get(i).getLevelMinimo());
                v.getContext().startActivity(intent);*/
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }

}