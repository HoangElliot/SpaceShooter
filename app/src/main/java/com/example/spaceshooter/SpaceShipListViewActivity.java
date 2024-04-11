package com.example.spaceshooter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.spaceshooter.databinding.ActivitySpaceShipListViewBinding;

public class SpaceShipListViewActivity extends AppCompatActivity {
    ActivitySpaceShipListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpaceShipListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}