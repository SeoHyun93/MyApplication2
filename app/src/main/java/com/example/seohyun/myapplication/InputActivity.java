package com.example.seohyun.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        Button button;

        button=(Button)findViewById(R.id.input_main_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent1=new Intent(InputActivity.this,MainActivity.class);

                startActivity(intent1);

            }
        });

    }

    public void addClick(View v){
        EditText num1 = (EditText) findViewById(R.id.inputmoney);
        EditText num2 = (EditText) findViewById(R.id.outputmoney);
        TextView result = (TextView) findViewById(R.id.result1);
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        result.setText(Integer.toString(n1-n2));
    }
}
