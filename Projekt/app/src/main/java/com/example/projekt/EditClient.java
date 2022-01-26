package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditClient extends AppCompatActivity {

    EditText name;
    EditText tel;
    EditText locality;
    EditText country;
    EditText adress;
    EditText id;
    Button edit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        name = findViewById(R.id.nameInput2);
        tel = findViewById(R.id.telInput2);
        locality = findViewById(R.id.localityInput2);
        country = findViewById(R.id.countryInput2);
        adress = findViewById(R.id.adressInput2);
        id = findViewById(R.id.editId);
        edit = findViewById(R.id.editBtn);
        final APIservice service = RetrofitClient.getRetrofitInstance().create(APIservice.class);


        Call<Client> call = service.getStudentWithID(Integer.valueOf(id.getText().toString()));
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                Client client = response.body();
                name.setText(client.getName().toString());
                tel.setText(client.getTel().toString());
                country.setText(client.getCountry().toString());
                locality.setText(client.getLocality().toString());
                adress.setText(client.getAdress().toString());
                Log.d("info", response.body().toString());
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                t.printStackTrace();

            }

            });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Client> call = service.updateClient(name.getText().toString(),
                        tel.getText().toString(),
                        country.getText().toString(),locality.getText().toString(),
                        adress.getText().toString(),
                        1,"jGON8VXcTniKyzNDJceZ02nVhxWG1ioZfB5AaKJF");
                call.enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        Client client = response.body();
                        //status.setText(stud.getStatus().toString());
                        Toast.makeText(EditClient.this, "Új hallgató létrehozva!",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Toast.makeText(EditClient.this, "Hiba!",
                                Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }

});}
}