package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        subtotal_plus_tip_textview = (TextView) findViewById(R.id.subtotal_with_tip_total_amount_textview);
        each_person_owes_textview = (TextView) findViewById(R.id.each_person_owes_amount_total);
        round_up_button = (Button) findViewById(R.id.round_up_button_total);
        round_down_button = (Button) findViewById(R.id.round_down_button_total);




    }
    public static Intent newIntent(Context packageContext, double total_with_tip, int numOfGuests){
        Intent i = new Intent(packageContext, DetailsActivity.class);
        i.putExtra(TOTAL_WITH_TIP, total_with_tip);
        i.putExtra(NUM_OF_GUESTS, numOfGuests);
        return i;
    }
}
