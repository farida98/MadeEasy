package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class RecipeData extends AppCompatActivity {
    TextView t0,t1,t2,t3,t4,t5;
    Cursor c;
    SQLiteDatabase db;
    String s1,s2,s3,s4,s5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_data);
        t0=findViewById(R.id.t0);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        c.requery();
        while (c.moveToNext()) {

            Cursor resultSet = db.rawQuery("Select * from TABLE_NAME where COL_RNAME = name ",null);
            resultSet.moveToFirst();
            String Rname = resultSet.getString(0);
            String Rtime = resultSet.getString(1);
            String Rdiscription = resultSet.getString(2);
            String Ringredients = resultSet.getString(3);
            String Rmethod = resultSet.getString(4);

        db.close();
        t0.setText(Rname);
        t1.setText(Rname);
        t2.setText(Rtime);
        t3.setText(Rdiscription);
        t4.setText(Ringredients);
        t5.setText(Rmethod);
    }}
}
