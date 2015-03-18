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

public class Birth extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_birth);
		
		
		if(Globals.sourceOption.equals("COWREPRODUCTION"))
        {
			TextView intro_birthTv = (TextView) findViewById(R.id.intro_birth_tv);
	        TextView birthTv = (TextView) findViewById(R.id.birth_tv);
	        DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        String introdata = info.getCowIntroBirth();
	        String data = info.getCowBirth();
	        intro_birthTv.setText(introdata);
	        birthTv.setText(data);
	        info.close();
	        
        }
	
		
		if(Globals.sourceOption.equals("SHEEPREPRODUCTION"))
        {
			TextView intro_birthTv = (TextView) findViewById(R.id.intro_birth_tv);
	        TextView birthTv = (TextView) findViewById(R.id.birth_tv);
	        DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        String introdata = info.getSheepIntroBirth();
	        String data = info.getSheepBirth();
	        intro_birthTv.setText(introdata);
	        birthTv.setText(data);
	        info.close();
	        
        }
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.birth, menu);
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
