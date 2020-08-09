package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ricedishes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricedishes);
    }
    public void colorfulrice(View view)
        {
            startActivity(new Intent(this,RiceDish1.class));
        }
    public void salmonfriedrice(View view)
    {
        startActivity(new Intent(this,RiceDish2.class));
    }
    public void Mushroomsrice(View view)
    {
        startActivity(new Intent(this,RiceDish3.class));
    }
    public void bombaybiryani(View view)
    {
        startActivity(new Intent(this,RiceDish4.class));
    }

}
