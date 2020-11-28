package br.edu.ifrs.projetoexemplomd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.android.material.snackbar.Snackbar;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.model.Campeonato;
import br.edu.ifrs.projetoexemplomd.util.ConfiguraFirebase;

public class CadCampeonatoActivity extends AppCompatActivity {

    private DatabaseReference reference = ConfiguraFirebase.getNoRaiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadcampeonato);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Button buttonCadastrar = findViewById(R.id.btnCadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("boolCriouCampeonato", true);
                startActivity(intent);
            }
        });*/
    }

    public void cadCampeonato (View view) {
        String nome = ((EditText)findViewById(R.id.txtNomeCampeonato)).getText().toString();
        String descricao = ((EditText)findViewById(R.id.txtDescricaoCampeonato)).getText().toString();
        String dataInicial = ((EditText)findViewById(R.id.txtDtInicio)).getText().toString();
        String dataFim = ((EditText)findViewById(R.id.txtDtFim)).getText().toString();
        String levelMinimo = ((EditText)findViewById(R.id.txtLevelMinimo)).getText().toString();

        Campeonato camp = new Campeonato(nome, descricao, dataInicial, dataFim, levelMinimo);
        DatabaseReference campeonatos = reference.child("campeonatos");

        campeonatos.push().setValue(camp).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(CadCampeonatoActivity.this, "Sucesso ao cadastrar campeonato!", Toast.LENGTH_SHORT).show();
                Log.d("CADASTRO", "criando campeonato");
                limparCampos();
                Intent intent = new Intent(CadCampeonatoActivity.this, MainActivity.class);
                //intent.putExtra("boolCriouCampeonato", true);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("CADASTRO", "não conseguiu criar campeonato");
                Toast.makeText(CadCampeonatoActivity.this, "Erro ao cadastrar campeonato!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void limparCampos(){
        ((EditText)findViewById(R.id.txtNomeCampeonato)).setText("");
        ((EditText)findViewById(R.id.txtDescricaoCampeonato)).setText("");
        ((EditText)findViewById(R.id.txtDtInicio)).setText("");
        ((EditText)findViewById(R.id.txtDtFim)).setText("");
        ((EditText)findViewById(R.id.txtLevelMinimo)).setText("");
    }

}
