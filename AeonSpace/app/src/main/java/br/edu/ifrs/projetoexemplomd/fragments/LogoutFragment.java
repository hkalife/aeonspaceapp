package br.edu.ifrs.projetoexemplomd.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.activities.LoginActivity;
import br.edu.ifrs.projetoexemplomd.activities.MainActivity;

public class LogoutFragment extends Fragment {

    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_logout, container, false);

        FirebaseAuth.getInstance().signOut();
        Log.d("LOGIN", "deslogou");

        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);

        return root;
    }
}