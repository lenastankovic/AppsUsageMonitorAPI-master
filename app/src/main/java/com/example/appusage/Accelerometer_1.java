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

public class Accelerometer_1 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Accelerometer_1";
    private SensorManager sensorManager;
    Sensor accelerometer;

    TextView xValue, yValue, zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        xValue=(TextView) findViewById(R.id.xValue);
        yValue=(TextView) findViewById(R.id.yValue);
        zValue=(TextView) findViewById(R.id.zValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(com.example.appusage.Accelerometer_1.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    Log.d(TAG, "onCreate: Registered accelerometer listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

        xValue.setText("X - Value: " + sensorEvent.values[0]+" m/s^2");
        yValue.setText("Y - Value: " + sensorEvent.values[1]+" m/s^2");
        zValue.setText("Z - Value: " + sensorEvent.values[2]+" m/s^2");
    }
}