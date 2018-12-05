package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    private static final String TOTAL_WITH_TIP = "com.honorsmobileapps.jakegerega.tipcalculator.total_with_tip";
    private static final String NUM_OF_GUESTS = "com.honorsmobileapps.jakegerega.tipcalculator.num_of_guests";

    private TextView subtotal_plus_tip_textview;
    private TextView each_person_owes_textview;
    private Button round_up_button;
    private Button round_down_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_activity);


    }
    public static Intent newIntent(Context packageContext, double total_with_tip, int numOfGuests){
        Intent i = new Intent(packageContext, DetailsActivity.class);
        i.putExtra(TOTAL_WITH_TIP, total_with_tip);
        i.putExtra(NUM_OF_GUESTS, numOfGuests);
        return i;
    }
}
