package com.example.seohyun.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatebaseHelper myDb;

    Button sd_btn;

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
        sd_btn=(Button)findViewById(R.id.Showdata_btn);


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

        myDb = new DatebaseHelper(this);
        viewAll();
    }

    public void viewAll(){
        sd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0){
                    showMessage("ERROR","NO DATA");
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("DATE : "+ res.getString(0)  +"\n");
                    buffer.append("INCOME : "+ res.getString(1) +"\n");
                    buffer.append("EXPENSE : "+ res.getString(2) +"\n");
                    buffer.append("RESULT : "+ res.getString(3) +"\n\n");
                }

                showMessage("ALL DATA", buffer.toString());
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





