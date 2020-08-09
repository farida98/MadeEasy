package com.example.madeeasy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import static android.content.DialogInterface.*;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView.OnItemSelectedListener;
public class HomeActivity extends AppCompatActivity  {
    SearchView sv;
    AlertDialog.Builder builder,builder1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);
        builder1 = new AlertDialog.Builder(this);

        setContentView(R.layout.activity_home);
    }
    public void category(View view)
    {
        startActivity(new Intent(this, Categories.class));
    }
    public void feedback(View view)
    {
        startActivity(new Intent(this, Feedback.class));
    }
    public void add(View view)
    {
        startActivity(new Intent(this, AddRecipe.class));
    }
    public void contact(View view)
    {
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.setData(Uri.parse("mailto:AFFQ.eamil@gmail.com"));
        email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        email.putExtra(Intent.EXTRA_TEXT, "My Email message");
        startActivity(email);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.share:
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://com.example.madeeasy";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
                return true;
            case R.id.follow:
                Uri uri = Uri.parse("https://instagram.com/madeeasyby_affa?igshid=1wdhr3646zw8s");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                return true;
            case R.id.about:
                builder.setMessage("Made Easy is a cuisine Recipe Application, where variety of recipees will be shared to you." +
                        "The purpose of this app is to share the methods of preparing delicious and easy food.\n\n\n" +
                        "Thanks for your love and support ")
                        .setCancelable(false);

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();
                    }
                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                alert.setTitle("Made Easy");
                alert.show();

                return true;
            case R.id.logout:
                Intent Next = new Intent(this, Main2Activity.class);
                startActivity(Next);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void TodayKeema(View view)
    {
        startActivity(new Intent(this,MeatDish1.class));
    }
    public void TodayFries(View view)
    {
        startActivity(new Intent(this,FastFood1.class));
    }
    public void TodayDessert(View view)
    {
        startActivity(new Intent(this,Dessert1.class));
    }
    public void TodayBreakfast(View view)
    {
        startActivity(new Intent(this,Breakfast2.class));
    }
    public void Todayrice(View view)
    {
        startActivity(new Intent(this,RiceDish2.class));
    }
    public void Todaymeat(View view)
    {
        startActivity(new Intent(this,MeatDish2.class));
    }


    public void search(View view){
        sv=(SearchView)findViewById(R.id.simpleSearchView);
        String s=sv.getQuery().toString().trim();
       if(s.equalsIgnoreCase("Colorful Rice Salad")){
       Intent r1=new Intent(this,RiceDish1.class);
       startActivity(r1);
       }
       else if(s.equalsIgnoreCase("Salmon Fried Rice")){
           Intent r2=new Intent(this,RiceDish2.class);
           startActivity(r2);
       }
       else if(s.equalsIgnoreCase("Rice with Mushrooms")){
           Intent r3=new Intent(this,RiceDish3.class);
           startActivity(r3);
       }
       else if(s.equalsIgnoreCase("Bombay Biryani")){
           Intent r4=new Intent(this,RiceDish4.class);
           startActivity(r4);
       }
       else if(s.equalsIgnoreCase("Beef Keema")){
           Intent m1=new Intent(this,MeatDish1.class);
           startActivity(m1);
       }
       else if(s.equalsIgnoreCase("Beef Metaballs")){
           Intent m2=new Intent(this,MeatDish2.class);
           startActivity(m2);
       }
       else if(s.equalsIgnoreCase("Slow cooker beef")){
           Intent m3=new Intent(this,MeatDish3.class);
           startActivity(m3);
       }
       else if(s.equalsIgnoreCase("Beaf Stew")){
           Intent m4=new Intent(this,MeatDish4.class);
           startActivity(m4);
       }
       else if(s.equalsIgnoreCase("Poached eggs")){
           Intent b1=new Intent(this,Breakfast1.class);
           startActivity(b1);
       }
       else if(s.equalsIgnoreCase("Banana pancakes")){
           Intent b2=new Intent(this,Breakfast2.class);
           startActivity(b2);
       }
       else if(s.equalsIgnoreCase("Simple nutty pancakes")){
           Intent b3=new Intent(this,Breakfast3.class);
           startActivity(b3);
       }
       else if(s.equalsIgnoreCase("Sunshine smoothie")){
           Intent b4=new Intent(this,Breakfast4.class);
           startActivity(b4);
       }
       else if(s.equalsIgnoreCase("Coconut Kheer")){
           Intent d1=new Intent(this,Dessert1.class);
           startActivity(d1);
       }
       else if(s.equalsIgnoreCase("Royal Falooda")){
           Intent d2=new Intent(this,Dessert2.class);
           startActivity(d2);
       }
       else if(s.equalsIgnoreCase("Tiramisu Poke Cake")){
           Intent d3=new Intent(this,Dessert3.class);
           startActivity(d3);
       }
       else if(s.equalsIgnoreCase("Sawayyan Bites")){
           Intent d4=new Intent(this,Dessert4.class);
           startActivity(d4);
       }
       else if(s.equalsIgnoreCase("Pizza Fries")){
           Intent f1=new Intent(this,FastFood1.class);
           startActivity(f1);
       }
       else if(s.equalsIgnoreCase("Slider Burger")){
           Intent f2=new Intent(this,FastFood2.class);
           startActivity(f2);
       }
       else if(s.equalsIgnoreCase("Chicken Shawarma")){
           Intent f3=new Intent(this,FastFood3.class);
           startActivity(f3);
       }
       else if(s.equalsIgnoreCase("Club Sandwich recipe")){
           Intent f4=new Intent(this,FastFood4.class);
           startActivity(f4);
       }
       else {
           builder1.setMessage("Enter correct name for recipe ")
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

       }

    }
}





