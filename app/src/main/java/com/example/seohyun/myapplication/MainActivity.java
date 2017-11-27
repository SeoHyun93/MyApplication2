package com.example.seohyun.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button button;
        Button button1;
        Button button2;
        Button button3;

        button=(Button)findViewById(R.id.Asset_btn);
        button1=(Button)findViewById(R.id.Input_btn);
        button2=(Button)findViewById(R.id.Category_btn);
        button3=(Button)findViewById(R.id.Restriction_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(MainActivity.this,AssetActivity.class);

                startActivity(intent1);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2=new Intent(MainActivity.this,InputActivity.class);

                startActivity(intent2);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent3=new Intent(MainActivity.this,CategoryActivity.class);

                startActivity(intent3);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent4=new Intent(MainActivity.this,RestrictionActivity.class);

                startActivity(intent4);
            }
        });
    }
}





