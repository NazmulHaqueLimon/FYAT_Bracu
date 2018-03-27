package com.example.hp.fyat;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ProgressBar;
import android.widget.ProgressBar;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    EditText userName,email,pass;
    private FirebaseAuth mAuth;
    ProgressBar pBar;
    private static final String TAG = "SignUp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        userName=(EditText)findViewById(R.id.name_id);
        email=(EditText)findViewById(R.id.email_id);
        pass=(EditText)findViewById(R.id.pass_id);
        pBar=(ProgressBar)findViewById(R.id.progressBar);
        findViewById(R.id.signUpButton2).setOnClickListener(this);


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.signUpButton2:
                registerUser();

                //startActivity(new Intent(this, Student_Info.class));

                break;

        }
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
        pBar.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(uEmail, uPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(SignUp.this,Student_Info.class));
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // [START_EXCLUDE]

                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]







    }




}
