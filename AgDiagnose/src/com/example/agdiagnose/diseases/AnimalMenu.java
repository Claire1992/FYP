package com.example.agdiagnose.diseases;



import com.example.agdiagnose.MainActivity;
import com.example.agdiagnose.R;
import com.example.agdiagnose.R.id;
import com.example.agdiagnose.R.layout;
import com.example.agdiagnose.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.agdiagnose.database.*;

public class AnimalMenu extends Activity implements OnClickListener {
	Button cowView;
	Button calfView;
	Button sheepView;
	Button lambView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_display_animals);
		
		
		cowView = (Button) findViewById(R.id.cowDiseasesView);
		cowView.setOnClickListener((android.view.View.OnClickListener) this);
		calfView = (Button) findViewById(R.id.calfDiseasesView);
		calfView.setOnClickListener((android.view.View.OnClickListener) this);
		sheepView = (Button) findViewById(R.id.sheepDiseasesView);
		sheepView.setOnClickListener((android.view.View.OnClickListener) this);
		lambView = (Button) findViewById(R.id.lambDiseasesView);
		lambView.setOnClickListener((android.view.View.OnClickListener) this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_diseases, menu);
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
		
		case R.id.cowDiseasesView:
		
			    	Intent cowIntent = new Intent(this, CowCategory.class);
			    	startActivity(cowIntent);
			
			break;
	 
		case R.id.calfDiseasesView:
			
	    			Intent calfIntent = new Intent(this, CalfCategory.class);
	    			startActivity(calfIntent);
	
	    	break;
	    	
		case R.id.sheepDiseasesView:
			
	    			Intent sheepIntent = new Intent(this, SheepCategory.class);
	    			startActivity(sheepIntent);
	
	    	break;
	    	
		case R.id.lambDiseasesView:
			
	    			Intent LambIntent = new Intent(this, LambCategory.class);
	    			startActivity(LambIntent);
	
	    			break;
		}
	
}
}
