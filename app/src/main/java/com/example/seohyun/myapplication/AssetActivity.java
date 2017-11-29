package com.example.seohyun.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class AssetActivity extends AppCompatActivity {
    DatebaseHelper myDb;

    TextView date_tv;
    CalendarView expandableCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_layout);

        myDb = new DatebaseHelper(this);

        date_tv = (TextView)findViewById(R.id.date_text);
        expandableCalendarView =(CalendarView)findViewById(R.id.expandable_calendar_view);

        expandableCalendarView.setVisibility(View.GONE);

        expandableCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {

                String InputDate = (String.valueOf(year)+String.valueOf(String.format("%02d",month+1))+String.valueOf(String.format("%02d",date)));

                Cursor res = myDb.getAllData();

                res.moveToFirst();

                date_tv.setText(String.valueOf(year) + "/" + String.valueOf(String.format("%02d",month+1)) + "/" + String.valueOf(String.format("%02d",date)));

                if(res.getCount() == 0){
                    showMessage("Error","Nothing");
                }

                StringBuffer buffer = new StringBuffer();

                int chk =0;

                do{
                    if(InputDate.equals(res.getString(0))){
                        chk++;
                        buffer.append("DATE : "+res.getString(0)+"\n");
                        buffer.append("IN : "+res.getString(1)+"\n");
                        buffer.append("OUT : "+res.getString(2)+"\n");
                        buffer.append("RE : "+res.getString(3));

                        showMessage("ASSET",buffer.toString());
                    }
                }while(res.moveToNext());

                if(chk ==0){
                    showMessage("ERROR","NO DATA SELCETED DATE");
                }
                expandableCalendarView.setVisibility(View.GONE);


            }
        });

        date_tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                expandableCalendarView.setVisibility(expandableCalendarView.isShown()
                        ? View.GONE
                        : View.VISIBLE);
            }
        });

        Button button;

        button=(Button)findViewById(R.id.Back_btn);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent1=new Intent(AssetActivity.this,MainActivity.class);

                startActivity(intent1);

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
