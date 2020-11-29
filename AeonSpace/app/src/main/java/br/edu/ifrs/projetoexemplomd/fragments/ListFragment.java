package br.edu.ifrs.projetoexemplomd.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.adapter.MyAdapter;
import br.edu.ifrs.projetoexemplomd.listener.RecyclerItemClickListener;
import br.edu.ifrs.projetoexemplomd.model.Campeonato;
import br.edu.ifrs.projetoexemplomd.model.Pessoa;
import br.edu.ifrs.projetoexemplomd.util.ConfiguraFirebase;

public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    List<Campeonato> listaCampeonatos;
    MyAdapter myAdapter;
    Context context;

    public static ListFragment newInstance() {
        return new ListFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        carregaProdutos();

        recyclerView.setLayoutManager(layoutManager);
        return root;
    }

    private void carregaProdutos(){
        final DatabaseReference reference = ConfiguraFirebase.getNo("campeonatos");
        listaCampeonatos = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Campeonato campeonato = ds.getValue(Campeonato.class);
                    campeonato.setId(ds.getKey());
                    listaCampeonatos.add(campeonato);
                    Log.d("CAMPEONATO", campeonato.toString());
                }
                myAdapter = new MyAdapter(context, listaCampeonatos);
                recyclerView.setAdapter(myAdapter);
                recyclerView.setHasFixedSize(true);
                reference.removeEventListener(this);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

}