package com.example.charlesburks.thehomestead;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Tab2 extends Activity {

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    static final int DATE_DIALOG_ID = 0;
    private Button btDate;
    private TextView reservation;
    int myNights;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        btDate = (Button) findViewById(R.id.nightBtt);
        reservation = (TextView) findViewById(R.id.mainView);
        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);

            }
        });
        final Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);


    }

    // returns the date
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, reservationDate, currentYear, currentMonth, currentDay);
        }
        return null;
    }

    //calls the MyAlert java page. Sends the check in date, check out date, number of nights, and total price.
    private DatePickerDialog.OnDateSetListener reservationDate =
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    MyAlert myalert = new MyAlert();
                    myalert.show(getFragmentManager(), "Your Scheduled Time");
                    reservation.setText("Your reservations is set for " + (month + 1) + ("-") + day + ("-") + year);
                    String dayOne = "" + (month + 1) + ("-") + day + ("-") + year;
                    String lastDay = dateAdding((month + 1) + "-" + day + "-"+ year);
                    int price = (myNights * 125);
                    myalert.setDates(dayOne, lastDay, myNights, price);

                }
            };

    // simple method that calculates the check out day
    String dateAdding(String Date)
    {
        EditText nights = (EditText)findViewById(R.id.nightsEdit);
        myNights = Integer.parseInt(nights.getText().toString());
        int Days = myNights;
        String finaldate="";
        try
        {
            java.util.Date date = null;
            String str = Date;
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            date = formatter.parse(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE,Days );
            finaldate= formatter.format(calendar.getTime());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return finaldate;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}