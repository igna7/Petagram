package com.ignacioruben7.petagram.menu_option;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ignacioruben7.petagram.R;

public class AboutAutor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_autor);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar3);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
