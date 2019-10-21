package com.example.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorU extends RecyclerView.Adapter<AdaptadorU.UserViewHolder>{
    private List<UsuarioList> listaU;

    public AdaptadorU(List<UsuarioList> listaU) {
        this.listaU = listaU;
    }

    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview, viewGroup, false);
        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        userViewHolder.id = listaU.get(i).getId();
        userViewHolder.nomlist1.setText(listaU.get(i).getFirsname());
        userViewHolder.apellist1.setText(listaU.get(i).getLastname());
        userViewHolder.correolist1.setText(listaU.get(i).getEmail());
    }
    @Override
    public int getItemCount() {
        return listaU.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nomlist1, apellist1, correolist1;
        int id;

        UserViewHolder( View item) {
            super(item);

            nomlist1 = item.findViewById(R.id.nomlist);
            apellist1 = item.findViewById(R.id.apellist);
            correolist1 = item.findViewById(R.id.correolist);

        }
    }
}
