package com.geetesh.expensemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button send1;
    Button send2;
    Button send3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send1 = (Button) findViewById(R.id.button1);
        send1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent1);
                // TODO Auto-generated method stub

            }
        });

        send2 = (Button) findViewById(R.id.button2);
        send2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent intent2 = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent2);
            }
        });

        send3 = (Button) findViewById(R.id.button3);
        send3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent3 = new Intent(MainActivity.this, PendingActivity.class);
                startActivity(intent3);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
