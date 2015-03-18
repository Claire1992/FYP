package com.example.agdiagnose.reproduction;

import com.example.agdiagnose.Globals;
import com.example.agdiagnose.R;
import com.example.agdiagnose.R.id;
import com.example.agdiagnose.R.layout;
import com.example.agdiagnose.R.menu;
import com.example.agdiagnose.database.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Breeding extends ActionBarActivity {
	
	TextView intro_breedingTv;
	TextView breedingTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_breeding);
		
		
		if(Globals.sourceOption.equals("COWREPRODUCTION"))
        {
			
			TextView intro_breedingTv = (TextView) findViewById(R.id.intro_breeding_tv);
	        TextView breedingTv = (TextView) findViewById(R.id.breeding_tv);
	        DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        String introdata = info.getCowIntroBreeding();
	        String data = info.getCowBreeding();
	        intro_breedingTv.setText(introdata);
	        breedingTv.setText(data);
	        info.close();
	        
        }

        
        
        if(Globals.sourceOption.equals("SHEEPREPRODUCTION"))
        {
			
			TextView intro_breedingTv = (TextView) findViewById(R.id.intro_breeding_tv);
	        TextView breedingTv = (TextView) findViewById(R.id.breeding_tv);
	        DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        String sheepintrodata = info.getSheepIntroBreeding();
	        String sheepdata = info.getSheepBreeding();
	        intro_breedingTv.setText(sheepintrodata);
	        breedingTv.setText(sheepdata);
	        info.close();
	        
        }
	
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.breeding, menu);
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
