package com.neizatheedev.project1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {

    /*************************************/
    // Firebase
    private FirebaseAuth mAuth;
    /*************************************/
    public ProgressDialog loginProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*************************************/
        // Firebase
        mAuth =FirebaseAuth.getInstance();
        /*************************************/
        Button signBtn = (Button) findViewById(R.id.signBtn);
        Button logInBtn = (Button) findViewById(R.id.logInBtn);
        Button forgotPassBtn = (Button) findViewById(R.id.forgotPassBtn);

        TextView LoggingInTextView = (TextView) findViewById(R.id.LoggingInTextView);

        EditText logInEditText = (EditText) findViewById(R.id.logInEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);


        // Login Button
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = logInEditText.getText().toString().trim();
                String txtPassword = passwordEditText.getText().toString();

                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(LoginActivity.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(txtEmail,txtPassword);
                }
            }
        });

        // forgotPassword Button
        forgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(signUpIntent);
                Toast.makeText(LoginActivity.this, "Change Password", Toast.LENGTH_SHORT).show();
            }
        });
        // SignUp Button
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
                Toast.makeText(LoginActivity.this, "SignUp", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loginUser(String username, String password){
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, IndexActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}