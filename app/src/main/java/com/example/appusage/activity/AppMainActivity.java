package com.example.appusage.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appusage.R;
import com.example.appusage.adapter.AppAdapter;

import java.util.List;

import bot.box.appusage.contract.UsageContracts;
import bot.box.appusage.handler.Monitor;
import bot.box.appusage.model.AppData;
import bot.box.appusage.utils.Duration;

public class AppMainActivity extends AppCompatActivity implements UsageContracts.View
        , AdapterView.OnItemSelectedListener {

    private AppAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_usage);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 100);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Monitor.hasUsagePermission()) {
            Monitor.scan().getAppLists(this).fetchFor(Duration.TODAY);
            init();
        } else {
            Monitor.requestUsagePermission();
        }
    }

    private void init() {
        RecyclerView mRecycler = findViewById(R.id.recycler);
        mAdapter = new AppAdapter(this);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setVisibility(View.VISIBLE);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.duration));
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Monitor.scan().getAppLists(this).fetchFor(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    /**
     * @param usageData   list of application that has been within the duration for which query has been made.
     * @param mTotalUsage a sum total of the usage by each and every app with in the request duration.
     * @param duration    the same duration for which query has been made i.e.fetchFor(Duration...)
     */

    @Override
    public void getUsageData(List<AppData> usageData, long mTotalUsage, int duration) {
        mAdapter.updateData(usageData);
    }
}