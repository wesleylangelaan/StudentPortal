package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortal extends AppCompatActivity {

    Button buttonSubmit;
    EditText editTextName;
    EditText editTextLink;

    public static final String name = "Name";
    public static final String link = "Link";

    String portalName, portalLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        editTextName = findViewById(R.id.editTextName);
        editTextLink = findViewById(R.id.editTextLink);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                portalName = editTextName.getText().toString();
                portalLink = editTextLink.getText().toString();

                Intent data = new Intent();
                data.putExtra(name, portalName);
                data.putExtra(link, portalLink);

                setResult(Activity.RESULT_OK, data);
                finish();

            }
        });


    }
}
