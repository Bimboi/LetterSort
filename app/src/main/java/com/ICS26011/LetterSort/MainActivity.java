package com.ICS26011.LetterSort;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // show toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        checkIfBlackMode();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // based on choice of user in toolbar options
        switch (id) {
            case R.id.action_about:
                startActivity(new Intent(getApplicationContext(), About.class));
                break;
            case R.id.action_color_mode:
                setColor();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setColor(){
        // initialize objects to be configured
        ConstraintLayout contentMain = findViewById(R.id.content_main);
        ConstraintLayout fragmentFirst = findViewById(R.id.fragment_first);
        TextView input = findViewById(R.id.letter_input);
        TextView sorted = findViewById(R.id.sorted);

        //initialize resources
        int colorSomewhatBlack = getResources().getColor(R.color.colorSomewhatBlack);
        int colorGray = getResources().getColor(R.color.colorGray);
        int colorWhite = getResources().getColor(R.color.colorWhite);

        // sample persistent storage implementation
        SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS", MODE_PRIVATE).edit();

        if (input.getCurrentTextColor() == colorGray) {
            // change color of content_main.xml background
            contentMain.setBackgroundColor(colorSomewhatBlack);
            // change color of fragment_first.xml background
            fragmentFirst.setBackgroundColor(colorSomewhatBlack);

            // change color of input preview background
            input.setBackgroundColor(colorSomewhatBlack);
            // change color of input preview hint text
            input.setHintTextColor(colorWhite);
            // change color of input preview text
            input.setTextColor(colorWhite);
            // change color of sorted output background
            sorted.setBackgroundColor(colorSomewhatBlack);
            // change color of sorted output text
            sorted.setTextColor(colorWhite);

            // used to apply color mode to about developers activity
            editor.putString("mode", "Black");
        } else {
            // same as above but different color
            contentMain.setBackgroundColor(colorWhite);
            fragmentFirst.setBackgroundColor(colorWhite);

            input.setBackgroundColor(colorWhite);
            input.setHintTextColor(colorGray);
            input.setTextColor(colorGray);
            sorted.setBackgroundColor(colorWhite);
            sorted.setTextColor(colorGray);

            editor.putString("mode", "White");
        }
        editor.apply();
    }

    private void checkIfBlackMode(){
        ConstraintLayout contentMain = findViewById(R.id.content_main);

        int colorSomewhatBlack = getResources().getColor(R.color.colorSomewhatBlack);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS", MODE_PRIVATE);

        if(Objects.equals(prefs.getString("mode", ""), "Black")){
            contentMain.setBackgroundColor(colorSomewhatBlack);
        }
    }
}