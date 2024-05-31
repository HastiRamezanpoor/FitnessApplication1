package com.example.fittnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;




public class SecondActivity extends AppCompatActivity {


    int[]newArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        newArray=new int[]{

             R.id.b1_pose,R.id.b2_pose,R.id.b3_pose,R.id.b4_pose,R.id.b5_pose,R.id.b6_pose,R.id.b7_pose,
                R.id.b8_pose,R.id.b9_pose,R.id.b10_pose,R.id.b11_pose,R.id.b12_pose,R.id.b13_pose
                ,R.id.b14_pose,R.id.b15_pose

        };


    }

    public void Imagebuttonclicked(View view) {


        for (int i=0;i<newArray.length;i++)
        {
            if(view.getId()==newArray[i])
            {
                int value=i+1;
                Log.i("First",String.valueOf(value));
                Intent intent =new Intent(SecondActivity.this,ThirdActivity.class);

                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);



            }
        }

    }
}