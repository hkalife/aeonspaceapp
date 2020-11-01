package br.edu.ifrs.projetoexemplomd.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.activities.MainActivity;

public class RepoFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_repo, container, false);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hkalife/aeonspaceapp"));
        startActivity(intent);
        return root;
    }

}
