package com.example.sandmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class CustomerLogin extends AppCompatActivity {

    private TextView registerlink;
    private Button loginbtn;
    private EditText email;
    private EditText pw;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        registerlink = findViewById(R.id.register_cs_link);
        loginbtn = findViewById(R.id.cs_btnlogin);
        email = findViewById(R.id.emailCs);
        pw = findViewById(R.id.pwCs);
        loadingbar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerLogin.this, CustomerRegister.class);
                startActivity(intent);
                finish();
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emaiil = email.getText().toString();
                String password = pw.getText().toString();
                LoginCs(emaiil, password);
            }

            private void LoginCs(String emaiil, String password) {
                if(TextUtils.isEmpty(emaiil)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CustomerLogin.this);
                    builder.setMessage("Email belum diisi")
                            .setNegativeButton("Retry", null).create().show();
                }
                else if(TextUtils.isEmpty(password)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CustomerLogin.this);
                    builder.setMessage("Password belum diisi")
                            .setNegativeButton("Retry", null).create().show();
                }
                else
                {
                    loadingbar.setTitle("Login Pengguna");
                    loadingbar.setMessage("Mohon tunggu . . .");
                    loadingbar.show();
                    mAuth.signInWithEmailAndPassword(emaiil, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(CustomerLogin.this,"Login Berhasil !", Toast.LENGTH_LONG).show();
                                        loadingbar.dismiss();

                                        Intent intent = new Intent(CustomerLogin.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        AlertDialog.Builder builder = new AlertDialog.Builder(CustomerLogin.this);
                                        builder.setMessage("Login gagal, periksa email dan password anda")
                                                .setNegativeButton("Retry", null).create().show();
                                        loadingbar.dismiss();
                                    }
                                }
                            });
                }

            }
        });

    }
}

