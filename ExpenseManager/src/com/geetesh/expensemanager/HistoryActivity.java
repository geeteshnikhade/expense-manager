package com.geetesh.expensemanager;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class HistoryActivity extends Activity {
	
	Spinner cat1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		
		Spinner spinner = (Spinner) findViewById(R.id.categories_spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.categories1, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		cat1= (Spinner) findViewById(R.id.categories_spinner1);
	
	  final RadioButton rbch1,rbch2,rbch3;
	  rbch1= (RadioButton) findViewById(R.id.ch1);
	  rbch2= (RadioButton) findViewById(R.id.ch2);
	  rbch3= (RadioButton) findViewById(R.id.ch3);
	   
	  
	 
	  Button go1;
		go1= (Button) findViewById(R.id.go);
		go1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0)
			{
				String ct2;
				 int choice=0;
				if(rbch1.isChecked())
				{
					choice=1;
				}
				else
					if(rbch2.isChecked())
					{
					choice=2;
					}
					else
					{
						choice=3;
					}
				ct2=cat1.getSelectedItem()+"";
				
				Intent in=new Intent(HistoryActivity.this,IncomeActivity.class);
				in.putExtra("choice", choice);
				in.putExtra("choiceG", ct2);
				startActivity(in);
				
				
					
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.history, menu);
		return true;
	}

}
