package com.example.weekend1_hw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class person {

    public class MainActivity extends AppCompatActivity {
        TextView nameFirstDisplay;
        EditText editNameFirstDisplay;
        TextView nameLastDisplay;
        EditText editNameLastDisplay;
        TextView addressDisplay;
        EditText editAddressDisplay;
        TextView cityDisplay;
        EditText editCityDisplay;
        TextView stateDisplay;
        EditText editStateDisplay;
        TextView zipDisplay;
        EditText editZipDisplay;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            nameFirstDisplay = findViewById(R.id.nameFirstDisplay);
            editNameFirstDisplay = findViewById(R.id.editNameFirstDisplay);
            nameLastDisplay = findViewById(R.id.nameLastDisplay);
            editNameLastDisplay = findViewById(R.id.editNameLastDisplay);
            addressDisplay = findViewById(R.id.addressDisplay);
            editAddressDisplay = findViewById(R.id.editAddressDisplay);
            cityDisplay = findViewById(R.id.cityDisplay);
            editCityDisplay = findViewById(R.id.editCityDisplay);
            stateDisplay = findViewById(R.id.stateDisplay);
            editStateDisplay = findViewById(R.id.editStateDisplay);
            zipDisplay = findViewById(R.id.zipDisplay);
            editZipDisplay = findViewById(R.id.editZipDisplay);
        }

        public void onClick(View view) {
            String firstName = editNameFirstDisplay.getText().toString();
            String lastName = editNameLastDisplay.getText().toString();
            String address = editAddressDisplay.getText().toString();
            String city = editCityDisplay.getText().toString();
            String state = editStateDisplay.getText().toString();
            String zip = editZipDisplay.getText().toString();
            nameFirstDisplay.setText(firstName);
            nameLastDisplay.setText(lastName);
            addressDisplay.setText(address);
            cityDisplay.setText(city);
            stateDisplay.setText(state);
            zipDisplay.setText(zip);


        }
    }
}