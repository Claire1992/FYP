package com.example.agdiagnose.diseases;

import com.example.agdiagnose.Globals;
import com.example.agdiagnose.MainActivity;
import com.example.agdiagnose.R;
import com.example.agdiagnose.R.id;
import com.example.agdiagnose.R.layout;
import com.example.agdiagnose.R.menu;
import com.example.agdiagnose.database.DatabaseHelper;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LambCategory extends ActionBarActivity implements OnClickListener{
	
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
		getMenuInflater().inflate(R.menu.lamb_diseases, menu);
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
		
			    	Intent cowRespIntent = new Intent(this, DiseasesList.class);
			    	startActivity(cowRespIntent);
			    	Globals.sourceOption = "LAMBRESPIRATORY";
			
			break;
	 
		case R.id.skin_btn:
			
	    			Intent cowSkinIntent = new Intent(this, DiseasesList.class);
	    			startActivity(cowSkinIntent);
	    			Globals.sourceOption = "LAMBSKIN";
	    	break;
	    	
		case R.id.vir_btn:
			
	    			Intent cowVirIntent = new Intent(this, DiseasesList.class);
	    			startActivity(cowVirIntent);
	    			Globals.sourceOption = "LAMBVIRUSES";
	
	    	break;
	    	
		case R.id.repro_btn:
			
	    			Intent cowReproIntent = new Intent(this, DiseasesList.class);
	    			startActivity(cowReproIntent);
	    			Globals.sourceOption = "LAMBREPRODUCTIVE";
	    			break;
		}
	}
}
