package com.example.agdiagnose.diseases;

import com.example.agdiagnose.R;
import com.example.agdiagnose.R.id;
import com.example.agdiagnose.R.layout;
import com.example.agdiagnose.R.menu;
import com.example.agdiagnose.database.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Diseases extends ActionBarActivity {

	long disease_id;
	DatabaseHelper databaseHelper;
	TextView diseaseNametv;
	TextView diseaseDescriptiontv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diseases);
		
		//databaseHelper = new DatabaseHelper(this);
		//databaseHelper.open();
	
		DatabaseHelper info = new DatabaseHelper(this);
        info.open();
        
        
		
		diseaseNametv= (TextView)findViewById(R.id.disease_tv);
		diseaseDescriptiontv = (TextView)findViewById(R.id.description_tv);
		
		
		Intent i = getIntent();
		String diseaseID = i.getStringExtra("id");
		String diseaseName = i.getStringExtra("name");
	    disease_id = Long.parseLong(diseaseID);
	//	databaseHelper.getDescriptionDisease(disease_id);
	    String data = info.getDescriptionDisease(disease_id);
		
		diseaseNametv.setText(diseaseName);
		diseaseDescriptiontv.setText(data);
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diseases, menu);
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
}
