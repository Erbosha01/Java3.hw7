package com.geektech.java3hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektech.java3hw7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container_one,new FirstFragment()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.container_two,new SecondFragment()).commit();
        }
    }
}