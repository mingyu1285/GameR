package com.mingyu1285.gamer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CategoryTabViewPager2 extends Fragment {

    GoogleMap Gmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_tab_pager2, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();
        final SupportMapFragment mapFragment = (SupportMapFragment)fragmentManager.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Gmap = googleMap;


                LatLng hmps = new LatLng(37.562593, 127.032554);




                MarkerOptions mo = new MarkerOptions();
                mo.position(hmps);
                mo.title("홈플러스 왕십리점");
                mo.snippet("http://www.homeplus.co.kr/");
                mo.icon(BitmapDescriptorFactory.fromResource(R.drawable.button_blue));
                mo.anchor(0.5f, 1.0f);

                Gmap.animateCamera(CameraUpdateFactory.newLatLngZoom(hmps,16));

                Marker marker = Gmap.addMarker(mo);
                marker.showInfoWindow();

                Gmap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        String title = marker.getTitle();

                        if (title.equals("홈플러스 왕십리점")){
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            Uri uri = Uri.parse("http://www.homeplus.co.kr");
                            intent.setData(uri);

                            startActivity(intent);
                        }
                    }
                });
            }
        });

//        MyInfoWinAdapter adapter = new MyInfoWinAdapter(getActivity());
//        Gmap.setInfoWindowAdapter(adapter);
//
//        //내 위치 보여주기 [위치 정보 제공 퍼미션 작업 필요 - 동적 퍼미션]
//        Gmap.setMyLocationEnabled(true);
        return view;
    }
}
