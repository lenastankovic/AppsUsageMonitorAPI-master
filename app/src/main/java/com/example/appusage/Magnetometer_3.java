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

public class Magnetometer_3 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Magnetometer_3";
    private SensorManager sensorManager;
    Sensor magnetometer;

    TextView xMagnValue, yMagnValue, zMagnValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetometer);

        xMagnValue = (TextView) findViewById(R.id.xMagnValue);
        yMagnValue=(TextView) findViewById(R.id.yMagnValue);
        zMagnValue=(TextView) findViewById(R.id.zMagnValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);
        sensorManager.registerListener(com.example.appusage.Magnetometer_3.this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered magnetometer listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEventevent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEventevent.values[0] + "Y: " + sensorEventevent.values[1] + "Z: " + sensorEventevent.values[2]);

        xMagnValue.setText("X - Value: " + sensorEventevent.values[0] + "  μT");
        yMagnValue.setText("Y - Value: " + sensorEventevent.values[1] + "  μT");
        zMagnValue.setText("Z - Value: " + sensorEventevent.values[2] + "  μT");
    }
}