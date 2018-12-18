package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    private static final String TOTAL_WITH_TIP = "com.honorsmobileapps.jakegerega.tipcalculator.total_with_tip";
    private static final String NUM_OF_GUESTS = "com.honorsmobileapps.jakegerega.tipcalculator.num_of_guests";
    private TextView eachPersonOwesTextview;
    private double EachPersonPaysAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_activity);

        TextView subtotalPlusTipTextView = findViewById(R.id.subtotal_with_tip_total_amount_textview);
        eachPersonOwesTextview = findViewById(R.id.each_person_owes_amount_total);
        Button roundDownButton = findViewById(R.id.round_up_button_total);
        Button roundUpButton = findViewById(R.id.round_down_button_total);


        //round up with casting to int and adding one
        //round down with casting to int
        double TotalWithTip = getIntent().getDoubleExtra(TOTAL_WITH_TIP, 0);
        EachPersonPaysAmount = getIntent().getDoubleExtra(TOTAL_WITH_TIP, 0) / getIntent().getDoubleExtra(NUM_OF_GUESTS, 1.0);
        subtotalPlusTipTextView.setText(String.format("$%.2f", TotalWithTip));
        updateEachPersonOwesTextView();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.round_down_button_total) {
                    roundDown();
                } else if (v.getId() == R.id.round_up_button_total) {
                    roundUp();
                }
            }
        };
        roundDownButton.setOnClickListener(listener);
        roundUpButton.setOnClickListener(listener);
    }

    public static Intent newIntent(Context packageContext, double total_with_tip, double numOfGuests) {
        Intent i = new Intent(packageContext, TotalActivity.class);
        i.putExtra(TOTAL_WITH_TIP, total_with_tip);
        i.putExtra(NUM_OF_GUESTS, numOfGuests);
        return i;
    }

    public void roundUp() {
        int roundedUpEachPersonPaysAmt = (int) (getIntent().getDoubleExtra(TOTAL_WITH_TIP, 0) / getIntent().getDoubleExtra(NUM_OF_GUESTS, 1)) + 1;
        updateEachPersonOwesTextView((double) roundedUpEachPersonPaysAmt);
    }

    public void roundDown() {
        int roundedDownEachPersonPaysAmt = (int) (getIntent().getDoubleExtra(TOTAL_WITH_TIP, 0) / getIntent().getDoubleExtra(NUM_OF_GUESTS, 1));
        updateEachPersonOwesTextView((double) roundedDownEachPersonPaysAmt);
    }

    public void updateEachPersonOwesTextView(double roundedUpOrRoundedDownAmt) {
        eachPersonOwesTextview.setText(String.format("$%.2f", roundedUpOrRoundedDownAmt));
    }

    public void updateEachPersonOwesTextView() {
        eachPersonOwesTextview.setText(String.format("$%.2f", EachPersonPaysAmount));
    }
}
