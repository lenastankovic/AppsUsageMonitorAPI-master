package com.example.appusage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Light_4 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Light";
    private SensorManager sensorManager;
    Sensor light;

    TextView lightVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);

        lightVal=(TextView) findViewById(R.id.lightVal);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(com.example.appusage.Light_4.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered light listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: light: " + event.values[0] );

        lightVal.setText("X - Value: " + event.values[0]+" lux");
    }
}