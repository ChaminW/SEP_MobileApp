package com.bitlabs.sep_mobileapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bitlabs.sep_mobileapp.R;

public class MainActivity extends AppCompatActivity {

    private Button addFillBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFillBtn = (Button) findViewById(R.id.addFillBtn);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void OnAddFillClick(View view) {
        Toast.makeText(this, "Enter a Fill up details", Toast.LENGTH_LONG).show();
        Intent getAddFillIntent = new Intent(this, AddFillUp.class);
        startActivity(getAddFillIntent);


    }

    public void OnOtherExpenseClick(View view) {

        Toast.makeText(this, "Enter a Expense details", Toast.LENGTH_LONG).show();
        Intent getAddExpenseIntent = new Intent(this, AddOtherExpense.class);
        startActivity(getAddExpenseIntent);

    }
}