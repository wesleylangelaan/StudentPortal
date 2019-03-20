package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public List<Portals> mPortals;
    TextView textView;

    //public static final String name = "Name";
    //public static final String link = "Link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPortals = new ArrayList<>();

        textView = findViewById(R.id.textView);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startAddPortal();
            }
        });
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

    private void startAddPortal() {
        Intent intent = new Intent(this, AddPortal.class);
        startActivityForResult(intent, 1234);
    }

    private void updateUi() {
        int size = mPortals.size();

        // to clear the textview
        textView.setText("");

        for (int i = 0; i < size; i++) {
            textView.append(" \n");
            textView.append(mPortals.get(i).getName());
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1234) {
                String newName = data.getStringExtra(AddPortal.name );
                String newLink = data.getStringExtra(AddPortal.link);

                mPortals.add(new Portals(newName,newLink));
                updateUi();
                //Toast.makeText(this, newName, Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, newLink, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
