package com.example.agdiagnose.reproduction;

import com.example.agdiagnose.Globals;
import com.example.agdiagnose.R;
import com.example.agdiagnose.R.id;
import com.example.agdiagnose.R.layout;
import com.example.agdiagnose.R.menu;
import com.example.agdiagnose.diseases.CalfCategory;
import com.example.agdiagnose.diseases.CowCategory;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DisplayReproductionActivity extends ActionBarActivity implements OnClickListener {

	
	Button cowView;
	Button sheepView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_reproduction);
		
		cowView = (Button) findViewById(R.id.cowReproductionView);
		cowView.setOnClickListener((android.view.View.OnClickListener) this);
		sheepView = (Button) findViewById(R.id.sheepReproductionView);
		sheepView.setOnClickListener((android.view.View.OnClickListener) this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_reproduction, menu);
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
	
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()){
		
		case R.id.cowReproductionView:
		
			    	Intent cowReproIntent = new Intent(this, ReproductiveInfo.class);
			    	startActivity(cowReproIntent);
			    	Globals.sourceOption = "COWREPRODUCTION";
			
			break;
	 
		case R.id.sheepReproductionView:
			
	    			Intent sheepReproIntent = new Intent(this, ReproductiveInfo.class);
	    			startActivity(sheepReproIntent);
	    			Globals.sourceOption = "SHEEPREPRODUCTION";
	
	    	break;
	    	
		}
		
	}
	
}
