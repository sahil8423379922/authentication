package com.androidapp.subforsub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    ProgressBar progressBar;
    String txtfullname;
    String txtwhatsappnumber;
    String txtcontactno;
    String txtemail;
    String txttown;
    String txtpassword;
    String txtconfirmpassword;
    EditText fullname;
    EditText whatsappnumber;
    EditText contctno;
    EditText town;
    EditText email;
    EditText password;
    EditText confirmpassword;
    AppCompatButton registerbtn;
    //Firebase decleration
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullname = findViewById(R.id.fullname);
        progressBar = findViewById(R.id.progress);
        whatsappnumber = findViewById(R.id.whtsappnumber);
        contctno = findViewById(R.id.contactno);
        email = findViewById(R.id.email);
        town=findViewById(R.id.town);
        password = findViewById(R.id.password);
        registerbtn = findViewById(R.id.signup);
        confirmpassword = findViewById(R.id.confirmpassword);
        
        
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtfullname = fullname.getText().toString();
                txtwhatsappnumber = whatsappnumber.getText().toString();
                txtcontactno = contctno.getText().toString();
                txtemail = email.getText().toString();
                txttown = town.getText().toString();
                txtpassword = password.getText().toString();
                txtconfirmpassword = confirmpassword.getText().toString();
                
                if(txtfullname.isEmpty())
                {
                    fullname.setError("Enter Full Name");
                }
                else if(txtwhatsappnumber.isEmpty())
                {
                    whatsappnumber.setError("Enter Whats App Number");
                }
                else if(txtcontactno.isEmpty())
                {
                    contctno.setError("Enter Contact Number");
                }
                else if(txttown.isEmpty())
                {
                    town.setError("Enter Town");
                }
                else if(txtemail.isEmpty())
                {
                    email.setError("Enter Email");
                }
                else if(txtpassword.isEmpty())
                {
                    password.setError("Enter Password");
                }
                else if(txtconfirmpassword.isEmpty())
                {
                    
                    confirmpassword.setError("Re-Enter Password");
                }
                else if(!txtconfirmpassword.equals(txtpassword))
                {
                    Toast.makeText(Register.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   send_data();
                   progressBar.setVisibility(View.VISIBLE);
                }
                
                
                
            }
        });
        

        findViewById(R.id.signin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,MainActivity.class));
            }
        });
    }

    private void send_data() {
        CollectionReference details = db.collection("cities");
        Map<String, Object> data2 = new HashMap<>();
        data2.put("name", txtfullname);
        data2.put("whatsapp", txtwhatsappnumber);
        data2.put("contact", txtcontactno);
        data2.put("email", txtemail);
        data2.put("password", txtpassword);
        details.document("user")

                .set(data2).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(Register.this,Dashboard.class));

                }
                else
                {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Register.this, "Error in Registration", Toast.LENGTH_SHORT).show();
                }
                 }


        });



    }
}