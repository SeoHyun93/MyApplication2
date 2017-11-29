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

    EditText editDate,income,expense;
    TextView result;
    Button button,btnaddData,btneditData,btndeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        myDb = new DatebaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        button=(Button)findViewById(R.id.input_main_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent1=new Intent(InputActivity.this,MainActivity.class);

                startActivity(intent1);

            }
        });
        editDate = (EditText)findViewById(R.id.editDate);
        income = (EditText)findViewById(R.id.income);
        expense = (EditText)findViewById(R.id.expense);
        result = (TextView) findViewById(R.id.result1);

        btnaddData = (Button)findViewById(R.id.confirm_btn);
        btndeleteData = (Button)findViewById(R.id.deletebtn);
        btneditData = (Button)findViewById(R.id.editbtn);

        AddData();
        UpdateData();
        DeleteData();
    }

    public void AddData(){
        btnaddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = income.getText().toString();
                String s2 = expense.getText().toString();
                int n1;
                n1= Integer.parseInt(s1);
                int n2;
                n2 = Integer.parseInt(s2);
                final int n3 = n1-n2;
                result.setText(Integer.toString(n3));
                boolean isInserted = myDb.insertData(editDate.getText().toString(),income.getText().toString(),expense.getText().toString(),String.valueOf(n3));
                if(isInserted == true)
                    Toast.makeText(InputActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(InputActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void UpdateData(){
        btneditData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = income.getText().toString();
                String s2 = expense.getText().toString();
                int n1;
                n1= Integer.parseInt(s1);
                int n2;
                n2 = Integer.parseInt(s2);
                final int n3 = n1-n2;
                result.setText(Integer.toString(n3));
                boolean isUpdate = myDb.updateData(editDate.getText().toString(),income.getText().toString(),expense.getText().toString(),String.valueOf(n3));
                if(isUpdate == true)
                    Toast.makeText(InputActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(InputActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void DeleteData(){

        btndeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRows = myDb.deleteData(editDate.getText().toString());
                if(deleteRows > 0)
                    Toast.makeText(InputActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(InputActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
