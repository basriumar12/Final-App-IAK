package id.co.blogbasbas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    //deklarasi
    ImageView imgDetail;
    TextView txtDetail;
    private GoogleMap mMap;
    float l;
    float lg;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
            //inisialiasasi id
        imgDetail = (ImageView) findViewById(R.id.imgDetail);
        txtDetail = (TextView) findViewById(R.id.txtDetail);

        //get data intent

        Intent getData = getIntent();
        txtDetail.setText(getData.getStringExtra("DET"));
        imgDetail.setImageResource(getData.getIntExtra("GMB", 1));
        nama = getData.getStringExtra("NM");
        getSupportActionBar().setTitle(nama);
        //tombol back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String lat = getData.getStringExtra("LAT");
        String log = getData.getStringExtra("LOG");

        l = Float.parseFloat(lat);
        lg = Float.parseFloat(log);





    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(l, lg);
        mMap.addMarker(new MarkerOptions().position(sydney).title(nama));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f));
    }
}
