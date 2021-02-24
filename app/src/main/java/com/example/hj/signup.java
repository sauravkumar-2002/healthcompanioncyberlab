package com.example.hj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password,yourname;
    private TextView  olduser1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.emailsignup);
        olduser1=(TextView)findViewById(R.id.olduser);
        password=(EditText)findViewById(R.id.passwordsignup);
        yourname=(EditText)findViewById(R.id.yournamesignup);
        progressBar=(ProgressBar)findViewById(R.id.progress);
        olduser1.setPaintFlags(olduser1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    public void signup(View view) {
        String emailtext=email.getText().toString().trim();
        String passwordtext=password.getText().toString().trim();
        String yournametext=yourname.getText().toString().trim();
        if (emailtext.isEmpty()) {
            this.email.setError("please enter email id");
            this.email.requestFocus();
            return;
        }

        if (passwordtext.isEmpty()) {
            this.password.setError("please enter password");
            this.password.requestFocus();
            return;
        }
        if (yournametext.isEmpty()){
            this.yourname.setError("please enter your name");
            this.yourname.requestFocus();
            return;
        }
        if (password.length() < 4) {
            this.password.requestFocus();
            this.password.setError("password too short");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()) {
            this.email.setError("Please Enter a Valid Email Id");
            this.email.requestFocus();
            return;
        }
        if (yournametext.length() < 1) {
            Toast.makeText(getApplicationContext(), "enter correct phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emailtext,passwordtext).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"user registered successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),dashboard.class);
                    startActivity(intent);
                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
 Toast.makeText(getApplicationContext(),"user already login",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"some error",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void back(View view) {
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
    }

    public void signin(View view) {
        Intent intent=new Intent(getApplicationContext(),login.class);
        startActivity(intent);
    }
}