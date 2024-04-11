package com.example.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.spaceshooter.databinding.ActivityBattleResultBinding;
import com.example.spaceshooter.databinding.ActivityMainMenuBinding;

public class BattleResultActivity extends AppCompatActivity {
    ActivityBattleResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBattleResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int points = getIntent().getExtras().getInt("points");
        binding.score.setText("" + points);

        binding.restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BattleResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BattleResultActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}