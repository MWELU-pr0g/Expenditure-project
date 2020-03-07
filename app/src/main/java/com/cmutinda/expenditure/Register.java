package com.cmutinda.expenditure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends Activity {
    private EditText mEdit1, mEdit2, mEdit3, mEdit4;
    private Button createButton;
    private FirebaseAuth fauth;
    private TextView create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEdit1 = findViewById(R.id.REdit1);
        mEdit2 = findViewById(R.id.REdit2);
        mEdit3 = findViewById(R.id.REdit3);
        mEdit4 = findViewById(R.id.REdit4);

        createButton = findViewById(R.id.createButton);

        fauth = FirebaseAuth.getInstance();
        createButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = mEdit2.getText().toString().trim();
                String password = mEdit3.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    mEdit2.setError("Email is recquired to proceed");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mEdit3.setError("Invalid Password!");
                    return;
                }
                if (password.length() < 6) {
                    mEdit3.setError("Too Short Password!" + "");
                    return;
                }


                fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                } else {

                                    Toast.makeText(Register.this, "Authentication failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                                }

                            }
                        });

            }
        });

    }
}