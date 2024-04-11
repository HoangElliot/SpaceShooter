package com.example.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.spaceshooter.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new Database(this);

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                String confirmPassword = binding.confirmPassword.getText().toString();

                if (username.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(SignUpActivity.this, "You need to fill all field",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(confirmPassword)) {
                        Boolean checkUsername = db.checkUsername(username);

                        if (!checkUsername) {
                            Boolean insert = db.insertData(username, password);

                            if (insert) {
                                Toast.makeText(SignUpActivity.this, "Sign up successfully",
                                        Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(SignUpActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUpActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}