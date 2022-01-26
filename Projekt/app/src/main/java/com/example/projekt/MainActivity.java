package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    FloatingActionButton addbutton;
    FloatingActionButton editbutton;
    FloatingActionButton deletebutton;
    EditText editid;
    Button list;

    ArrayList<String> name , password, tel, country, locality, adress;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reciclerView);
        addbutton = findViewById(R.id.addBtn);
        editbutton = findViewById(R.id.editBtn);
        deletebutton = findViewById(R.id.deleteBtn);
        editid = findViewById(R.id.editId);
        list = findViewById(R.id.list);
        final APIservice service = RetrofitClient.getRetrofitInstance().create(APIservice.class);

        adapter = new CustomAdapter(MainActivity.this,name,password,tel,country,locality,adress);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Client> call = service.deleteClientWithID(Integer.valueOf(editid.getText().toString()),1,"jGON8VXcTniKyzNDJceZ02nVhxWG1ioZfB5AaKJF");
                call.enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        Client stud = response.body();

                        Toast.makeText(MainActivity.this, "Sikeres törlés!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddClient.class);
                startActivity(intent);
            }
        });
        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditClient.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<List<Client>> call = service.getClients();
                call.enqueue(new Callback<List<Client>>() {
                    @Override
                    public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                        List<Client> clients = response.body();
                        for (int i = 0; i < clients.size(); i++) {
                            name.add(clients.get(i).getName().toString());
                            password.add(clients.get(i).getPassword().toString());
                            tel.add(clients.get(i).getTel().toString());
                            country.add(clients.get(i).getCountry().toString());
                            locality.add(clients.get(i).getLocality().toString());
                            adress.add(clients.get(i).getAdress().toString());
                        }

                        Toast.makeText(MainActivity.this, "Sikeres törlés!", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<List<Client>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }
        }
        );}
}