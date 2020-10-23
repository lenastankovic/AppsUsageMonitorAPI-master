package com.example.appusage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnAccelerometer;
    private Button btnGyroscope;
    private Button btnMagnetometer;
    private Button btnLight;
    private Button btnHumidity;
    private Button btnPressure;
    private Button btnAppUsage;
    private Button btnActivityRecognition;
    private Button btnTemperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccelerometer = (Button) findViewById(R.id.btnAccelerometer);
        btnAccelerometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAcc();
            }
        });

        btnGyroscope = (Button) findViewById(R.id.btnGyroscope);
        btnGyroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGyroscope();
            }
        });

        btnMagnetometer = (Button) findViewById(R.id.btnMagnetometer);
        btnMagnetometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMagnetometer();
            }
        });

        btnLight = (Button) findViewById(R.id.btnLight);
        btnLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLight();
            }
        });

        btnHumidity = (Button) findViewById(R.id.btnHumidity);
        btnHumidity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHumidity();
            }
        });

        btnPressure = (Button) findViewById(R.id.btnPressure);
        btnPressure.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    openPressure();
                }
        });

        btnAppUsage = (Button) findViewById(R.id.btnAppUsage);
        btnAppUsage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAppUsage();
            }
        });

        btnActivityRecognition = (Button) findViewById(R.id.btnActivityRecognition);
        btnActivityRecognition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivityRecognition();
            }
        });

        btnTemperature = (Button) findViewById(R.id.btnTemperature);
        btnTemperature.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openTemperature();
            }
        });

    }

    public void openAcc(){
        Intent intent1 = new Intent(this, com.example.appusage.Accelerometer_1.class);
        startActivity(intent1);
    }

    public  void openGyroscope(){
        Intent intent2 = new Intent(this, com.example.appusage.Gyroscope_2.class);
        startActivity(intent2);
    }

    public void openMagnetometer(){
        Intent intent3 = new Intent(this, com.example.appusage.Magnetometer_3.class);
        startActivity(intent3);
    }

    public void openLight(){
        Intent intent4 = new Intent(this, com.example.appusage.Light_4.class);
        startActivity(intent4);
    }

    public void openHumidity(){
        Intent intent5 = new Intent(this, com.example.appusage.Humidity_5.class);
        startActivity(intent5);
    }

    public void openPressure(){
        Intent intent6 = new Intent(this, com.example.appusage.Pressure_6.class);
        startActivity(intent6);
    }

    public void openAppUsage(){
        Intent intent7 = new Intent(this, com.example.appusage.activity.AppMainActivity.class);
        startActivity(intent7);
    }

    public void openActivityRecognition(){
        Intent intent8 = new Intent(this, com.example.appusage.ActivityRecognition_8.class);
        startActivity(intent8);
    }

    public void openTemperature(){
        Intent intent9 = new Intent(this, com.example.appusage.Temperature_9.class);
        startActivity(intent9);
    }


}