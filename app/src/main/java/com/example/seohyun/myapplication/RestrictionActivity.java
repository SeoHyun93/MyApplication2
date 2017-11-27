package com.example.seohyun.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestrictionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restriction_layout);

        Button button;

        button=(Button)findViewById(R.id.res_main_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(RestrictionActivity.this,MainActivity.class);

                startActivity(intent);

            }
        });
    }
}
