package br.edu.ifrs.projetoexemplomd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.dao.MensagemRepository;
import br.edu.ifrs.projetoexemplomd.model.Mensagem;

public class ActivitySobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MensagemRepository mensagemRepository = new MensagemRepository(this);
        Mensagem disciplina = mensagemRepository.getMensagem(1);
        Mensagem desenvolvedor = mensagemRepository.getMensagem(2);

        TextView textDisciplina = findViewById(R.id.textView2);
        textDisciplina.setText(disciplina.getDescricao());

        TextView textDev = findViewById(R.id.textView3);
        textDev.setText(desenvolvedor.getDescricao());
    }
}