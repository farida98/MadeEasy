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

import org.w3c.dom.Text;

import static android.content.DialogInterface.*;
import static com.example.madeeasy.DatabaseContract.USERS.COL_EMAIL;
import static com.example.madeeasy.DatabaseContract.USERS.TABLE_NAME;

public class signup extends AppCompatActivity {
    DatabaseHelper dbHelper;
    EditText et1, et2, et3, et4;
    AlertDialog.Builder builder,builder1,builder2,builder3;
    SQLiteDatabase db, db1;
    String val1;
    String val2;
    String val3;
    String val4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);
        builder1 = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);
        builder3 = new AlertDialog.Builder(this);
        setContentView(R.layout.activity_signup);
        dbHelper = new DatabaseHelper(this);
    }

    public void InsertData(View view) {
        db = dbHelper.getWritableDatabase();

        et1 = (EditText) findViewById(R.id.ed1);
        et2 = (EditText) findViewById(R.id.ed2);
        et3 = (EditText) findViewById(R.id.ed3);
        et4 = (EditText) findViewById(R.id.ed4);

        val1 = et1.getText().toString().trim();
        val2 = et2.getText().toString().trim();
        val3 = et3.getText().toString().trim();
        val4 = et4.getText().toString().trim();

        ContentValues values = new ContentValues();
        if (!val1.matches("") && !val2.matches("") && !val3.matches("") && !val4.matches("")) {
            if (!val1.matches("") && !val2.matches("") && !val3.matches("") && !val4.matches("")) {
                if (!Patterns.EMAIL_ADDRESS.matcher(val2).matches()) {
                    builder1.setMessage("Enter valid format of email")
                            .setCancelable(false);
                    builder1.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();
                        }
                    });
                    //Creating dialog box
                    AlertDialog alert = builder1.create();
                    alert.show();

                } else if (val3.equals(val4)) {
                    if (checkIfExists(val2)) {
                        builder2.setMessage("Email already exists")
                                .setCancelable(false);
                        builder2.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                        //Creating dialog box
                        AlertDialog alert = builder2.create();
                        alert.show();
                    } else {
                        values.put(DatabaseContract.USERS.COL_NAME, val1);
                        values.put(COL_EMAIL, val2);
                        values.put(DatabaseContract.USERS.COL_PASSWORD, val3);

                        long newRowId = db.insert(TABLE_NAME, null, values);
                        if (newRowId > 0) {
                            Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "ERRROR " + newRowId, Toast.LENGTH_SHORT).show();

                        }

                        db.close();
                        Intent Next = new Intent(this, HomeActivity.class);
                        startActivity(Next);
                    }
                } else {
                    builder.setMessage("Password and confirm Password fields must be same")
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
        } else {
            builder3.setMessage("All fields must be filled")
                    .setCancelable(false);
            builder3.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //  Action for 'NO' Button
                    dialog.cancel();
                }
            });
            //Creating dialog box
            AlertDialog alert = builder3.create();
            alert.show();
        }
    }

    public boolean checkIfExists(String userEmail) {
        db1 = dbHelper.getWritableDatabase();


        String query = "select " + COL_EMAIL + " from " + TABLE_NAME;
        Cursor cursor = db1.rawQuery(query, null);
        String existEmail;

        if (cursor.moveToFirst()) {
            do {

                existEmail = cursor.getString(0);
                if (existEmail.equals(userEmail)) {
                    return true;
                }
            } while (cursor.moveToNext());
        }
        return false;
    }
}