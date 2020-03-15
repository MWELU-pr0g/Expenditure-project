package com.cmutinda.expenditure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {
    private EditText nedit1, nedit2;
    private Button lgnButton;
    private FirebaseAuth fauth;
    private TextView mcreate;
    private TextView mforgot;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nedit1 = findViewById(R.id.loginEdit1);
        nedit2 = findViewById(R.id.loginEdit2);
        mcreate = findViewById(R.id.loginText2);
//        mforgot = findViewById(R.id.account);
        fauth = FirebaseAuth.getInstance();
        image=findViewById(R.id.loginIMAGE);


        lgnButton=findViewById(R.id.loginButton);
        lgnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = nedit1.getText().toString().trim();
                String password = nedit2.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    nedit1.setError("Email is recquired to proceed");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    nedit2.setError("Invalid Password!");
                    return;
                }
                if (password.length() < 6) {
                    nedit2.setError("Too Short Password!" + "");
                    return;
                }


                final Task<AuthResult> authResultTask = fauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));


                        } else {

                            Toast.makeText(LoginActivity.this, "Authentication failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                        }


                        }

                });
            }
        });

        mcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));

            }
        });
    }


}