package br.edu.ifrs.projetoexemplomd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.edu.ifrs.projetoexemplomd.R;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout layoutEmail;
    private TextInputEditText txtEmail;
    private TextInputLayout layoutSenha;
    private TextInputEditText txtSenha;
    private Button btnLogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layoutEmail = findViewById(R.id.layoutEmail);
        txtEmail = findViewById(R.id.txtEmail);
        layoutSenha = findViewById(R.id.layoutSenha);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos()){
                   Intent intent = new Intent(view.getContext(), MainActivity.class);
                   startActivity(intent);
                }
                else{
                    Snackbar snackbar = Snackbar.make(view, "Login incorreto", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }
            }
        });


    }
    private boolean validarCampos(){
        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError("Informe o seu e-mail");
            return false;
        }else{
            layoutEmail.setErrorEnabled(false);
        }

        if(txtSenha.getText().toString().isEmpty()){
            layoutSenha.setErrorEnabled(true);
            layoutSenha.setError("Informe a sua senha");
            return false;
        }else{
            layoutSenha.setErrorEnabled(false);
        }
        Log.d("validacao", "saiu no validar");
        return true;
    }

}
