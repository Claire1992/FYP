package com.example.agdiagnose.diseases;

import com.example.agdiagnose.MainActivity;
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
import android.view.View;
import android.widget.TextView;

public class Diseases extends ActionBarActivity {

	long disease_id;
	DatabaseHelper databaseHelper;
	TextView diseaseNametv;
	TextView diseaseDescriptiontv;
	TextView Symptoms_tv;
	TextView Treatments_tv;
	
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
		Symptoms_tv = (TextView)findViewById(R.id.Symptoms_tv);
		Treatments_tv =(TextView)findViewById(R.id.Treatments_tv); 
		
		
		Intent i = getIntent();
		String diseaseID = i.getStringExtra("id");
		String diseaseName = i.getStringExtra("name");
	    disease_id = Long.parseLong(diseaseID);
	//	databaseHelper.getDescriptionDisease(disease_id);
	    String description = info.getDescriptionDisease(disease_id);
		String symptoms = info.getSymptomsDisease(disease_id);
		String treatment = info.getTreatmentDisease(disease_id);
		diseaseNametv.setText(diseaseName);
		diseaseDescriptiontv.setText(description);
		Symptoms_tv.setText(symptoms);
		Treatments_tv.setText(treatment);
		
		
	}

	
	/**Called when the user clicks the menu button**/
    public void menu(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
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
