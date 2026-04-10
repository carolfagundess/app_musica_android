package com.cadm.app06_musicas;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicaAdpater extends RecyclerView.Adapter<MusicaAdpater.ViewHolder> {

    private List<String> listaMusicas;

    // 2. Construtor para receber os dados
    public MusicaAdpater(List<String> lista) {
        this.listaMusicas = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = android.view.LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_musica, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 2. Pega a música na posição atual e coloca no TextView
        String musicaAtual = listaMusicas.get(position);
        holder.nomeMusica.setText(musicaAtual);
    }

    @Override
    public int getItemCount() {
        return listaMusicas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nomeMusica;

        public ViewHolder(View itemView){
            super(itemView);
            nomeMusica = itemView.findViewById(R.id.txtNomeMusicaItem);
        }
    }
}
