package com.example.agdiagnose;

import com.example.agdiagnose.about.DisplayDiagnoseActivity;
import com.example.agdiagnose.contact.DisplayContactActivity;
import com.example.agdiagnose.database.DatabaseHelper;
import com.example.agdiagnose.diseases.AnimalMenu;
import com.example.agdiagnose.reproduction.DisplayReproductionActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
	//public final static String EXTRA_MESSAGE = "com.example.agdiagnose.DISEASES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
/* 
        DatabaseHelper info = new DatabaseHelper(this);
        info.open();
        
    info.insertAnimals();
     info.insertDiseases();
     info.insertCategory();
    info.insertAnimalsCategoryDiseases();
    info.insertReproduction();
    
  
        
        info.close();
*/      
     
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
   
    /**Called when the user clicks the diseases button**/
    public void searchDiseases(View view){
    	Intent intent = new Intent(this, AnimalMenu.class);
    	//EditText editText = (EditText) findViewById(R.id.search_diseases);
    	//String message = editText.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    
    /**Called when the user clicks the diagnose button**/
    public void diagnose(View view){
    	Intent intent = new Intent(this, DisplayDiagnoseActivity.class);
    	startActivity(intent);
    }
   
    
    /**Called when the user clicks the reproduction button**/
    public void reproduction(View view){
    	Intent intent = new Intent(this, DisplayReproductionActivity.class);
    	startActivity(intent);
    }
    
    /**Called when the user clicks the contact button**/

    public void contact(View view){
    	Intent intent = new Intent(this, DisplayContactActivity.class);
    	startActivity(intent);
    }
}
