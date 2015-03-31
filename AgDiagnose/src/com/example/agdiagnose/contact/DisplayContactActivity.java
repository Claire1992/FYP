package com.example.agdiagnose.contact;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.agdiagnose.R;
import com.example.agdiagnose.database.DatabaseHelper;
import com.example.agdiagnose.database.MyMarkerObj;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class DisplayContactActivity extends FragmentActivity implements LocationListener {
	
	GoogleMap googlemap;
	Context context = this;
	DatabaseHelper info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_contact);
		startMap();
		 info = new DatabaseHelper(this);
		try{
			 info.open();
			 
		 } catch(Exception e){
			 Log.i("OPEN", "OPEN");
		 }
	/*
		 info.addMarker(new MyMarkerObj("Ark Veterinary Clinic", "091 584185", "53.269714 -9.065228"));
		 info.addMarker(new MyMarkerObj("Glenina Veterinary Clinic", "091 752014", "53.279293 -9.020491"));
		 info.addMarker(new MyMarkerObj("Oran Veterinary Clinic", "091 788270", "53.277718 -8.923924"));
		 info.addMarker(new MyMarkerObj("Briarhill Veterinary Clinic", "091 380000", "53.293249 -8.990726"));
		 info.addMarker(new MyMarkerObj("Skeldale Vetinary Clinic ", "094 9541980", "53.625850 -9.225820"));
		 info.addMarker(new MyMarkerObj("Pat McGrath Veterinary Surgeon", "087 8192215", "53.469697 -9.106155"));

	*/    
		 
		 List<MyMarkerObj> m = info.getMyMarkers();
		 for(int i = 0; i< m.size(); i++){
			 String[] slatlng = m.get(i).getPosition().split(" ");
			 LatLng lat = new LatLng(Double.valueOf(slatlng[0]), Double.valueOf(slatlng[1]));
			 
			 googlemap.addMarker(new MarkerOptions()
					 	.title(m.get(i).getTitle())
					 	.snippet(m.get(i).getSnippet())
					 	.position(lat)
					 			);
	 
		 
		 }
		 
		 info.close(); 
       
	}     
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_contact, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	private void startMap(){
		
		SupportMapFragment mf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        googlemap = mf.getMap(); 
        googlemap.setMyLocationEnabled(true);
        
        googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        
	}
	/**
		@Override
		protected void onPause() {
			
			DatabaseHelper info = new DatabaseHelper(this);
			info.close();
			super.onPause();
		}
		
		@Override
		protected void onResume() {
				
				DatabaseHelper info = new DatabaseHelper(this);
			
				try {
			info.open();
			} catch (Exception e) {
			Log.i("Resume", "Unable to resume");
			}
			super.onResume();
		}
		**/
}
