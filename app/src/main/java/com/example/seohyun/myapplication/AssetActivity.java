package com.example.seohyun.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class AssetActivity extends AppCompatActivity {
    TextView date_tv;
    CalendarView expandableCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asset_layout);

        date_tv = (TextView)findViewById(R.id.date_text);
        expandableCalendarView =(CalendarView)findViewById(R.id.expandable_calendar_view);

        expandableCalendarView.setVisibility(View.GONE);

        expandableCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                date_tv.setText(String.valueOf(year) + "/" + String.valueOf(month) + "/" + String.valueOf(date));
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
}
