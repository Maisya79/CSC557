package com.example.maisarahaisyahproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button stButton = (Button) findViewById(R.id.menustartbutton);
        stButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStartForm = new Intent(MainActivity.this, CustDeliveryForm.class);
                startActivity(intentStartForm);
            }
        });
    }

  //  private void openCustDeliveryForm() {
  //      Intent intentStartForm = new Intent(this, CustDeliveryForm.class);
  //      startActivity(intentStartForm);
  //  }
}