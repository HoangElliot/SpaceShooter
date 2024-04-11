package com.example.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spaceshooter.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new Database(this);

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "You need to fill all field",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkUsernamePassword = db.checkUsernamePassword(username, password);

                    if (checkUsernamePassword) {
                        Intent intent = new Intent(getApplicationContext(), LoadingActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Username or password incorrect",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}