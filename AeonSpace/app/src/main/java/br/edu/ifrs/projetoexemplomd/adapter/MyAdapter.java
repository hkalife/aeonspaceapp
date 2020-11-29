package br.edu.ifrs.projetoexemplomd.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.projetoexemplomd.R;
import br.edu.ifrs.projetoexemplomd.activities.EditaCampeonatoActivity;
import br.edu.ifrs.projetoexemplomd.activities.MainActivity;
import br.edu.ifrs.projetoexemplomd.model.Campeonato;
import br.edu.ifrs.projetoexemplomd.model.Pessoa;
import br.edu.ifrs.projetoexemplomd.util.ConfiguraFirebase;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Campeonato> listaCampeonato = new ArrayList<>();
    Context context;

    public MyAdapter(Context context, List<Campeonato> campeonatos) {
        this.listaCampeonato = campeonatos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        //exibe os itens no Recycler
        Campeonato c = listaCampeonato.get(i);

        String formatDataInicio = "Início: " + (c.getDataInicio() != null ? c.getDataInicio() : "Sem definição");
        String formatDataFim = "Fim: " + (c.getDataFim() != null ? c.getDataFim() : "Sem definição");

        myViewHolder.nomeCampeonato.setText(c.getNomeCampeonato());
        myViewHolder.dataInicio.setText(formatDataInicio);
        myViewHolder.dataFim.setText(formatDataFim);
        /*myViewHolder.buttonDeletarCampeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbarExcluido = Snackbar.make(v,
                        R.string.campeonato_excluido, Snackbar.LENGTH_LONG);
                snackbarExcluido.show();
                removerItem(i);
            }
        });*/
        myViewHolder.buttonDeletarCampeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CRUD", "clicou no botão para deletar");
                removerItem(i, v);
            }
        });
        myViewHolder.buttonEditarCampeonato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditaCampeonatoActivity.class);
                intent.putExtra("NOMECAMPEONATO", listaCampeonato.get(i).getNomeCampeonato());
                intent.putExtra("DESCRICAOCAMPEONATO", listaCampeonato.get(i).getDescricaoCampeonato());
                intent.putExtra("DATAINICIO", listaCampeonato.get(i).getDataInicio());
                intent.putExtra("DATAFIM", listaCampeonato.get(i).getDataFim());
                intent.putExtra("LEVELMINIMO", listaCampeonato.get(i).getLevelMinimo());
                v.getContext().startActivity(intent);
            }
        });
    }

    public void removerItem(final int position, View v){
        Log.d("CRUD", "REMOVENDO ITEM");

        new AlertDialog.Builder(v.getContext())
                .setTitle("Deletando campeonato")
                .setMessage("Tem certeza que deseja deletar esse campeonato?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DatabaseReference reference = ConfiguraFirebase.getNo("campeonatos");
                        reference.child(listaCampeonato.get(position).getId()).removeValue();
                        listaCampeonato.remove(position);
                        notifyItemRemoved(position);

                    }}).setNegativeButton("Não", null).show();

    }

    @Override
    public int getItemCount() {
        return listaCampeonato != null ? listaCampeonato.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados da pessoa que serão exibidos no recycler
        TextView nomeCampeonato;
        TextView dataInicio;
        TextView dataFim;
        Button buttonDeletarCampeonato;
        Button buttonEditarCampeonato;

        public MyViewHolder(View itemView){
            super(itemView);
            //passa uma referência para os componentes que estão na interface
            nomeCampeonato = itemView.findViewById(R.id.textViewNomeCampeonato);
            dataInicio = itemView.findViewById(R.id.textViewDtInicio);
            dataFim = itemView.findViewById(R.id.textViewDtFim);
            buttonDeletarCampeonato = itemView.findViewById(R.id.buttonDeletarCampeonato);
            buttonEditarCampeonato = itemView.findViewById(R.id.buttonEditarCampeonato);
        }
    }
}
