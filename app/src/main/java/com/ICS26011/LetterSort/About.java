package com.ICS26011.LetterSort;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

        String devDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec at " +
                "lacus purus. Sed nisi dolor, venenatis a leo sit amet, dapibus ultricies dui. " +
                "Duis eget ex malesuada, sagittis odio id, vehicula risus. Morbi tincidunt mi in " +
                "mattis vestibulum. Mauris enim arcu, fermentum efficitur tristique id, " +
                "facilisis vel lectus. Pellentesque convallis lectus vel urna dictum, " +
                "vitae rhoncus nibh scelerisque. Integer in quam lacus.";
        TextView desc = findViewById(R.id.app_description);
        desc.setText(devDescription);
    }
}