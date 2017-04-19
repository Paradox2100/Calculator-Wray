package com.alex.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

public class base_calculator extends AppCompatActivity {

    private TextView calculatorDisplay;

    private Button deleteButton;
    private Button clearButton;
    private Button negativeButton;

    private Button addButton;
    private Button minusButton;
    private Button multiplyButton;
    private Button divideButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;
    private Button decimalButton;
    private Button equalsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_calculator);

        calculatorDisplay = (TextView)findViewById(R.id.calcDisplay);

        addButton = (Button) findViewById(R.id.addBtn);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + " + ");

            }
        });

        minusButton = (Button) findViewById(R.id.minusBtn);
        minusButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               calculatorDisplay.setText(calculatorDisplay.getText() + " - ");

           }
        });

        multiplyButton = (Button) findViewById(R.id.multBtn);
        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + " * ");

            }
        });

        divideButton = (Button) findViewById(R.id.divBtn);
        divideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + " / ");

            }
        });

        oneButton = (Button) findViewById(R.id.oneBtn);
        oneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "1");

            }
        });

        twoButton = (Button) findViewById(R.id.twoBtn);
        twoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "2");

            }
        });

        threeButton = (Button) findViewById(R.id.threeBtn);
        threeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "3");

            }
        });

        fourButton = (Button) findViewById(R.id.fourBtn);
        fourButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "4");

            }
        });

        fiveButton = (Button) findViewById(R.id.fiveBtn);
        fiveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "5");

            }
        });

        sixButton = (Button) findViewById(R.id.sixBtn);
        sixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "6");

            }
        });

        sevenButton = (Button) findViewById(R.id.sevenBtn);
        sevenButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "7");

            }
        });

        eightButton = (Button) findViewById(R.id.eightBtn);
        eightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "8");

            }
        });

        nineButton = (Button) findViewById(R.id.nineBtn);
        nineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "9");

            }
        });

        zeroButton = (Button) findViewById(R.id.zeroBtn);
        zeroButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "0");

            }
        });

        decimalButton = (Button) findViewById(R.id.decimalBtn);
        decimalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + ".");

            }
        });

        negativeButton = (Button) findViewById(R.id.negativeBtn);
        negativeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText(calculatorDisplay.getText() + "-");
            }
        });

        deleteButton = (Button) findViewById(R.id.deleteBtn);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String hold = calculatorDisplay.getText().toString();
                if(hold.length() >= 1) {
                    if(hold.substring(hold.length()-1,hold.length()).equals(" ")){
                        hold = hold.substring(0,hold.length() - 3);
                        calculatorDisplay.setText(hold);
                    }
                    else {
                        hold = hold.substring(0, hold.length() - 1);
                        calculatorDisplay.setText(hold);
                    }
                }
                else if(hold.length() < 1)
                    calculatorDisplay.setText("");
            }
        });

        clearButton = (Button) findViewById(R.id.clearBtn);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculatorDisplay.setText("");
            }
        });


        equalsButton = (Button) findViewById(R.id.equalsBtn);
        equalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double mainDouble = 0.0;
                double swapDouble = 0.0;
                String operator = null;
                String holdStr = calculatorDisplay.getText().toString();
                String[] splitStr = holdStr.split(" ");

                try {
                    for (int i = 0; i < splitStr.length; i++) {

                        //If one of the 3 variables isn't filled try to give it a value
                        if (mainDouble == 0.0 || swapDouble == 0.0 || operator == null) {
                            if (splitStr[i].equals("+")) operator = "+";
                            else if (splitStr[i].equals("-")) operator = "-";
                            else if (splitStr[i].equals("*")) operator = "*";
                            else if (splitStr[i].equals("/")) operator = "/";
                            else if (mainDouble != 0.0)
                                swapDouble = Double.parseDouble(splitStr[i]);
                            else
                                mainDouble = Double.parseDouble(splitStr[i]);
                        }

                        // If all 3 variables have been filled, then calculate
                        // and set operator and swapDouble to zero
                        if (mainDouble != 0 && swapDouble != 0 && operator != null) {
                            if (operator.equals("+")) mainDouble = mainDouble + swapDouble;
                            else if (operator.equals("-")) mainDouble = mainDouble - swapDouble;
                            else if (operator.equals("*")) mainDouble = mainDouble * swapDouble;
                            else if (operator.equals("/")) mainDouble = mainDouble / swapDouble;
                            operator = null;
                            swapDouble = 0.0;

                        }

                    }
                    Double holdDouble = mainDouble;
                    calculatorDisplay.setText(holdDouble.toString());
                }
                catch(ArithmeticException e){
                    Log.d("", "Can not divide by zero");
                    Toast.makeText(getApplicationContext(),"Divide by zero error",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    Log.d("", "Can not have multiple operators in a row");
                    Toast.makeText(getApplicationContext(),"Can't have multiple operators in a row",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        outState.putString("savedDisplay", calculatorDisplay.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        calculatorDisplay.setText(savedInstanceState.getString("savedDisplay"));

    }
}
