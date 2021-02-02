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

public class CustomerRegister extends AppCompatActivity {

    private TextView registerlink;
    private Button daftarbtn;
    private EditText email;
    private EditText pw;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);
        registerlink = findViewById(R.id.login_cs_link);
        daftarbtn = findViewById(R.id.cs_btndaftar);
        email = findViewById(R.id.email);
        pw = findViewById(R.id.pw);
        loadingbar = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerRegister.this, CustomerLogin.class);
                startActivity(intent);
                finish();
            }
        });

        daftarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eemail = email.getText().toString();
                String Password = pw.getText().toString();
                RegisterCustomer(eemail, Password);
            }

            private void RegisterCustomer(String eemail, String password) {
                if(TextUtils.isEmpty(eemail)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CustomerRegister.this);
                    builder.setMessage("Email belum diisi")
                            .setNegativeButton("Retry", null).create().show();
                }
                else if(TextUtils.isEmpty(password)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CustomerRegister.this);
                    builder.setMessage("Password belum diisi")
                            .setNegativeButton("Retry", null).create().show();
                }
                else
                {
                    loadingbar.setTitle("Regristasi Customer");
                    loadingbar.setMessage("Mohon tunggu . . .");
                    loadingbar.show();

                    mAuth.createUserWithEmailAndPassword(eemail, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(CustomerRegister.this,"Register Berhasil", Toast.LENGTH_LONG).show();
                                        loadingbar.dismiss();
                                        Intent intent = new Intent(CustomerRegister.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        AlertDialog.Builder builder = new AlertDialog.Builder(CustomerRegister.this);
                                        builder.setMessage("Regiter gagal, periksa koneksi internet anda")
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
