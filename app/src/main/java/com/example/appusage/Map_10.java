//package com.example.appusage;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentActivity;
//
//import android.os.Bundle;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
//
//    GoogleMap map;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.activity_map);
//        mapFragment.getMapAsync(this);
//    }
//
//    @Override
//    public void  onMapReady(GoogleMap googleMap) {
//        LatLng Nis=new LatLng(43.3209, 21.8958);
//        map.addMarker(new MarkerOptions().position(Nis).title("Nis"));
//        map.moveCamera(CameraUpdateFactory.newLatLng(Nis));
//    }
//
//}