package com.example.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.spaceshooter.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {
    String ListSpaceShip[] = {"enemy1", "enemy2", "enemy3", "enemy4", "enemy5", "enemy6", "enemy7", "enemy8", "enemy9", "enemy10", "enemy11", "enemy12", "enemy13"};
    int ListSpaceShipImage[] = {R.drawable.enemy1, R.drawable.enemy2, R.drawable.enemy3, R.drawable.enemy4, R.drawable.enemy5, R.drawable.enemy6, R.drawable.enemy7, R.drawable.enemy8, R.drawable.enemy9, R.drawable.enemy10, R.drawable.enemy11, R.drawable.enemy12, R.drawable.enemy13};
    static final String SHARED_PREFERENCES_NAME = "spaceship";
    ActivityMainMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), ListSpaceShip, ListSpaceShipImage);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        binding.listView.setAdapter(customBaseAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                editor.putInt("position", position);

                editor.apply();
            }
        });

        binding.startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}