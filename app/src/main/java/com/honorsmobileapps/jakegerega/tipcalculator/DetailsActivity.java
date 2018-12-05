package com.honorsmobileapps.jakegerega.tipcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private static final String SUBTOTAL_DETAILS = "com.honorsmobileapps.jakegerega.tipcalculator.subtotal_details";

    SeekBar percentSeekBar;
    RadioButton tenPercentRadioButton;
    RadioButton fifteenPercentRadioButton;
    RadioButton eighteenPercentRadioButton;
    RadioButton twentyfivePercentRadioButton;

    double subtotalAmt;
    double subtotalPlusTip;
    int numOfGuests;
    int tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        percentSeekBar = (SeekBar) findViewById(R.id.percent_seek);
        tenPercentRadioButton = (RadioButton) findViewById(R.id.ten_percent_button);
        fifteenPercentRadioButton = (RadioButton) findViewById(R.id.fifteen_percent_button);
        eighteenPercentRadioButton = (RadioButton) findViewById(R.id.eighteen_percent_button);
        twentyfivePercentRadioButton = (RadioButton) findViewById(R.id.twentyfive_percent_button);
        subtotalAmt = getIntent().getLongExtra(SUBTOTAL_DETAILS, 0);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.ten_percent_button) {
                    tip = 10;
                }
                if (v.getId() == R.id.fifteen_percent_button) {
                    tip = 15;
                }
                if (v.getId() == R.id.eighteen_percent_button) {
                    tip = 18;
                }
                if (v.getId() == R.id.twentyfive_percent_button) {
                    tip = 25;
                }
                percentSeekBar.setProgress(tip);
                setTipTextView();
            }
        };

        tenPercentRadioButton.setOnClickListener(listener);
        fifteenPercentRadioButton.setOnClickListener(listener);
        eighteenPercentRadioButton.setOnClickListener(listener);
        twentyfivePercentRadioButton.setOnClickListener(listener);

        setUpNumOfGuestsSpinner();
        setUpTipSeekBar();

    }

    public void setUpTipSeekBar() {
        SeekBar.OnSeekBarChangeListener seekListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tip = seekBar.getProgress();
                setTipTextView();
                setRadioButtonAsChecked();
            }
        };

        percentSeekBar.setOnSeekBarChangeListener(seekListener);
    }

    public void setTipTextView() {
        TextView tipAmountTextView = (TextView) findViewById(R.id.tip_amount_val);
        tipAmountTextView.setText(tip + "%");
        updateSubtotalWithTipTextView();
    }

    public void updateSubtotalWithTipTextView() {
        TextView subtotalTextView = (TextView) findViewById(R.id.total_with_tip_val);
        subtotalPlusTip = (subtotalAmt * (tip / 100.0)) + subtotalAmt;
        subtotalTextView.setText(String.format("$%.2f", subtotalPlusTip));
    }

    public void setRadioButtonAsChecked() {
        RadioGroup percentGroup = (RadioGroup) findViewById(R.id.percent_group);
        percentGroup.clearCheck();
        if (tip == 10) {
            tenPercentRadioButton.setChecked(true);

        } else if (tip == 15) {
            fifteenPercentRadioButton.setChecked(true);
        } else if (tip == 18) {
            eighteenPercentRadioButton.setChecked(true);
        } else if (tip == 25) {
            twentyfivePercentRadioButton.setChecked(true);
        }
    }

    public void setUpNumOfGuestsSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.guest_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.guests, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener adapterListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                numOfGuests = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(adapterListener);
    }

    public static Intent newIntent(Context packageContext, long subtotal){
        Intent i = new Intent(packageContext, DetailsActivity.class);
        i.putExtra(SUBTOTAL_DETAILS, subtotal);
        return i;
    }
}
