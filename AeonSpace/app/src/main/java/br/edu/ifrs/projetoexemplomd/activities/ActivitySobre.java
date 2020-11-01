package br.edu.ifrs.projetoexemplomd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.edu.ifrs.projetoexemplomd.R;

public class ActivitySobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}