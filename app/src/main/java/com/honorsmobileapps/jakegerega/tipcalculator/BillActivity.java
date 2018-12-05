package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BillActivity extends AppCompatActivity {

    private Button subtotalButtonOne;
    private Button subtotalButtonTwo;
    private Button subtotalButtonThree;
    private Button subtotalButtonFour;
    private Button subtotalButtonFive;
    private Button subtotalButtonSix;
    private Button subtotalButtonSeven;
    private Button subtotalButtonEight;
    private Button subtotalButtonNine;
    private Button subtotalButtonZero;
    private Button subtotalButtonBack;
    private Button subtotalButtonDone;
    private TextView subtotalAmountView;

    long subtotal;
    int digitEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill_activity);

        subtotalButtonOne = (Button) findViewById(R.id.button_one);
        subtotalButtonTwo = (Button) findViewById(R.id.button_two);
        subtotalButtonThree = (Button) findViewById(R.id.button_three);
        subtotalButtonFour = (Button) findViewById(R.id.button_four);
        subtotalButtonFive = (Button) findViewById(R.id.button_five);
        subtotalButtonSix = (Button) findViewById(R.id.button_six);
        subtotalButtonSeven = (Button) findViewById(R.id.button_seven);
        subtotalButtonEight = (Button) findViewById(R.id.button_eight);
        subtotalButtonNine = (Button) findViewById(R.id.button_nine);
        subtotalButtonZero = (Button) findViewById(R.id.button_zero);
        subtotalButtonBack = (Button) findViewById(R.id.button_back);
        subtotalButtonDone = (Button) findViewById(R.id.button_done);
        subtotalAmountView = (TextView) findViewById(R.id.subtotal_amount);
        subtotal = 0;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button_one){
                    digitEntered = 1;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_two){
                    digitEntered = 2;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_three){
                    digitEntered = 3;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_four){
                    digitEntered = 4;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_five){
                    digitEntered = 5;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_six){
                    digitEntered = 6;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_seven){
                    digitEntered = 7;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_eight){
                    digitEntered = 8;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_nine){
                    digitEntered = 9;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_zero){
                    digitEntered = 0;
                    addToSubtotal();
                }
                if(v.getId() == R.id.button_back){
                    removeFromSubtotal();
                }
                if(v.getId() == R.id.button_done){
                    Intent i = DetailsActivity.newIntent(BillActivity.this, subtotal);
                    startActivity(i);
                }
            }
        };
        subtotalButtonOne.setOnClickListener(listener);
        subtotalButtonTwo.setOnClickListener(listener);
        subtotalButtonThree.setOnClickListener(listener);
        subtotalButtonFour.setOnClickListener(listener);
        subtotalButtonFive.setOnClickListener(listener);
        subtotalButtonSix.setOnClickListener(listener);
        subtotalButtonSeven.setOnClickListener(listener);
        subtotalButtonEight.setOnClickListener(listener);
        subtotalButtonNine.setOnClickListener(listener);
        subtotalButtonZero.setOnClickListener(listener);
        subtotalButtonBack.setOnClickListener(listener);
        subtotalButtonDone.setOnClickListener(listener);

    }

    public void addToSubtotal(){
        subtotal = (subtotal * 10) + digitEntered;
        subtotalAmountView.setText("$" + subtotal + ".00");
    }
    public void removeFromSubtotal(){
        subtotal = subtotal / 10;
        subtotalAmountView.setText("$" + subtotal + ".00");
    }
}
