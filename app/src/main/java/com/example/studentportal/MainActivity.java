package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    private GestureDetector mGestureDetector;
    public List<Portals> mPortals;
    TextView textView;
    RecyclerView recyclerView;
    PortalAdapter Adapter;

    //public static final String name = "Name";
    //public static final String link = "Link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPortals = new ArrayList<>();

        /*
            RecyclerView
         */
        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager LayoutManager = new LinearLayoutManager(this);
        Adapter = new PortalAdapter(this, mPortals);
        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(LayoutManager);

        /*
            TouchListener for RecyclerView item
         */
        recyclerView.addOnItemTouchListener(this);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        /*
            Floatig Action Button
         */

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ga naar de AddPortal activity on click on FAB
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
        if (Adapter == null) {
            Adapter = new PortalAdapter(this, mPortals);
            recyclerView.setAdapter(Adapter);
        } else {
            Adapter.notifyDataSetChanged();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1234) {
                String newName = data.getStringExtra(AddPortal.name );
                String newLink = data.getStringExtra(AddPortal.link);

                mPortals.add(new Portals(newName,newLink));
                updateUi();
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        int mAdapterPosition = recyclerView.getChildAdapterPosition(child);

        if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
            Intent intent = new Intent(this, Webview.class);
            intent.putExtra("LINK", mPortals.get(mAdapterPosition).getLink());
            startActivity(intent);
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
