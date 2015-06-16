package com.example.charlesburks.thehomestead;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Tab3 extends Activity {
    Integer [] Seasons = {R.drawable.swim, R.drawable.front, R.drawable.golf, R.drawable.door};
    int clicks =0;
    MediaPlayer buttonNoise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);
        final ImageView mainImg = (ImageView) findViewById(R.id.mainView);
        final Button button = (Button) findViewById(R.id.spingBtt);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks = 0;
                switch (clicks){
                    case 0:

                        mainImg.setVisibility(View.VISIBLE);
                        mainImg.setBackgroundResource(Seasons[0]);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                "Swim", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 200);
                        toast.show();

                        clicks = 1;
                        break;
                    case 1:
                        mainImg.setVisibility(View.INVISIBLE);
                        //clicks = 0;
                }

                mainImg.setBackgroundResource(Seasons[0]);
            }
        });
        final Button button2 = (Button) findViewById(R.id.summerBtt);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks = 0;
                switch (clicks){
                    case 0:

                        mainImg.setVisibility(View.VISIBLE);
                        mainImg.setBackgroundResource(Seasons[1]);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                "Stay", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 200);
                        toast.show();
                        clicks = 1;
                        break;
                    case 1:
                        mainImg.setVisibility(View.INVISIBLE);
                        //clicks = 0;
                }
            }
        });
        final Button button3 = (Button) findViewById(R.id.fallBtt);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks = 0;
                switch (clicks){
                    case 0:

                        mainImg.setVisibility(View.VISIBLE);
                        mainImg.setBackgroundResource(Seasons[2]);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                "Golf", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 200);
                        toast.show();
                        clicks = 1;
                        break;
                    case 1:
                        mainImg.setVisibility(View.INVISIBLE);
                        //clicks = 0;
                }
            }
        });
        final Button button4 = (Button) findViewById(R.id.winterBtt);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clicks = 0;
                switch (clicks){
                    case 0:

                        mainImg.setVisibility(View.VISIBLE);
                        mainImg.setBackgroundResource(Seasons[3]);
                        Toast toast= Toast.makeText(getApplicationContext(),
                                "Hobbits?", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 200);
                        toast.show();
                        clicks = 1;
                        break;
                    case 1:
                        mainImg.setVisibility(View.INVISIBLE);
                        //clicks = 0;
                }
            }
        });


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
