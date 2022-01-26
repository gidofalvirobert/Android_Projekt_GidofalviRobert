package com.example.projekt;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList lname , lpassword, ltel, lcountry, llocality, ladress;



    CustomAdapter(Context context , ArrayList name, ArrayList password, ArrayList tel, ArrayList country, ArrayList locality, ArrayList adress){
        this.context = context;
        this.lname = name;
        this.lpassword = password;
        this.lcountry = country;
        this.llocality = locality;
        this.ladress = adress;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(lname.get(position)));
        holder.password.setText(String.valueOf(lpassword.get(position)));
        holder.tel.setText(String.valueOf(ltel.get(position)));
        holder.country.setText(String.valueOf(lcountry.get(position)));
        holder.locality.setText(String.valueOf(llocality.get(position)));
        holder.adress.setText(String.valueOf(ladress.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, password, tel, country, locality, adress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            password = itemView.findViewById(R.id.Password);
            tel = itemView.findViewById(R.id.Tel);
            country = itemView.findViewById(R.id.Country);
            locality = itemView.findViewById(R.id.Locality);
            adress = itemView.findViewById(R.id.Adress);
        }
    }
}
