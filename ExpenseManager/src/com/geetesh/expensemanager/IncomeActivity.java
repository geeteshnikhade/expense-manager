package com.geetesh.expensemanager;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class IncomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Intent in = getIntent();
        int x = in.getIntExtra("choice", 1);
        String choiceV = in.getStringExtra("choiceG");
        String s = "";
        if (x == 2)
            s = "Income";
        else if (x == 3)
            s = "Expense";
        TextView disp1 = (TextView) findViewById(R.id.history_tv1);
        TextView disp2 = (TextView) findViewById(R.id.history_tv2);
        TextView disp3 = (TextView) findViewById(R.id.history_tv3);
        TextView disp4 = (TextView) findViewById(R.id.history_tv4);

        SQLiteDatabase sq = null;
        boolean diditwork = true;
        String columns[] = new String[]{"type", "price", "catogory", "tdate"};
        try {
            sq = openOrCreateDatabase("myDatabase", 0, null);
        } catch (Exception e) {
            Log.i("hi", "i m here");
        }
        String a1 = "Type:" + "\n";
        String b1 = " Amount:" + "\n";
        String c1 = " Category:" + "\n";
        String d1 = "Date:" + "\n";
        String e1 = "";
        double total = 0;

        Cursor c;
        if (x == 1)
            c = sq.query("transaction1", columns, null, null, null, null, null);
        else
            c = sq.query("transaction1", columns, "type='" + s + "' and catogory='" + choiceV + "'", null, null, null, null);


        while (c.moveToNext()) {
            a1 += c.getString(c.getColumnIndex("type")) + "\n";
            e1 = c.getString(c.getColumnIndex("price"));
            b1 += "  " + e1 + "\n";
            c1 += "  " + c.getString(c.getColumnIndex("catogory")) + "\n";
            d1 += " " + c.getString(c.getColumnIndex("tdate")) + "\n";
            //p+=a1+"	"+b1+"	"+c1+"	"+d1+"\n";
            total += Integer.parseInt(e1);

        }
        a1 += "\n" + "Total:";
        b1 += "\n" + total + "";
        disp1.setText(a1);
        disp2.setText(b1);
        disp3.setText(c1);
        disp4.setText(d1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.income, menu);
        return true;
    }

}
