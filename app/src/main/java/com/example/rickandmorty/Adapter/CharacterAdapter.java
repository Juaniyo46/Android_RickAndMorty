package com.example.rickandmorty.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rickandmorty.API.Result;
import com.example.rickandmorty.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    List<Result> list;
    private Context context;


    public CharacterAdapter(Context context, List<Result> list) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup,false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder characterViewHolder, int i) {
        characterViewHolder.bindUsuario(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvStatus;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.id);
            tvName = itemView.findViewById(R.id.name);
            tvStatus = itemView.findViewById(R.id.status);
        }

        public void bindUsuario(Result character) {
            String name = character.getName();
            tvName.setText(name);
            String status = character.getStatus();
            tvStatus.setText(status);
            tvId.setText(String.valueOf(character.getId()));
        }
    }
}
