package com.example.madeeasy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;


import static com.example.madeeasy.DatabaseContract.USERS2.TABLE_NAME;

public class AddRecipe extends AppCompatActivity {
    DatabaseHelper dbHelper;
    EditText et1, et2, et3, et4,et5;
    AlertDialog.Builder builder;
    SQLiteDatabase db;
    String val1;
    String val2;
    String val3;
    String val4;
    String val5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        dbHelper = new DatabaseHelper(this);
    }

    public void Insert(View view){
        db = dbHelper.getWritableDatabase();

        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
        et3 = (EditText) findViewById(R.id.e3);
        et4 = (EditText) findViewById(R.id.e4);
        et5 = (EditText) findViewById(R.id.e5);

        val1 = et1.getText().toString().trim();
        val2 = et2.getText().toString().trim();
        val3 = et3.getText().toString().trim();
        val4 = et4.getText().toString().trim();
        val5 = et5.getText().toString().trim();

        ContentValues values = new ContentValues();
        if (!val1.matches("") && !val2.matches("") && !val3.matches("") && !val4.matches("") && !val5.matches("")){
            values.put(DatabaseContract.USERS2.COL_RNAME, val1);
            values.put(DatabaseContract.USERS2.COL_TIME, val2);
            values.put(DatabaseContract.USERS2.COL_DISCRIPTION, val3);
            values.put(DatabaseContract.USERS2.COL_INGREDIENTS, val4);
            values.put(DatabaseContract.USERS2.COL_METHOD, val5);

            long newRowId = db.insert(TABLE_NAME, null, values);
            if (newRowId > 0) {
                Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "ERRROR " + newRowId, Toast.LENGTH_SHORT).show();

            }

            db.close();
            Intent Next = new Intent(this, ShowRecipe.class);
            startActivity(Next);
        }
        else {
            builder.setMessage("All fields must be filled")
                    .setCancelable(false);
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  Action for 'NO' Button
                    dialog.cancel();
                }
            });
            //Creating dialog box
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
