package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Meatdishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meatdishes);
    }

    public void meat1(View view)
    {
        startActivity(new Intent(this,MeatDish1.class));
    }
    public void meat2(View view)
    {
        startActivity(new Intent(this,MeatDish2.class));
    }
    public void meat3(View view)
    {
        startActivity(new Intent(this,MeatDish3.class));
    }
    public void meat4(View view)
    {
        startActivity(new Intent(this,MeatDish4.class));
    }
}

