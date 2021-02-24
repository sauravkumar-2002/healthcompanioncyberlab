package com.example.hj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private TextView newuser1;
    private EditText password1, emailid1;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
     newuser1 = (TextView) findViewById(R.id.newuser);
       newuser1.setPaintFlags(newuser1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
       password1 = (EditText) findViewById(R.id.passwordbox);
       emailid1 = (EditText) findViewById(R.id.emailbox);
       mAuth = FirebaseAuth.getInstance();
   }

   public void rememberme(View view) {
   }

   public void forgetpassword(View view) {
        EditText resetmail=new EditText(view.getContext());
       AlertDialog.Builder passwordresetdialog=new AlertDialog.Builder(view.getContext());
       passwordresetdialog.setTitle("Reset Password ?");
       passwordresetdialog.setMessage("Enter Your  Email To Receive Reset Link");
       passwordresetdialog.setView(resetmail);

       passwordresetdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               String mail2=resetmail.getText().toString().trim();
               mAuth.sendPasswordResetEmail(mail2).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void aVoid) {
                  Toast.makeText(getApplicationContext(),"Reset Link Has Been Sent",Toast.LENGTH_SHORT).show();
                   }
               }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Toast.makeText(getApplicationContext(),"Link Not Sent"+e.getMessage(),Toast.LENGTH_SHORT).show();
                   }
               })  ;

           }
       });
       passwordresetdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       });
       passwordresetdialog.create().show();
   }

   public void loginbox(View view) {

       String emailidcheck= emailid1.getText().toString().trim();
       String passwordcheck = password1.getText().toString().trim();

       if (emailidcheck.isEmpty()) {
           this.emailid1.setError("please enter email id");
           this.emailid1.requestFocus();
           return;
       }

       if (passwordcheck.isEmpty()) {
           this.password1.setError("please enter password");
           this.password1.requestFocus();
           return;
       }
       if (password1.length() < 4) {
           this.password1.requestFocus();
           this.password1.setError("password too short");
           return;
       }
       if (!Patterns.EMAIL_ADDRESS.matcher(emailidcheck).matches()) {
           this.emailid1.setError("please enter a valid email id");
           this.emailid1.requestFocus();
           return;
       }

       mAuth.signInWithEmailAndPassword(emailidcheck, passwordcheck).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

               if (task.isSuccessful()) {
                   Toast.makeText(getApplicationContext(), "login succesfully", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getApplicationContext(), dashboard.class);
                   startActivity(intent);

               } else {

                   Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
               }
           }
       });

   }




    public void signup(View view) {
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);
    }
}
