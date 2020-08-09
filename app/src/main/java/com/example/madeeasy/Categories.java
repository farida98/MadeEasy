package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }
    public void rice(View view)
    {
        startActivity(new Intent(this, Ricedishes.class));
    }
    public void meat(View view)
    {
        startActivity(new Intent(this, Meatdishes.class));
    }
    public void fastfood(View view)
    {
        startActivity(new Intent(this, Fastfood.class));
    }
    public void desserts(View view)
    {
        startActivity(new Intent(this, Desserts.class));
    }
    public void breakfast(View view)
    {
        startActivity(new Intent(this,Breakfast.class));
    }
}
