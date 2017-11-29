package com.example.seohyun.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    DatebaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myDb = new DatebaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        Button button;
        Button editbtn;

        button=(Button)findViewById(R.id.input_main_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent1=new Intent(InputActivity.this,MainActivity.class);

                startActivity(intent1);

            }
        });
        editbtn=(Button)findViewById(R.id.editbtn);
    }

    public void addClick(View v){
        EditText num0 = (EditText) findViewById(R.id.editDate);
        EditText num1 = (EditText) findViewById(R.id.inputmoney);
        EditText num2 = (EditText) findViewById(R.id.outputmoney);
        TextView result = (TextView) findViewById(R.id.result1);
        int n0 = Integer.parseInt(num0.getText().toString());
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int n3 = n1-n2;
        result.setText(Integer.toString(n3));

        boolean isInserted = myDb.insertData(num0.getText().toString(),num1.getText().toString(),num2.getText().toString(),String.valueOf(n3));
        if(isInserted = true)
            Toast.makeText(InputActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(InputActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

    public void updateClick(View v){
        EditText num0 = (EditText) findViewById(R.id.editDate);
        EditText num1 = (EditText) findViewById(R.id.inputmoney);
        EditText num2 = (EditText) findViewById(R.id.outputmoney);
        TextView result = (TextView) findViewById(R.id.result1);
        int n0 = Integer.parseInt(num0.getText().toString());
        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int n3 = n1-n2;
        result.setText(Integer.toString(n3));

        boolean isUpdate = myDb.updateData(num0.getText().toString(),num1.getText().toString(),num2.getText().toString(),String.valueOf(n3));
        if(isUpdate = true)
            Toast.makeText(InputActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(InputActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
    }
}
