package com.example.srish.pieboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ParaActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final int VR_REQUEST = 1;
    public static final int IR_REQUEST = 2;
    public static final int RE_REQUEST = 3;
    public final static String EXTRA_OPTION = "com.example.srish.pieboard.OPTION";
    TextView textView;
    Intent intentoption;
    int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para);
        textView=(TextView) findViewById(R.id.textView4);
        intentoption=getIntent();
        Bundle extras=intentoption.getExtras();
        option =  extras.getInt(SelectActivity.EXTRA_OPTION);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void Ovr(View view) {
        Intent intent=new Intent(this,VRActivity.class);
        Bundle extras=new Bundle();
        extras.putInt(EXTRA_OPTION,option);
        intent.putExtras(extras);
        startActivityForResult(intent,VR_REQUEST);
    }
    public void Ore(View view) {
        Intent intent=new Intent(this,VRActivity.class);
        Bundle extras=new Bundle();
        extras.putInt(EXTRA_OPTION,option);
        intent.putExtras(extras);
        startActivityForResult(intent,RE_REQUEST);
    }

    public void Oir(View view) {
        Intent intent=new Intent(this,IRActivity.class);
        Bundle extras=new Bundle();
        extras.putInt(EXTRA_OPTION,option);
        intent.putExtras(extras);
        startActivityForResult(intent,IR_REQUEST);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            textView.setText("You have not selected any Parameter");
            return true;
        }
        if (id == R.id.action_result) {
            Intent intent=new Intent(this,showResultActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Instruction) {
            Intent intent =new Intent(this,Instrnc.class);
            startActivity(intent);

        } else if (id == R.id.nav_GetStarted) {
            Intent intent =new Intent(this,WelcomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ChangeBreadboard) {
            Intent intent= new Intent(this,SelectActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VR_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (textView.getText().equals("You have not selected any Parameter"))
                    textView.setText("Voltage:Initial Point:" + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_2) + " Final Point: "
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_3)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_4) + "\n");
                else
                    textView.append("Voltage:Initial Point:" + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_2) + " Final Point: "
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_3)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_4) + "\n");
                // process data
            }
        }
        if (requestCode == IR_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (textView.getText().equals("You have not selected any Parameter"))
                    textView.setText("Current: Point:" + data.getStringExtra(IRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(IRActivity.EXTRA_RETURN_MESSAGE_2) + "\n");
                else
                    textView.append("Current: Point:" + data.getStringExtra(IRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_2) + "\n");
                // process data
            }
        }
        if (requestCode == RE_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (textView.getText().equals("You have not selected any Parameter"))
                    textView.setText("Resistance:Initial Point:" + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_2) + " Final Point: "
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_3)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_4) + "\n");
                else
                    textView.append("Resistance:Initial Point:" + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_1)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_2) + " Final Point: "
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_3)
                            + data.getStringExtra(VRActivity.EXTRA_RETURN_MESSAGE_4) + "\n");
                // process data
            }
        }
    }
    }
