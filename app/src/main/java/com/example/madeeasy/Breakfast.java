package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
    }
    public void Break1(View view)
    {
        startActivity(new Intent(this,Breakfast1.class));
    }
    public void Break2(View view)
    {
        startActivity(new Intent(this,Breakfast2.class));
    }
    public void Break3(View view)
    {
        startActivity(new Intent(this,Breakfast3.class));
    }
    public void Break4(View view)
    {
        startActivity(new Intent(this,Breakfast4.class));
    }
}
