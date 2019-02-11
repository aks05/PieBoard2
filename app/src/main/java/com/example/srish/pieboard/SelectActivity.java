package com.example.srish.pieboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends AppCompatActivity {
    public static int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void Im1(View view) {
        i=1;
        Intent intent =new Intent(this, WifiActivity.class);
        startActivity(intent);
    }


    public void Im2(View view) {
        i=2;
        Intent intent =new Intent(this, WifiActivity.class);
        startActivity(intent);
    }


}
