package com.example.charlesburks.thehomestead;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class Tab4 extends ActionBarActivity {

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    int hour;
    int minute;
    private Button btDate, btTime;
    private TextView timeDisplay;
    private TextView dateDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4);

        final Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        timeDisplay = (TextView) findViewById(R.id.txtTime);
        dateDisplay = (TextView) findViewById(R.id.txtDate);
        btDate = (Button) findViewById(R.id.bttDate);
        btTime = (Button) findViewById(R.id.bttTime);


        btDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
            }
        });
        btTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, reservationDate, currentYear,
                        currentMonth, currentDay);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timeDate, hour, minute, false);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener reservationDate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int month, int day) {


            dateDisplay.setText("Your reservation date:  "
                    + (month + 1) + "-" + day + "-" + year);

        }

    };


    private TimePickerDialog.OnTimeSetListener timeDate = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hours, int minutes) {
            if (hours < 17 || hours > 23) {
                Toast.makeText(getApplicationContext(), "Pick Time from 5pm to 11pm", Toast.LENGTH_LONG).show();
            } else {

                timeDisplay.setText("Your reservation time " + (hours - 12) + ":"
                        + minutes + " pm.");
            }
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

