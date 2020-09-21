package com.example.appchonhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.appchonhinh.databinding.ActivityRandomBinding;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    ActivityRandomBinding mbinding;
    CountDownTimer mTimer;
    Random mRandom;
    String[] mArrayNamesAnimals;
    int midHinhRandom = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        mbinding = ActivityRandomBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());

        init();
        randomImage();

    }


    private void init() {
        mRandom = new Random();
        mArrayNamesAnimals = getResources().getStringArray(R.array.array_animals);
    }

    private void randomImage() {
        int index = mRandom.nextInt(mArrayNamesAnimals.length);
        midHinhRandom = getResources().getIdentifier(
                mArrayNamesAnimals[index], "drawable", getPackageName()
        );
        mbinding.imgRandom.setImageResource(midHinhRandom);
        MyCountDown.startCoundDown(new OnlistenCountDown() {
            @Override
            public void countDown(long time) {
                mbinding.tvTime.setText(String.format("TIME : %ds",time));
            }
        });

    }
}