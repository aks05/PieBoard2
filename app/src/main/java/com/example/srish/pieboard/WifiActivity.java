package com.example.srish.pieboard;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WifiActivity extends AppCompatActivity {


    WifiManager wifiManager;
    List<String> wifiNames;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        ListView wifiList = (ListView) findViewById(R.id.wifi_list);
        Button proceedButton=(Button) findViewById(R.id.proceed_button);
        wifiNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, wifiNames);
        wifiList.setAdapter(adapter);


        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiReceiver wifiReceiver = new WifiReceiver();
        registerReceiver(wifiReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WifiActivity.this, ParaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 87);
            } else//if the permission is granted
                wifiManager.startScan();

        } else
            wifiManager.startScan();
    }


    public class WifiReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = wifiManager.getScanResults();

                wifiNames.clear();
                for (int i = 0; i < mScanResults.size(); i++)
                    wifiNames.add(mScanResults.get(i).SSID);

                adapter.notifyDataSetChanged();
            }
        }
    }

}
