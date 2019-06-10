package com.example.weekend1_hw;
//imports all the necessary tools
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    //overrides the onCreate and passes the savedInstanceState from previous use
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the overall view to the activity_main layout
        setContentView(R.layout.activity_main);
        //activitySwitch function is called which handles the only button on this screen
        activitySwitch();
    }
    //activitySwitch function
    private void activitySwitch() {
        //creates a button object and assigns it to its respective view
        Button switchActivity = findViewById(R.id.activitySwitch);
        //sets onClickListener and passes a new listener from the View utility
        switchActivity.setOnClickListener(new View.OnClickListener() {
            //overrides onClick and passes the view that is specifically clicked
            @Override
            public void onClick(View v){
                //this says that we will be going from this UI to the choice class's UI
                startActivity(new Intent(MainActivity.this, choice.class));
            }
        });
    }
}