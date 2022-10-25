package com.androidapp.subforsub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    
    String txtfirstname;
    String txtlastname;
    String txtcontactno;
    String txtemail;
    String txtpassword;
    String txtconfirmpassword;
    EditText firstname;
    EditText lastname;
    EditText contctno;
    EditText email;
    EditText password;
    EditText confirmpassword;
    AppCompatButton registerbtn;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        contctno = findViewById(R.id.contactno);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        registerbtn = findViewById(R.id.signup);
        confirmpassword = findViewById(R.id.confirmpassword);
        
        
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtfirstname = firstname.getText().toString();
                txtlastname = lastname.getText().toString();
                txtcontactno = contctno.getText().toString();
                txtemail = email.getText().toString();
                txtpassword = password.getText().toString();
                txtconfirmpassword = confirmpassword.getText().toString();
                
                if(txtfirstname.isEmpty())
                {
                    firstname.setError("Enter First Name");
                }
                else if(txtlastname.isEmpty())
                {
                    lastname.setError("Enter Last Name");
                }
                else if(txtcontactno.isEmpty())
                {
                    contctno.setError("Enter Contact Number");
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
                else if(txtconfirmpassword != txtpassword )
                {
                    Toast.makeText(Register.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startActivity(new Intent(Register.this,MainActivity.class));
                    Toast.makeText(Register.this, "Registration Sucessfull", Toast.LENGTH_SHORT).show();
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
}