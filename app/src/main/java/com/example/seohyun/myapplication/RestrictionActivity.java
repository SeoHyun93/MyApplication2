package com.example.seohyun.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RestrictionActivity extends AppCompatActivity {


    DatebaseHelper myDb;
    Button res_btn;
    EditText res_date,res_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDb = new DatebaseHelper(this);

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

        res_btn = (Button)findViewById(R.id.res_btn);
        res_date = (EditText)findViewById(R.id.res_date);
        res_amount = (EditText)findViewById(R.id.res_amount);

        resData();
    }

    public void resData(){

        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = myDb.getAllData();
                if(res.getCount() == 0){
                    showMessage("ERROR","NO DATA");
                }

                StringBuffer buffer = new StringBuffer();

                int s=0;

                while(res.moveToNext()){

                    String s1 = res.getString(0);
                    String s2 = res_date.getText().toString();
                    String s3 = res.getString(3);

                    if( (s1.substring(0,6)).equals(s2)){
                        s = s + Integer.parseInt(s3);
                    }
                }

                int r = Integer.parseInt(res_amount.getText().toString());

                if(r >= s)
                    showMessage("RESTRICTION",String.valueOf(r-s));
                else
                        showMessage("EXCEED",String.valueOf(r-s));
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
