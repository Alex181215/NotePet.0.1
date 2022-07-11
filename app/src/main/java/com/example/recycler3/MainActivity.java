package com.example.recycler3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recycler3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Log.d("TagActivity", "onCreate");
        setupMenu();
    }

    private void setupMenu(){
        SharedPreferences sharedPreferences = getSharedPreferences("prefName"+1, MODE_PRIVATE);
        if(!sharedPreferences.getString("name1", "").equals("")){
            Intent intent = new Intent(MainActivity.this, Create.class);
            intent.putExtra("key", "FragmentPets");
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, Create.class);
            intent.putExtra("key", "FragmentCreate");
            startActivity(intent);
        }
    }

    public void start(View view) {
        Intent intent = new Intent(MainActivity.this, Create.class);
        intent.putExtra("key", "FragmentCreate");
        startActivity(intent);
    }

}