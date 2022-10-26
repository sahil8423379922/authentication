package com.androidapp.subforsub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeScreen extends AppCompatActivity {
    TextView email;
    TextView name;
    CircleImageView circleImageView;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String txtname;
    String txtemail;
    String imageuri;
    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,Dashboard.class));
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,Campaign.class));
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,HomeScreen.class));
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,Dashboard.class));
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        txtname = firebaseUser.getDisplayName();
        txtemail = firebaseUser.getEmail();
        imageuri = String.valueOf(firebaseUser.getPhotoUrl());

        email = findViewById(R.id.emailac);
        name = findViewById(R.id.name);
        circleImageView = findViewById(R.id.profile_image);

        name.setText(txtname);
        email.setText(txtemail);

        Picasso.get().load(imageuri).into(circleImageView);



    }
}