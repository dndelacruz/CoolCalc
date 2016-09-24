package com.dndapps.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


//Android Annotations


@EActivity
public class CalcActivity extends Activity {

    float results = 0;
    float firstNum = 0;
    float secondNum = 0;
    String resultString ="";
    boolean appendToResultsText = false;
    boolean firstNumStatus = true;
    char operations = '-';

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        initialize();
    }

    void initialize(){
        results = 0;
        firstNum = 0;
        secondNum = 0;
        resultString ="";
        appendToResultsText = false;
        firstNumStatus = true;
        operations = '-';
        resultsText.setText("0");
    }

    @ViewById(R.id.resultsTxt)
    TextView resultsText;

    void NumberPressed(int number){

        //check whether to append or initialize results Text
        if (appendToResultsText){
            resultString += String.valueOf(number);
        }
        else{
            resultString = String.valueOf(number);
            appendToResultsText = true;
        }
        //check if for first num or second num
        if(firstNumStatus)
            firstNum = Float.parseFloat(resultString);
        else
            secondNum = Float.parseFloat(resultString);

        resultsText.setText(resultString);
    }

    //method of operations

    void OperateNow (char ops){
        if(firstNumStatus) {
            firstNum = Float.parseFloat(resultString);

            firstNumStatus = false;
        }
        else{
            secondNum = Float.parseFloat(resultString);

        }
        resultString="";
        resultsText.setText("0");
        operations = ops;
    }

    void CalcNow (){
        if(operations=='-')
            results = firstNum - secondNum;
        else if(operations=='+')
            results = firstNum + secondNum;
        else if(operations=='*')
            results = firstNum * secondNum;
        else
            results = firstNum / secondNum;


        resultsText.setText(String.valueOf(results));
        firstNumStatus = false;
        firstNum =results;
        resultString = String.valueOf(results);
        secondNum = 0;
    }

    //add click listeners for numbers

    @Click
    void zeroBtn(){

        if(resultString != "")
            NumberPressed(0);

    }

    @Click
    void oneBtn(){
        NumberPressed(1);
    }

    @Click
    void twoBtn(){
        NumberPressed(2);
    }

    @Click
    void threeBtn(){
        NumberPressed(3);
    }

    @Click
    void fourBtn(){
        NumberPressed(4);
    }

    @Click
    void fiveBtn(){
        NumberPressed(5);
    }

    @Click
    void sixBtn(){
        NumberPressed(6);
    }

    @Click
    void sevenBtn(){
        NumberPressed(7);
    }

    @Click
    void eightBtn(){
        NumberPressed(8);
    }

    @Click
    void nineBtn(){
        NumberPressed(9);
    }


    @Click
    void clearBtn(){
        initialize();
    }


    //add listeners for operators

    @Click
    void divideBtn(){
        OperateNow('/');
    }

    @Click
    void addBtn(){
        OperateNow('+');
    }

    @Click
    void subtractBtn(){
        OperateNow('-');
    }

    @Click
    void  multiplyBtn(){
        OperateNow('*');
    }

    //listener for equals button

    @Click
    void calcBtn(){
        CalcNow();
    }




}
