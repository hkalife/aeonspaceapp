package br.edu.ifrs.projetoexemplomd.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.edu.ifrs.projetoexemplomd.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
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

        mAuth = FirebaseAuth.getInstance();
        if(usuarioLogado()) {
            openMainWindow();
            Log.d("LOGIN", "JÁ ESTÁ LOGADO");
            FirebaseUser user = mAuth.getCurrentUser();
            Log.d("LOGIN", "usuario atual é " + user.getEmail().toString());
        } else {
            btnLogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(validarCampos()){
                        Log.d("LOGIN", "tentando logar com usuario " + txtEmail.toString());
                        mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Usuário logado com sucesso!", Toast.LENGTH_SHORT).show();
                                    openMainWindow();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Dados de login inválidos!", Toast.LENGTH_SHORT).show();
                                    Log.d("LOGIN", "dados inválidos!");
                                }
                            }
                        });
                    }
                    else {
                        Snackbar snackbar = Snackbar.make(view, "Login incorreto", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            });
        }

    }

    private Boolean usuarioLogado() {
        Log.d("Login", "instance" + FirebaseAuth.getInstance());
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null) return false;
        return true;
    }

    private void openMainWindow() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
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
