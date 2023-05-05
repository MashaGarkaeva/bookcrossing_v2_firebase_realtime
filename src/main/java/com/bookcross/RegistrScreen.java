package com.bookcross;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrScreen extends AppCompatActivity {

    EditText reg_login, reg_name, reg_userName;
    EditText reg_password;
    Button enter2;
    TextView loginRegistText;

    FirebaseDatabase database;
    DatabaseReference reference;
    String idUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);

        reg_login = findViewById(R.id.reg_login);
        reg_name = findViewById(R.id.reg_name);
        reg_userName = findViewById(R.id.reg_userName);
        reg_password = findViewById(R.id.reg_password);
        enter2 = (Button) findViewById(R.id.enter2);
        loginRegistText = findViewById(R.id.loginRegistText);

        enter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("User");

                String name = reg_name.getText().toString();
                String email = reg_login.getText().toString();
                String userName = reg_userName.getText().toString();
                String password = reg_password.getText().toString();
                idUser = FirebaseDatabase.getInstance().getReference().child("User").push().getKey();

                HelperClass helperClass = new HelperClass(name, email, userName, password, idUser);
                reference.child(userName).setValue(helperClass);

                Toast.makeText(RegistrScreen.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegistrScreen.this, AvtorizScreen.class);
                startActivity(intent);
            }
        });


        loginRegistText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrScreen.this, AvtorizScreen.class));
            }
        });
    }
}