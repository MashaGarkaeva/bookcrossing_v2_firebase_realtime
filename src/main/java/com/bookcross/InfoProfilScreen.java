package com.bookcross;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

public class InfoProfilScreen extends AppCompatActivity {

    ImageView icon_back1, icon_edit;
    TextView profilName, profilEmail, profilUsername, profilPassword;
    TextView titleName, titleUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoprofil);

        profilName = findViewById(R.id.profileName);
        profilEmail = findViewById(R.id.profileEmail);
        profilUsername = findViewById(R.id.profileUsername);
        profilPassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        icon_back1 = findViewById(R.id.icon_back1);
        icon_edit = findViewById(R.id.icon_edit);

        showUserData();

        icon_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoProfilScreen.this, ProfilScreen.class);
                InfoProfilScreen.this.startActivity(intent);
            }
        });

        icon_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                passUserData();
            }
        });

    }

    public void showUserData() {

        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("userName");
        String passwordUser = intent.getStringExtra("password");

        titleName.setText(nameUser);
        titleUsername.setText(usernameUser);
        profilName.setText(nameUser);
        profilEmail.setText(emailUser);
        profilUsername.setText(usernameUser);
        profilPassword.setText(passwordUser);
    }

    public void passUserData() {
        String userUsername = profilUsername.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                String passwordFromDb = snapshot.child("password").getValue(String.class);
                String nameDb = snapshot.child("name").getValue(String.class);
                String emailDb = snapshot.child("email").getValue(String.class);
                String usernameDb = snapshot.child("userName").getValue(String.class);

                Intent intent1 = new Intent(InfoProfilScreen.this, EditProfilScreen.class);

                intent1.putExtra("name", nameDb);
                intent1.putExtra("email", emailDb);
                intent1.putExtra("userName", usernameDb);
                intent1.putExtra("password", passwordFromDb);

                startActivity(intent1);

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}