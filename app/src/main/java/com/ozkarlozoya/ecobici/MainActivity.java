package com.ozkarlozoya.ecobici;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Camera;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    String json1="";
    GoogleMap map;
    List<Double> latitude=new ArrayList<Double>();
    List<Double> longitud=new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void Peticion() {

        String url="http://api.citybik.es/v2/networks/ecobici";
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if(response.isSuccessful()){
                    Gson g1=new Gson();

                    Ecobici ft=g1.fromJson(response.body().string(), Ecobici.class);
                    for(int x=0;x<ft.getNetwork().getStations().size();x++){
                        latitude.add(ft.getNetwork().getStations().get(x).getLatitude());
                        longitud.add(ft.getNetwork().getStations().get(x).getLongitude());

                    }




                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map= googleMap;
        float zoomLevel = 16.0f;

        Peticion();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int x=0; x<latitude.size();x++){
                    LatLng dinamarca1= new LatLng(latitude.get(x), longitud.get(x));
                    map.addMarker(new MarkerOptions().position(dinamarca1));
                    map.moveCamera(CameraUpdateFactory.newLatLng(dinamarca1));
                }
            }
        }, 3000);

        LatLng dinamarca= new LatLng(19.432184058261548, -99.1333610299066);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(dinamarca,zoomLevel));
    }
}