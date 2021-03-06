package com.example.agdiagnose.diseases;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.agdiagnose.Globals;
import com.example.agdiagnose.MainActivity;
import com.example.agdiagnose.R;
import com.example.agdiagnose.database.DatabaseHelper;

public class DiseasesList extends ActionBarActivity {

	ListView listView;
	DatabaseHelper databaseHelper;
	TextView diseaseID_tv;
	TextView diseasesName_tv;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diseases_list);
		//databaseHelper = new DatabaseHelper(this);
		//databaseHelper.open();
		listView = (ListView)findViewById(R.id.diseasesList);
		
		
		if(Globals.sourceOption.equals("COWRESPIRATORY"))
        {
			DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCowRespiratoryDiseases();
			//Cursor cursor = databaseHelper.getCowRespiratoryDiseases();
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
			
        	
        }
		
	    if(Globals.sourceOption.equals("COWSKIN"))
	    {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCowSkinDiseases();
			//Cursor cursor = databaseHelper.getCowRespiratoryDiseases();
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
	    }
	    
	    if(Globals.sourceOption.equals("COWVIRUSES"))
	    {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCowVirDiseases();
			//Cursor cursor = databaseHelper.getCowRespiratoryDiseases();
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
	    }
	    
	    if(Globals.sourceOption.equals("COWREPRODUCTIVE"))
	    {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCowReproductiveDiseases();
			//Cursor cursor = databaseHelper.getCowRespiratoryDiseases();
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
	    }
	    
	    if(Globals.sourceOption.equals("SHEEPRESPIRATORY"))
        {
        	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getSheepRespiratoryDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("SHEEPSKIN"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getSheepSkinDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("SHEEPVIRUSES"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getSheepVirDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("SHEEPREPRODUCTIVE"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getSheepReproductiveDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        }
	    
	    
	    if(Globals.sourceOption.equals("CALFRESPIRATORY"))
        {
        	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCalfRespiratoryDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("CALFSKIN"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCalfSkinDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("CALFVIRUSES"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCalfVirDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("CALFREPRODUCTIVE"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getCalfReproductiveDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        }
	    
	    
	    if(Globals.sourceOption.equals("LAMBRESPIRATORY"))
        {
        	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getLambRespiratoryDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("LAMBSKIN"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getLambSkinDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("LAMBVIRUSES"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getLambVirDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        	
        }
	    
	    if(Globals.sourceOption.equals("LAMBREPRODUCTIVE"))
        {
	    	DatabaseHelper info = new DatabaseHelper(this);
	        info.open();
	        Cursor data = info.getLambReproductiveDiseases();
			
			
			String[] from = new String[] {databaseHelper.KEY_DISEASES_ID, databaseHelper.KEY_DISEASES_NAME};
        	int[] to = new int[]{R.id.disease_id, R.id.disease_name};
        	
        	@SuppressWarnings("deprecation")
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(
        			DiseasesList.this, R.layout.activity_disease_item, (Cursor) data, from, to);
        	adapter.notifyDataSetChanged();
        	listView.setAdapter(adapter);
        }
    
		
		
		
		//OnClickListener for list items
		
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				diseaseID_tv = (TextView)view.findViewById(R.id.disease_id);
				diseasesName_tv = (TextView)view.findViewById(R.id.disease_name);
				
				
				String id_val = diseaseID_tv.getText().toString();
				String name_val = diseasesName_tv.getText().toString();
				
				
				Intent disease_intent = new Intent(getApplicationContext(), Diseases.class);
				disease_intent.putExtra("id", id_val);
				disease_intent.putExtra("name", name_val);
				startActivity(disease_intent);
				
						
						
			}
			
		});
		
	}
	

	/*
	public void onClick(View view) {
			Intent disease_intent = new Intent(this, Diseases.class);
			startActivity(disease_intent);
	}
	*/
	
	/**Called when the user clicks the menu button**/
    public void menu(View view){
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.diseases_list, menu);
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
