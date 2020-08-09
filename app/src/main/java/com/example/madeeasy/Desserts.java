package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Desserts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desserts);
    }
    public void zafranikheer(View view) {
        startActivity(new Intent(this,Dessert1.class));
    }
    public void falooda(View view)
    {
        startActivity(new Intent(this,Dessert2.class));
    }
    public void cake(View view)
    {
        startActivity(new Intent(this,Dessert3.class));
    }
    public void sawayyan(View view)
    {
        startActivity(new Intent(this,Dessert4.class));
    }
}
