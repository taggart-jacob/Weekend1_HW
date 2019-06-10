package com.example.weekend1_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;

public class choice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the overall view to the activity_choice UI
        setContentView(R.layout.activity_choice);
        //calls the configure function for every button on the screen
        configureBackBtn();
        configureToCalculator();
        configureToCamera();
        configureToPerson();
        configureToPersonList();
        configureToMedia();
        configureToWeb();
    }
    //configures the back button
    private void configureBackBtn() {
        //sets the back button to the back button view
        Button backBtn = findViewById(R.id.backBtn);
        //sets the OnClickListener
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            //whichever button is clicked is passed
            public void onClick(View v) {
                //this closes the app and goes back to the previous instance state
                finish();
            }
        });

    }
    // same for toCalculator
    private void configureToCalculator() {
        //same for calculator
        Button toCalculator = findViewById(R.id.toCalculator);
        //same for calculator button
        toCalculator.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(choice.this, calculator.class));
            }
        });
    }
    //and so on...
    private void configureToCamera() {
        Button toCamera = findViewById(R.id.toCamera);
        toCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(choice.this, camera.class));
            }
        });
    }

    private void configureToPerson() {
        Button toPerson = findViewById(R.id.toPerson);
        toPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choice.this, person.class));
            }
        });
    }

    private void configureToPersonList() {
        Button toPersonList = findViewById(R.id.toPersonList);
        toPersonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choice.this, person_list.class));
            }
        });
    }

    private void configureToMedia() {
        Button toMedia = findViewById(R.id.toMedia);
        toMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choice.this, media.class));
            }
        });
    }

    private void configureToWeb() {
        Button toWeb = findViewById(R.id.toWeb);
        toWeb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(choice.this, web.class));
            }
        });
    }
}