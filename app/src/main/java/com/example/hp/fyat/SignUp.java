package com.example.hp.fyat;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    EditText userName,email,pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        userName=(EditText)findViewById(R.id.name_id);
        email=(EditText)findViewById(R.id.email_id);
        pass=(EditText)findViewById(R.id.pass_id);


        findViewById(R.id.signUpButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }
    public void registerUser(){
        String uName=userName.getText().toString().trim();
        String uEmail=email.getText().toString().trim();
        if(uEmail.isEmpty()){
            userName.setError("email is required");
            userName.requestFocus();
            return;
        }
        //validate the email address
        if(! android.util.Patterns.EMAIL_ADDRESS.matcher(uEmail).matches()){
            email.setError("email is not valid");
            email.requestFocus();
            return;
        }
        String uPass=pass.getText().toString().trim();
        if(uPass.isEmpty()){
            email.setError("please type a new password");
            email.requestFocus();
            return;

        }
        mAuth.createUserWithEmailAndPassword(uEmail, uPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"user registered successfully",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }




}
