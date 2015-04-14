package com.example.agdiagnose.reproduction;

import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

import com.example.agdiagnose.R;

public class ReproductiveInfo extends TabActivity implements OnTabChangeListener {
	
	 
    TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductive_info);
        
		// Get TabHost Reference
        tabHost = getTabHost();
         
        // Set TabChangeListener, this is called when tab changed
        tabHost.setOnTabChangedListener(this);
     
        TabHost.TabSpec Tspec;
        Intent intent;
        
        //TAB 1
        // Create  Intents to launch an Activity for the tab
        intent = new Intent().setClass(this, Breeding.class);
        Tspec = tabHost.newTabSpec("Breeding").setIndicator("").setContent(intent);
         
        //Add intent to tab
        tabHost.addTab(Tspec);
   
        //TAB2
        intent = new Intent().setClass(this, Gestation.class);
        Tspec = tabHost.newTabSpec("Gestation").setIndicator("") .setContent(intent); 
        
        //Add intent to tab
        tabHost.addTab(Tspec);
   
        //TAB3
        intent = new Intent().setClass(this, Birth.class);
        Tspec = tabHost.newTabSpec("Birth").setIndicator("")  .setContent(intent);
       
        //Add intent to tab
        tabHost.addTab(Tspec);
        
        // Set Tab1 as Default TAB each time it is opened  
        tabHost.getTabWidget().setCurrentTab(0);
       tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.breeding_over);
         
   
        // Set drawable images to tab
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.gestation);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.birth);
           
        
   
     }

  @Override
  public void onTabChanged(String tabId) {
       
      /************ Called when tab changed *************/
       
       
      for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
      {
          if(i==0)
              tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.breeding);
          else if(i==1)
              tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.gestation);
          else if(i==2)
              tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.birth);
      }
       
       
      Log.i("tabs", "Current Tab: "+tabHost.getCurrentTab());
       
  if(tabHost.getCurrentTab()==0)
      tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.breeding_over);
  else if(tabHost.getCurrentTab()==1)
      tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.gestation_over);
  else if(tabHost.getCurrentTab()==2)
      tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.birth_over);
       
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

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
