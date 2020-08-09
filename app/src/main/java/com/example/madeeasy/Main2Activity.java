package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.DialogInterface.*;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.madeeasy.DatabaseContract.USERS.COL_EMAIL;
import static com.example.madeeasy.DatabaseContract.USERS.COL_PASSWORD;
import static com.example.madeeasy.DatabaseContract.USERS.TABLE_NAME;

public class Main2Activity extends AppCompatActivity {
    SQLiteDatabase db2;
    AlertDialog.Builder builder,builder1,builder2;
    EditText et1, et2;
    String val1;
    String val2;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);
        builder1 = new AlertDialog.Builder(this);
        builder2 = new AlertDialog.Builder(this);
        setContentView(R.layout.activity_main2);
        dbHelper = new DatabaseHelper(this);
    } public void login(View v) {
        et1 = (EditText) findViewById(R.id.e1);
        et2 = (EditText) findViewById(R.id.e2);
        val1 = et1.getText().toString().trim();
        val2 = et2.getText().toString().trim();
        if (!val1.matches("") && !val2.matches("")) {
            if (checkIfExists(val1,val2))
            {

                Intent i1 = new Intent(this,
                        HomeActivity.class);
                startActivity(i1);
            } else {
                builder.setMessage("Login Error! Wrong Email or Password. ")
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
        else{
            builder2.setMessage("All fields must be filled")
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

        }
    }
    public void signup(View v)
    {
        Intent i2=new Intent(this, signup.class);
        startActivity(i2);
    }
    public boolean checkIfExists(String userEmail,String passw)
    {
        db2= dbHelper.getReadableDatabase();
        String[] column = {COL_EMAIL};
        String selection = COL_EMAIL + "=?" + " and " +COL_PASSWORD + "=?";
        String[] selectionArgs = { userEmail, passw } ;
        Cursor cursor = db2.query(TABLE_NAME,column,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db2.close();
        if(count>0)
            return true;
        else
            return false;
    }
}