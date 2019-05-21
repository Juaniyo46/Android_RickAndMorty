package com.example.rickandmorty.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rickandmorty.API.Character;
import com.example.rickandmorty.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    List<Character> list;

    public CharacterAdapter(List<Character> list) {
        this.list = list;
    }



    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup,false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder characterViewHolder, int i) {
        characterViewHolder.bindUsuario(list.get(i));

    }

    @Override
    public int getItemCount() {
        return 0;
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

        public void bindUsuario(Character character) {
            String name = character.getName();
            tvName.setText(name);
            String status = character.getStatus();
            tvStatus.setText(status);
            tvId.setText(String.valueOf(character.getId()));
        }
    }
}
