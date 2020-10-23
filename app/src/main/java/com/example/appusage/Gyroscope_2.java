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

public class Gyroscope_2 extends AppCompatActivity implements SensorEventListener {

    private  static final String TAG="Gyroscope_2";
    private SensorManager sensorManager;
    Sensor gyroscope;

    TextView xGyroValue, yGyroValue, zGyroValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        xGyroValue = (TextView) findViewById(R.id.xGyroValue);
        yGyroValue=(TextView) findViewById(R.id.yGyroValue);
        zGyroValue=(TextView) findViewById(R.id.zGyroValue);

        Log.d(TAG, "onCreate: Initializing Sensor Services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);

        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(com.example.appusage.Gyroscope_2.this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered gyroscope listener");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2]);

        xGyroValue.setText("X - Value: " + sensorEvent.values[0]+" rad/s");
        yGyroValue.setText("Y - Value: " + sensorEvent.values[1]+" rad/s");
        zGyroValue.setText("Z - Value: " + sensorEvent.values[2]+" rad/s");
    }
}