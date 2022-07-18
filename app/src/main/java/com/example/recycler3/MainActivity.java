package com.example.recycler3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.recycler3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        View v = b.getRoot();
        setContentView(v);
        setupMenu();
        initClicker();
    }

    private void initClicker() {
        b.imageCreate.setOnClickListener(this);
        b.textCreate.setOnClickListener(this);
        b.imagePets.setOnClickListener(this);
        b.textPets.setOnClickListener(this);
    }

    private void setupMenu() {
        SharedPreferences sharedPreferences = getSharedPreferences("prefName1", MODE_PRIVATE);
        if (!sharedPreferences.getString("name1", "").equals("")) {
            b.imageCreate.setVisibility(View.GONE);
            b.imagePets.setVisibility(View.VISIBLE);

            b.textCreate.setVisibility(View.GONE);
            b.textPets.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageCreate:
                startCreate();
                break;

            case R.id.textCreate:
                startCreate();
                break;

            case R.id.imagePets:
                startPets();
                break;

            case R.id.textPets:
                startPets();
                break;
        }
    }

    public void startCreate() {
        Intent intent = new Intent(MainActivity.this, Create.class);
        intent.putExtra("key", "FragmentCreate");
        startActivity(intent);
    }

    public void startPets() {
        Intent intent = new Intent(MainActivity.this, Create.class);
        intent.putExtra("key", "FragmentPets");
        startActivity(intent);
    }
}