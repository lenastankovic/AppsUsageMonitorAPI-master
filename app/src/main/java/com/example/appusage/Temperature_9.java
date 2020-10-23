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

public class Temperature_9 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Temperature";
    private SensorManager sensorManager;
    Sensor temperature;

    TextView tempVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        tempVal=(TextView) findViewById(R.id.tempVal);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        temperature=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorManager.registerListener(com.example.appusage.Temperature_9.this, temperature, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered temperature listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: temperature: " + event.values[0] );

        tempVal.setText("Temperature: " + event.values[0]+" Celsius");

    }
}