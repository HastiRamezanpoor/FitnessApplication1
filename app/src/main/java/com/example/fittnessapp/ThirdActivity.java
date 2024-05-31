package com.example.fittnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;
    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean MTimeRunning;
    private long MTimeLeftinmills;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        Intent intent = getIntent();
        buttonvalue = intent.getStringExtra("value");


        int intvalue = Integer.valueOf(buttonvalue);


        switch (intvalue) {

            case 1:
                setContentView(R.layout.activity_b1);
                break;
            case 2:
                setContentView(R.layout.activity_b2);
                break;
            case 3:
                setContentView(R.layout.activity_b3);
                break;
            case 4:
                setContentView(R.layout.activity_b4);
                break;
            case 5:
                setContentView(R.layout.activity_b5);
                break;
            case 6:
                setContentView(R.layout.activity_b6);
                break;
            case 7:
                setContentView(R.layout.activity_b7);
                break;
            case 8:
                setContentView(R.layout.activity_b8);
                break;
            case 9:
                setContentView(R.layout.activity_b9);
                break;
            case 10:
                setContentView(R.layout.activity_b10);
                break;
            case 11:
                setContentView(R.layout.activity_b11);
                break;
            case 12:
                setContentView(R.layout.activity_b12);
                break;
            case 13:
                setContentView(R.layout.activity_b13);
                break;
            case 14:
                setContentView(R.layout.activity_b14);
                break;
            case 15:
                setContentView(R.layout.activity_b15);
                break;
        }


        startbtn=findViewById(R.id.startbutton1);
        mtextview=findViewById(R.id.time);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(MTimeRunning)
                {

                    stoptimer();
                }
                else
                {
                    startTimer();
                }
            }
        });

    }


    private  void  stoptimer(){


        countDownTimer.cancel();
        MTimeRunning=false;
        startbtn.setText("START");
    }

    private  void  startTimer(){

        final CharSequence value1 = mtextview.getText();
        String  num1 =value1.toString();
        String num2=num1.substring(0,2);
        String num3=num1.substring(3,5);



        final  int number=Integer.valueOf(num2)* 60+Integer.valueOf(num3);
        MTimeLeftinmills=number*1000;



        countDownTimer=new CountDownTimer(MTimeLeftinmills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                MTimeLeftinmills=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue= Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7)
                {
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else
                {
                    newvalue=1;
                    Intent intent= new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }

        }
                .start();
        startbtn.setText("Pause");
        MTimeRunning=true;

    }
    private  void updateTimer(){

        int minutes=(int) MTimeLeftinmills/60000;
        int seconds=(int)MTimeLeftinmills%60000 /1000;


        String timeleftText="";
        if (minutes<10)
            timeleftText="0";
        timeleftText=timeleftText+minutes+":";

        if(seconds<10)
            timeleftText+="0";
        timeleftText+=seconds;
        mtextview.setText(timeleftText);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    }