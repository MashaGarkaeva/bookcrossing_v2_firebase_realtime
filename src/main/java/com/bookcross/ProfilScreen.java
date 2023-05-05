package com.bookcross;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class ProfilScreen extends AppCompatActivity implements View.OnClickListener {

    TextView name_user;
    Button see_place_books;
    ImageView icon_add;
    ImageView icon_back;
    ImageView icon_profil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        //name_user = findViewById(R.id.name_user);
        icon_add = findViewById(R.id.icon_add);
        see_place_books = findViewById(R.id.see_place_books);
        icon_back = findViewById(R.id.icon_back);
        icon_profil = findViewById(R.id.icon_profil);
        see_place_books.setOnClickListener(this);
        icon_add.setOnClickListener(this);
        icon_back.setOnClickListener(this);
        icon_profil.setOnClickListener(this);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resetUI();
    }
    private void resetUI() {
    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.see_place_books:
                Intent intent = new Intent(ProfilScreen.this, MapsScreen.class);
                ProfilScreen.this.startActivity(intent);
                break;
            case R.id.icon_add:
                Intent intent1 = new Intent(ProfilScreen.this, AddBookScreen.class);
                ProfilScreen.this.startActivity(intent1);
                break;
            case R.id.icon_back:
                Intent intent2 = new Intent(ProfilScreen.this, AvtorizScreen.class);
                ProfilScreen.this.startActivity(intent2);
                break;
            case R.id.icon_profil:
                Intent intent3 = new Intent(ProfilScreen.this, InfoProfilScreen.class);
                ProfilScreen.this.startActivity(intent3);
                break;
        }
    }


}
