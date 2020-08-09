package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fastfood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastfood);
    }
    public void fpizza(View view)
    {
        startActivity(new Intent(this,FastFood1.class));
    }
    public void fburger(View view)
    {
        startActivity(new Intent(this,FastFood2.class));
    }
    public void fshawarma(View view)
    {
        startActivity(new Intent(this,FastFood3.class));
    }
    public void fsandwich(View view)
    {
        startActivity(new Intent(this,FastFood4.class));
    }
}
