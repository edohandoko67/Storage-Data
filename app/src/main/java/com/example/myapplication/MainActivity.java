package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.myapplication.R.id.btn_login;
import static com.example.myapplication.R.id.pass;
import static com.example.myapplication.R.id.start;
import static com.example.myapplication.R.id.user;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText user, pass;
    Button btn_login;

    String username = "Admin";
    String password = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (TextUtils.isEmpty(user.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())){
                        Toast.makeText(MainActivity.this, "Harap Diisi", Toast.LENGTH_SHORT).show();
                    } else if (user.getText().toString().equals(username)){
                    if (pass.getText().toString().equals(password)){
                        Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, app.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(MainActivity.this, "Kesalahan Pada Username atau Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}