package com.geetesh.expensemanager;


import android.app.Activity;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class EditActivity extends Activity {

    RadioButton rb;
    Button save1;
    EditText ed;
    Spinner sp;
    EditText dt;
    Spinner cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Spinner spinner = (Spinner) findViewById(R.id.categories_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        rb = (RadioButton) findViewById(R.id.ch1);
        ed = (EditText) findViewById(R.id.price_message);
        cat = (Spinner) findViewById(R.id.categories_spinner);
        dt = (EditText) findViewById(R.id.date_message1);
        save1 = (Button) findViewById(R.id.sv);
        save1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                String price1;
                String type, ct1, date1;

                if (rb.isChecked()){
                    type = "Income";
                } else {
                    type = "Expense";
                }

                price1 = ed.getText() + "";
                date1 = dt.getText() + "";
                ct1 = cat.getSelectedItem() + "";
                SQLiteDatabase sq = null;
                boolean diditwork = true;
                try {
                    sq = openOrCreateDatabase("myDatabase", 0, null);
                    sq.execSQL("create table transaction1 (type varchar2(20) not null , price number(20) not null, catogory varchar(20)not null, tdate varchar(20) not null);");
                } catch (Exception e) {
                    Log.i("Exception: ",e.getMessage());
                }

                sq.execSQL("insert into transaction1 values('" + type + "'," + price1 + " ,'" + ct1 + "' ,'" + date1 + "');");
                sq.close();
                Dialog d = new Dialog(EditActivity.this);
                d.setTitle("Successfull!");
                TextView tv = new TextView(EditActivity.this);
                tv.setText("Transaction added");
                d.setContentView(tv);
                d.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }
}
