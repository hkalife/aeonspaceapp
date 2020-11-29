package br.edu.ifrs.projetoexemplomd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.adapter.MyAdapter;
import br.edu.ifrs.projetoexemplomd.fragments.ListFragment;
import br.edu.ifrs.projetoexemplomd.model.Campeonato;

public class EditaCampeonatoActivity extends AppCompatActivity {

    Button button;
    String chave;
    TextInputEditText nomeCampeonato;
    TextInputEditText descricaoCampeonato;
    TextInputEditText dataInicio;
    TextInputEditText dataFim;
    TextInputEditText levelMinimo;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_campeonato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        nomeCampeonato = findViewById(R.id.txtNomeCampeonatoEditar);
        descricaoCampeonato = findViewById(R.id.txtDescricaoCampeonatoEditar);
        dataInicio = findViewById(R.id.txtDtInicioEditar);
        dataFim = findViewById(R.id.txtDtFimEditar);
        levelMinimo = findViewById(R.id.txtLevelMinimoEditar);
        chave = intent.getStringExtra("chave");

        nomeCampeonato.setText(intent.getStringExtra("NOMECAMPEONATO"));
        descricaoCampeonato.setText(intent.getStringExtra("DESCRICAOCAMPEONATO"));
        dataInicio.setText(intent.getStringExtra("DATAINICIO"));
        dataFim.setText(intent.getStringExtra("DATAFIM"));
        levelMinimo.setText(intent.getStringExtra("LEVELMINIMO"));

        Button buttonConfirmarEdicao = findViewById(R.id.buttonConfirmarEdicao);
        buttonConfirmarEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("campeonatos").child(chave);
                Campeonato c = new Campeonato(
                        nomeCampeonato.getText().toString(),
                        descricaoCampeonato.getText().toString(),
                        dataInicio.getText().toString(),
                        dataFim.getText().toString(),
                        levelMinimo.getText().toString()
                );
                if (validarCampos(c)) {
                    reference.setValue(c);
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validarCampos(Campeonato campeonato){
        if(campeonato.getNomeCampeonato().isEmpty()){
            ((EditText)findViewById(R.id.txtNomeCampeonatoEditar)).setError("Informe nome do campeonato");
            return false;
        }
        if(campeonato.getDataInicio().isEmpty()){
            ((EditText)findViewById(R.id.txtDtInicioEditar)).setError("Informe data de início");
            return false;
        }
        if(campeonato.getDataFim().isEmpty()){
            ((EditText)findViewById(R.id.txtDtFimEditar)).setError("Informe data de fim");
            return false;
        }
        if(campeonato.getDescricaoCampeonato().isEmpty()){
            ((EditText)findViewById(R.id.txtDescricaoCampeonatoEditar)).setError("Informe descrição do campeonato");
            return false;
        }
        if(campeonato.getLevelMinimo().isEmpty()){
            ((EditText)findViewById(R.id.txtLevelMinimoEditar)).setError("Informe level mínimo");
            return false;
        }

        Log.d("validacao", "saiu no validar");
        return true;
    }

}