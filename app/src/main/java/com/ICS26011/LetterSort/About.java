package com.ICS26011.LetterSort;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setColorMode();

        String devDescription = "I’m Venz Dwight Kwan, a third year student BSIT in university of Santo Tomas Manila. " +
                "I live in Bacoor, Cavite. I created this app for my 1st project in Applications Development And Emerging Technologies 3 (Mobile programming). " +
                "To our beloved Professor Alma Perol thank you for sharing your knowledge to us your student we love you ma’am whahahahahaha";
        TextView desc = findViewById(R.id.dev_description);
        desc.setText(devDescription);
    }

    private void setColorMode() {
        ConstraintLayout contentAbout = findViewById(R.id.content_about);
        TextView labelAboutDev = findViewById(R.id.dev_label);
        TextView author = findViewById(R.id.author_name);
        TextView desc = findViewById(R.id.dev_description);
        TextView quote = findViewById(R.id.dev_quote);

        int colorSomewhatBlack = getResources().getColor(R.color.colorSomewhatBlack);
        int colorGray = getResources().getColor(R.color.colorGray);
        int colorWhite = getResources().getColor(R.color.colorWhite);

        SharedPreferences preferences = getSharedPreferences("MY_PREFS", MODE_PRIVATE);

        if (Objects.equals(preferences.getString("mode", ""), "Black")) {
            // change color of content_about.xml background
            contentAbout.setBackgroundColor(colorSomewhatBlack);
            // change color of about dev label text
            labelAboutDev.setTextColor(colorWhite);
            // change color of author name
            author.setTextColor(colorWhite);
            // change color of author description
            desc.setTextColor(colorWhite);
            // change color of quote
            quote.setTextColor(colorWhite);
        } else if (Objects.equals(preferences.getString("mode", ""), "White")) {
            // same but white
            contentAbout.setBackgroundColor(colorWhite);
            labelAboutDev.setTextColor(colorGray);
            author.setTextColor(colorGray);
            desc.setTextColor(colorGray);
            quote.setTextColor(colorGray);
        }
    }
}