package com.example.madeeasy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.madeeasy.DatabaseContract.USERS.COL_EMAIL;
import static com.example.madeeasy.DatabaseContract.USERS.TABLE_NAME;
import static com.example.madeeasy.DatabaseContract.USERS1.COL_FEEDBACK;
import static com.example.madeeasy.DatabaseContract.USERS1.COL_NAME;

public class Feedback extends AppCompatActivity {
    DatabaseHelper dbHelper1;
    SQLiteDatabase db3;
    AlertDialog.Builder builder,builder1;
    String val1,val2;
    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);
        builder1 = new AlertDialog.Builder(this);
        setContentView(R.layout.activity_feedback);
        dbHelper1 = new DatabaseHelper(this);
    }

    public void record(View view) {
        db3 = dbHelper1.getWritableDatabase();

        et1 = (EditText) findViewById(R.id.ed1);
        et2 = (EditText) findViewById(R.id.ed2);
        val1 = et1.getText().toString().trim();
        val2 = et2.getText().toString().trim();
        ContentValues values = new ContentValues();
        if (!val1.matches("") && !val2.matches(""))
        {

            values.put(COL_NAME, val1);
            values.put(COL_FEEDBACK, val2);
            long newRowId = db3.insert(DatabaseContract.USERS1.TABLE_NAME, null, values);
            if (newRowId > 0) {
                Toast.makeText(this, "Your feedback recorded." + newRowId, Toast.LENGTH_SHORT).show();
                db3.close();
                Intent Next = new Intent(this, HomeActivity.class);
                startActivity(Next);

            } else {
                Toast.makeText(this, "ERRROR " + newRowId, Toast.LENGTH_SHORT).show();

            }

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