package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        final EditText editName   = (EditText)findViewById(R.id.nameInput);
        final EditText editTel   = (EditText)findViewById(R.id.telInput);
        final EditText editPass  = (EditText)findViewById(R.id.passwordInput);
        final EditText editCountry   = (EditText)findViewById(R.id.countryInput);
        final EditText editLocality   = (EditText)findViewById(R.id.localityInput);
        final EditText editAdress   = (EditText)findViewById(R.id.adressInput);
        final Button addButton = (Button) findViewById(R.id.add_Button);

        final APIservice service = RetrofitClient.getRetrofitInstance().create(APIservice.class);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Client> call = service.createClient(editName.getText().toString(),editPass.getText().toString(),
                        editTel.getText().toString(),editCountry.getText().toString(),editLocality.getText().toString(),
                        editAdress.getText().toString(),1,"jGON8VXcTniKyzNDJceZ02nVhxWG1ioZfB5AaKJF");
                call.enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        Client client = response.body();
                        Toast.makeText(AddClient.this, "Új hallgató létrehozva!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Toast.makeText(AddClient.this, "Hiba!", Toast.LENGTH_SHORT).show();
                        t.printStackTrace();

                    }
                });
            }
        });
    }
}