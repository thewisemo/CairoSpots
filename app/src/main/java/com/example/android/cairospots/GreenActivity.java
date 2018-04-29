package com.example.android.cairospots;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new GreenFragment())
                .commit();
    }
}
