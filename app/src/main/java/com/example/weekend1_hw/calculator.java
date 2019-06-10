package com.example.weekend1_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class calculator extends AppCompatActivity {

    SeekBar sbAmount;
    SeekBar sbInterest;
    SeekBar sbMonths;

    TextView tvAmount;
    TextView tvInterest;
    TextView tvMonths;
    TextView tvTotal;
    TextView tvMonthly;
    TextView tvInterestAmount;

    Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAmount = findViewById(R.id.tvAmount);
        tvInterest = findViewById(R.id.tvInterestRate);
        tvMonths = findViewById(R.id.tvMonths);
        tvMonthly = findViewById(R.id.tvMonthly);
        tvInterestAmount = findViewById(R.id.tvInterestAmount);
        tvTotal = findViewById(R.id.tvTotal);
        btnSubmit = findViewById(R.id.btnSubmit);
        sbAmount = findViewById(R.id.sbAmount);
        sbInterest = findViewById(R.id.sbInterest);
        sbMonths = findViewById(R.id.sbMonths);

        sbAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressAmount = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressAmount = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tvAmount.setText(String.valueOf(progressAmount));
            }
        });

        sbInterest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressInterest = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressInterest = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tvInterest.setText(String.valueOf(progressInterest));
            }
        });
        sbMonths.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressMonths = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressMonths = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                tvMonths.setText(String.valueOf(progressMonths));
            }
        });


    }

    public void onClick(View view) {

        String Amount = tvAmount.getText().toString();
        String Interest = tvInterest.getText().toString();
        String Months = tvMonths.getText().toString();

        double P = Double.valueOf(Amount);
        double R = Double.valueOf(Interest)/12/100;
        double T = Double.valueOf(Months);

        double emi = (P*R*Math.pow(1+R,T))/(Math.pow(1+R,T)-1);
        double total = emi * T;
        double amountInterest = total - P;

//        String d2stotal = String.format( "%.2d", total );
//        String d2smonthly = String.format( "%.2d", emi );
//        String d2sintRate = String.format( "%.2d", amountInterest );

        String tvt = String.valueOf(total);
        String tvm = String.valueOf(emi);
        String tim = String.valueOf(amountInterest);

        tvTotal.setText("Total Loan Amount: $" + tvt );
        tvMonthly.setText("Monthly Installments (" + Months + "): $" + tvm);
        tvInterestAmount.setText("Total Interest Amount: $" + tim);

    }
}
