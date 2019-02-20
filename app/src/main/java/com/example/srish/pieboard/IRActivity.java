package com.example.srish.pieboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class IRActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    Intent intent;
    public final static String EXTRA_RETURN_MESSAGE_1 =
            "com.example.srish.pieboard.RETURN_MESSAGE_1";
    public final static String EXTRA_RETURN_MESSAGE_2 =
            "com.example.srish.pieboard.RETURN_MESSAGE_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir);
        intent=new Intent();
        Intent get=getIntent();
        Bundle extras=get.getExtras();
        int option=extras.getInt(SelectActivity.EXTRA_OPTION);
        // Create the spinner col_1.
        Spinner spinner = findViewById(R.id.col_1);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.col_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        if(option==1) {
            Spinner spinner2 = findViewById(R.id.row_1);
            if (spinner2 != null) {
                spinner2.setOnItemSelectedListener(this);
            }
            // Create ArrayAdapter using the string array and default spinner layout.
            ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.row1_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears.
            adapter2.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner.
            if (spinner2 != null) {
                spinner2.setAdapter(adapter2);
            }
        }
        if(option==2) {
            Spinner spinner2 = findViewById(R.id.row_1);
            if (spinner2 != null) {
                spinner2.setOnItemSelectedListener(this);
            }
            // Create ArrayAdapter using the string array and default spinner layout.
            ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this,
                    R.array.row2_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears.
            adapter2.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner.
            if (spinner2 != null) {
                spinner2.setAdapter(adapter2);
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.para, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_submit) {
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinner_item;
        switch(parent.getId()) {
            case R.id.col_1:
                spinner_item = parent.getItemAtPosition(position).toString();
                // Do something with spinner_item string.
                intent.putExtra(EXTRA_RETURN_MESSAGE_1, spinner_item);
                break;
            case R.id.row_1:
                spinner_item = parent.getItemAtPosition(position).toString();
                // Do something with spinner_item string.
                intent.putExtra(EXTRA_RETURN_MESSAGE_2, spinner_item);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
