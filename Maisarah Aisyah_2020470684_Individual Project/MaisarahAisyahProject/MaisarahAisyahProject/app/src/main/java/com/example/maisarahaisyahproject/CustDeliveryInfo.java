package com.example.maisarahaisyahproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustDeliveryInfo extends AppCompatActivity {

    double price;
 //   String time1 = "12:00", time2 = "5:59";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_info);

        // get parameters inside intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phonum = intent.getStringExtra("phone no");
        String vehicle = intent.getStringExtra("vehicle");
        String kilometer = intent.getStringExtra("kilometer");
        double km = Double.parseDouble(kilometer);
        String time = intent.getStringExtra("time");
        String am_or_pm = intent.getStringExtra("AM or PM");
        String nodes = intent.getStringExtra("no of destination");
        int nodestination = Integer.parseInt(nodes);

        DateFormat dateFormat = new SimpleDateFormat("hh:mm");

        try {
            Date thetime = dateFormat.parse(time);
            Date t1 = dateFormat.parse("12:00");
            Date t2 = dateFormat.parse("6:00");

            //price calculation
            if (vehicle.equals("Motorcycle")) {
                if (km >= 0 && km < 5) {
                    price = 5.00 * km;
                } else if (km >= 5 && km < 10) {
                    price = 1.00 * km;
                } else {
                    price = 0.80 * km;
                }

                //additional price
                if (am_or_pm.equals("AM") && thetime.after(t1) && thetime.before(t2)) {
                    price = price + (price * 0.25);
                }
                if (nodestination > 1) {
                    price = price + (1.00 * (nodestination-1)); //number of destination - 1 because extra stop not including the first stop
                }
                ImageView motorImage = findViewById(R.id.imageView2);
                motorImage.setImageResource(R.drawable.deliverybike);
            }

                else if (vehicle.equals("Car")) {
                    if (km >= 0 && km < 5)
                        price = 8.00 * km;
                     else if (km >= 5 && km < 15)
                        price = 1.00 * km;
                     else
                        price = 1.50 * km;

                    //additional price
                    if (am_or_pm.equals("AM") && thetime.after(t1) && thetime.before(t2)) {
                        price = price + (price * 0.25);
                    }
                    if(nodestination > 1){
                        price = price +(2.00 * (nodestination-1)); //number of destination - 1 because extra stop not including the first stop
                    }
                ImageView motorImage = findViewById(R.id.imageView2);
                motorImage.setImageResource(R.drawable.supercar);
                }

                else {
                    if (km >= 0 && km < 10) {
                        price = 22.00 * km;
                    } else if (km >= 10 && km < 100) {
                        price = 2.20 * km;
                    } else {
                        price = 1.65 * km;
                    }
                    //additional price
                    if (am_or_pm.equals("AM") && thetime.after(t1) && thetime.before(t2)) {
                        price = price + (price*0.25);
                    }
                    if(nodestination > 1){
                        price = price +(5.00 * (nodestination-1)); //number of destination - 1 because extra stop not including the first stop
                    }
                ImageView motorImage = findViewById(R.id.imageView2);
                motorImage.setImageResource(R.drawable.pickuptruck);
                }

            //    String.format("%.2f", price);

                // display in apps
                TextView custName = findViewById(R.id.textView1);
                custName.setText("Customer Name: " + name);
                TextView custPhone = findViewById(R.id.textView2);
                custPhone.setText("Phone No: " + phonum);
                TextView devVehicle = findViewById(R.id.textView3);
                devVehicle.setText("Delivery Vehicle: " + vehicle);
                TextView devKilometer = findViewById(R.id.textView4);
                devKilometer.setText("Delivery Kilometer: " + kilometer);
                TextView devTime = findViewById(R.id.textView5);
                devTime.setText("Delivery Time: " + time + " " + am_or_pm) ;
                TextView devDest = findViewById(R.id.textView6);
                devDest.setText("Number of Destination: " + nodestination);
                TextView totalPrice = findViewById(R.id.textView7);
                totalPrice.setText("RM "+ String.format("%.2f", price));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
