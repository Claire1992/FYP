package com.example.agdiagnose.diseases;

import com.example.agdiagnose.Globals;
import com.example.agdiagnose.MainActivity;
import com.example.agdiagnose.R;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SheepCategory extends ActionBarActivity implements OnClickListener {
	
	Button respView;
	Button skinView;
	Button virView;
	Button reproView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cow_sheep_category);
		
		respView = (Button) findViewById(R.id.resp_btn);
		respView.setOnClickListener((android.view.View.OnClickListener) this);
		skinView = (Button) findViewById(R.id.skin_btn);
		skinView.setOnClickListener((android.view.View.OnClickListener) this);
		virView = (Button) findViewById(R.id.vir_btn);
		virView.setOnClickListener((android.view.View.OnClickListener) this);
		reproView = (Button) findViewById(R.id.repro_btn);
		reproView.setOnClickListener((android.view.View.OnClickListener) this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sheep_diseases, menu);
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
	
	
	/**Called when the user clicks the menu button**/
    public void menu(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
   
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()){
		
		case R.id.resp_btn:
		
			    	Intent sheepRespIntent = new Intent(this, DiseasesList.class);
			    	startActivity(sheepRespIntent);
			    	Globals.sourceOption = "SHEEPRESPIRATORY";
			
			break;
	 
		case R.id.skin_btn:
			
	    			Intent sheepSkinIntent = new Intent(this, DiseasesList.class);
	    			startActivity(sheepSkinIntent);
	    			Globals.sourceOption = "SHEEPSKIN";
	    	break;
	    	
		case R.id.vir_btn:
			
	    			Intent sheepVirIntent = new Intent(this, DiseasesList.class);
	    			startActivity(sheepVirIntent);
	    			Globals.sourceOption = "SHEEPVIRUSES";
	
	    	break;
	    	
		case R.id.repro_btn:
			
	    			Intent sheepReproIntent = new Intent(this, DiseasesList.class);
	    			startActivity(sheepReproIntent);
	    			Globals.sourceOption = "SHEEPREPRODUCTIVE";
	    			break;
		}
	}
}
