package com.mathgame.mathgame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CampaignLevel extends Activity {

    private static final int BUTTON_WIDTH = 60;
    private static final int BUTTON_HEIGHT = 60;


    public int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_level);
        Intent intent = getIntent();
        int numberToMake = intent.getIntArrayExtra(Campaign.NUMBER_TO_MAKE)[0];
        int level = intent.getIntArrayExtra(Campaign.LEVEL)[0];
        int difficulty = intent.getIntArrayExtra(Campaign.DIFFICULTY)[0];
        final int[] primitiveNumbers = intent.getIntArrayExtra(Campaign.PRIMITIVE_NUMBERS);

        Calculator.toCalculate = "";

        numToMakeTV = (TextView)findViewById(R.id.numToMakeTV);
        numToMakeTV.setText(numberToMake + "");

        numbersButtons = new Button[primitiveNumbers.length];
        for(int i =0; i <primitiveNumbers.length;i++) {
            numbersButtons[i] = new Button(this);
            numbersButtons[i].setWidth(pxInDIP(BUTTON_WIDTH));
            numbersButtons[i].setHeight(pxInDIP(BUTTON_HEIGHT));
            numbersButtons[i].setTextSize(40);
            numbersButtons[i].setText(primitiveNumbers[i] + "");
            num = primitiveNumbers[i];
            numbersButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calculator.toCalculate += ((Button)v).getText();
                    showCalculationTV.setText(Calculator.toCalculate);
                }
            });
        }


        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_campaign_level);




        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();




        int w = displayMetrics.widthPixels;
        int l = pxInDIP(BUTTON_WIDTH);
        int x = numbersButtons.length;
        int buttonsLeft = x;
        int d;
        if(x<4)
            d = (w-x*l)/(x+1);
        else
            d = (w-4*l)/(5);
        int marginLeft = d/2;
        int marginTop = pxInDIP(300);
        for (int i =0;i<numbersButtons.length;i++)
        {
            if(i>1 && i%3==1) {
                buttonsLeft -=4;
                marginTop += pxInDIP(BUTTON_HEIGHT) + pxInDIP(20);
                if(buttonsLeft<4)
                    d = (w-buttonsLeft*l)/(buttonsLeft+1);
                else
                    d = (w-4*l)/(5);
                marginLeft = d - BUTTON_WIDTH/2;
            }

            RelativeLayout.LayoutParams thisRL = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            thisRL.setMargins(marginLeft, marginTop, 0,0);
            layout.addView(numbersButtons[i], thisRL);
            marginLeft += d + l;
        }


        showCalculationTV = (TextView)findViewById(R.id.showCalculationTV);


        List<Integer> ops = new ArrayList<Integer>();
        ops.add(Operators.ADD);
        ops.add(Operators.SUB);
        ops.add(Operators.MUL);
        ops.add(Operators.DIV);
        ops.add(Operators.POWER);
        ops.add(Operators.SQRT);
        Operators operators = new Operators(showCalculationTV, layout, this, getResources(), ops, 0, pxInDIP(450));
        operators.createButtons();

    }

    static TextView showCalculationTV;


    Button[] numbersButtons;


    TextView numToMakeTV;

    public int pxInDIP(int pixels) {
        //For when we need to grab certain device info
        Resources r = getResources();
        //Converts pixels to DIP
        int densityIndependentPixels = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixels,
                r.getDisplayMetrics()
        );
        return densityIndependentPixels;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campaign_level, menu);
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
