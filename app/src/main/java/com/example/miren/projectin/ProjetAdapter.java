package com.example.miren.projectin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProjetAdapter extends RecyclerView.Adapter<ProjetAdapter.ViewHolder> {

    private Projet[] projets;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView projetNom;

        public ViewHolder(View view) {
            super(view);
            projetNom = (TextView) view.findViewById(R.id.nom);
        }
    }

    public ProjetAdapter(Projet[] projets){
        this.projets = projets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_projet_adapter,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Projet projet = projets[position];
        holder.projetNom.setText(projet.getNom());
    }

    @Override
    public int getItemCount() {
        return projets.length;
    }
}
