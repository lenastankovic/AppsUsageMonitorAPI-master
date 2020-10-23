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

public class Humidity_5 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Humidity";
    private SensorManager sensorManager;
    Sensor humi;

    TextView humidityVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);

        humidityVal= (TextView) findViewById(R.id.humidityVal);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        humi=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        sensorManager.registerListener(com.example.appusage.Humidity_5.this, humi, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered humidity listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: humdity: " + event.values[0] );

        humidityVal.setText("Humidity: " + event.values[0]+" ");

    }
}