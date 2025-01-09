package com.example.maisarahaisyahproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class CustDeliveryForm extends AppCompatActivity {

    private Button submitButton;
    private EditText txtName;
    private EditText txtPhone;
    private EditText txtKilometer;
    private EditText txtDevTime;
    private Spinner MorEv;
    private EditText txtNoDestination;
    private Spinner spinVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_form);
        submitButton = findViewById(R.id.Submitbutton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubmitSuccessActitivity();
            }
        });
    }

    private void openSubmitSuccessActitivity() {
                // get customer name
                txtName = findViewById(R.id.editTextName);
                String name = txtName.getText().toString();
                // get customer phone no
                txtPhone = findViewById(R.id.editTextPhone);
                String phone = txtPhone.getText().toString();


                // get delivery vehicle
                spinVehicle = findViewById(R.id.spinnerVehicle);
                String vehicle = spinVehicle.getSelectedItem().toString();
                //get kilometers
                txtKilometer = findViewById(R.id.editTextKilometer);
                String kilometer = txtKilometer.getText().toString();

                //get delivery time
                txtDevTime = findViewById(R.id.editTextTime);
                String time = txtDevTime.getText().toString();
                MorEv = findViewById(R.id.spinnerAMPM);
                String AmorPm = MorEv.getSelectedItem().toString();

                //get number of destinations
                txtNoDestination = findViewById(R.id.editTextNoDestination);
                String nodestination = txtNoDestination.getText().toString();


                // create a new intent for the new activity
                Intent intentCustDeliveryInfo= new Intent(this,CustDeliveryInfo.class);
                // set parameters to be sent
                intentCustDeliveryInfo.putExtra("name", name);
                intentCustDeliveryInfo.putExtra("phone no", phone);
                intentCustDeliveryInfo.putExtra("vehicle", vehicle);
                intentCustDeliveryInfo.putExtra("kilometer", kilometer);
                intentCustDeliveryInfo.putExtra("time", time);
                intentCustDeliveryInfo.putExtra("AM or PM", AmorPm);
                intentCustDeliveryInfo.putExtra("no of destination", nodestination);
                // start the new activity
                startActivity(intentCustDeliveryInfo);
            }
        }
