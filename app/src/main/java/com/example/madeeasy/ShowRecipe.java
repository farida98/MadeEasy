package com.example.madeeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowRecipe extends AppCompatActivity {
    DatabaseHelper dbHelper;
    String s1,s2,s3,s4,s5;
    List<String> list = new ArrayList();
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recipe);
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

      // String[] columns = {DatabaseContract.USERS2.COL_RNAME};
        String sortOrder = DatabaseContract.USERS2.COL_RNAME + " ASC";
         c = db.query(DatabaseContract.USERS2.TABLE_NAME, null, null, null, null, null, sortOrder);

        while (c.moveToNext()) {

            String name1 = c.getString(0);
            list.add(name1);
        }
        ListView lv=(ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent1 = new Intent(ShowRecipe.this, RecipeData.class);
                String str = list.get(position);


                db.close();
                intent1.putExtra("name", str);

                startActivity(intent1);
            }
        });

    }

}
