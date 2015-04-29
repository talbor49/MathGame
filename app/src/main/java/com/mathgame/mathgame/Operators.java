package com.mathgame.mathgame;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tal on 4/24/2015.
 */
public class Operators {
    public static final int ADD = 0;
    public static final int SUB = 1;
    public static final int MUL = 2;
    public static final int DIV = 3;
    public static final int POWER = 4;
    public static final int SQRT = 5;
    public static final int FACTORIAL = 6;
    public static final int MODULO = 7;

    private static final int BUTTON_WIDTH = 50;
    private static final int BUTTON_HEIGHT = 50;

    private TextView showCalculationTV;
    private ViewGroup layout;
    private Context context;
    private Resources resources;
    private List<Integer> operators;
    private int x, y;

    List<Button> buttons;
    public Operators(TextView showCalculationTV, ViewGroup layout, Context context,Resources resources, List<Integer> operators,int x, int y){
        this.showCalculationTV = showCalculationTV;
        this.layout = layout;
        this.context = context;
        this.resources = resources;
        this.operators = operators;
        this.x = x;
        this.y = y;


    }
    //In shop code: operators.add(FACTORIAL)
    public void createButtons()
    {
        int marginLeft = x;
        int marginTop = y;
        for(int i =0;i <operators.size();i++){
            int operator = operators.get(i);
            if(operator == ADD) {
                Button add = new Button(context);
                add.setText("+");
                add.setTextSize(25);

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "+";
                        showCalculationTV.setText(Calculator.toCalculate);
                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(add, buttonParams);
                continue;
            }


            else if(operator == SUB) {
                Button sub = new Button(context);
                sub.setText("-");
                sub.setTextSize(25);


                sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "-";
                        showCalculationTV.setText(Calculator.toCalculate);

                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(sub, buttonParams);
                continue;
            }

            else if(operator == MUL) {
                Button mul = new Button(context);
                mul.setText("*");
                mul.setTextSize(25);


                mul.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "*";
                        showCalculationTV.setText(Calculator.toCalculate);

                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(mul, buttonParams);
                continue;
            }


            else if(operator == DIV) {
                Button div = new Button(context);
                div.setText("/");
                div.setTextSize(25);


                div.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "/";
                        showCalculationTV.setText(Calculator.toCalculate);

                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(div, buttonParams);
                continue;
            }

            else if(operator == POWER) {
                Button power = new Button(context);
                power.setText("^");
                power.setTextSize(25);


                power.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "^";
                        showCalculationTV.setText(Calculator.toCalculate);

                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(power, buttonParams);
                continue;
            }

            else if(operator == SQRT) {
                Button sqrt = new Button(context);
                sqrt.setText("\u221A");
                sqrt.setTextSize(25);


                sqrt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calculator.toCalculate += "\\u221A";
                        showCalculationTV.setText(Calculator.toCalculate);

                    }
                });

                RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                        (int)convertDpToPixel(BUTTON_WIDTH, context),
                        (int)convertDpToPixel(BUTTON_HEIGHT, context)
                );
                buttonParams.setMargins(marginLeft, marginTop,0 ,0);
                marginLeft += (int)convertDpToPixel(BUTTON_WIDTH, context);
                layout.addView(sqrt, buttonParams);
                continue;
            }

        }

    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    public void draw()
    {


    }
}
