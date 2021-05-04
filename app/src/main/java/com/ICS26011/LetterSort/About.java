package com.ICS26011.LetterSort;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

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

        String devDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec at " +
                "lacus purus. Sed nisi dolor, venenatis a leo sit amet, dapibus ultricies dui. " +
                "Duis eget ex malesuada, sagittis odio id, vehicula risus. Morbi tincidunt mi in " +
                "mattis vestibulum. Mauris enim arcu, fermentum efficitur tristique id, " +
                "facilisis vel lectus. Pellentesque convallis lectus vel urna dictum, " +
                "vitae rhoncus nibh scelerisque. Integer in quam lacus.";
        TextView desc = findViewById(R.id.dev_description);
        desc.setText(devDescription);
    }

    private void setColorMode() {
        ConstraintLayout contentAbout = findViewById(R.id.content_about);
        TextView labelAboutDev = findViewById(R.id.dev_label);
        TextView author = findViewById(R.id.author_name);
        TextView desc = findViewById(R.id.dev_description);

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
        } else if (Objects.equals(preferences.getString("mode", ""), "White")) {
            // same but white
            contentAbout.setBackgroundColor(colorWhite);
            labelAboutDev.setTextColor(colorGray);
            author.setTextColor(colorGray);
            desc.setTextColor(colorGray);
        }
    }
}