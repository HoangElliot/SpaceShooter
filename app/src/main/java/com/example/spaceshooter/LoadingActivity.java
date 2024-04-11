package com.example.spaceshooter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.spaceshooter.databinding.ActivityLoadingBinding;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        runProgressBar();
    }

    void runProgressBar() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                count++;

                progressBar.setProgress(count);
                if (count >= 100) {
                    t.cancel();

                    Intent intent = new Intent(LoadingActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                }
            }
        };

        t.schedule(tt, 0, 40);
    }
}