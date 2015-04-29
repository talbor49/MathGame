package com.mathgame.mathgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class Campaign extends Activity {


    public static final String NUMBER_TO_MAKE = "com.mathgame.mathgame.NUMBER_TO_MAKE";
    public static final String LEVEL = "com.mathgame.mathgame.LEVEL";
    public static final String DIFFICULTY = "com.mathgame.mathgame.DIFFICULTY";
    public static final String PRIMITIVE_NUMBERS = "com.mathgame.mathgame.PRIMITIVE_NUMBERS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);

        play1 = (Button)findViewById(R.id.play1);
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLevel(9,1,0,new int[]{1,2,3,5});
            }
        });

        play2 = (Button)findViewById(R.id.play2);
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLevel(12,2,0,new int[]{2,3,4,6,9});
            }
        });

        play3 = (Button)findViewById(R.id.play3);
        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLevel(24,3,0,new int[]{1,2,3,4,5,6});
            }
        });

        play4 = (Button)findViewById(R.id.play4);
        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLevel(9,3,0,new int[]{2,3,4,6,9,1,5});
            }
        });

    }
    private void callLevel(int numberToMake, int level, int difficulty, int[] primitivenumbers)
    {
        Intent i = new Intent(getApplicationContext(), CampaignLevel.class);

        i.putExtra(NUMBER_TO_MAKE, new int[]{numberToMake});
        i.putExtra(LEVEL, new int[]{level});
        i.putExtra(DIFFICULTY, new int[]{difficulty});
        i.putExtra(PRIMITIVE_NUMBERS, primitivenumbers);

        startActivity(i);

    }
    private Button play1, play2, play3, play4;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campaign, menu);
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
