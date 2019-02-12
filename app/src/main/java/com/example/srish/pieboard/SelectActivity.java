package com.example.srish.pieboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends AppCompatActivity {
    public final static String EXTRA_OPTION = "com.example.srish.pieboard.OPTION";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void Im1(View view) {
        Intent intent =new Intent(this, WifiActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(EXTRA_OPTION,1);
        intent.putExtras(extras);
                startActivity(intent);
    }


    public void Im2(View view) {
        Intent intent =new Intent(this, WifiActivity.class);
        Bundle extras = new Bundle();
        extras.putInt(EXTRA_OPTION,2);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
