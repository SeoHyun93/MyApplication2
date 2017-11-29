package com.example.seohyun.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class DateCalActivity extends AppCompatActivity {
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_cal_layout);
        calendarView = (CalendarView)findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int date) {
                String InputDate = (String.valueOf(year)+String.valueOf(String.format("%02d",month+1))+String.valueOf(String.format("%02d",date)));

                Intent intent1=new Intent(DateCalActivity.this,InputActivity.class);

                startActivity(intent1);

                Intent intent = new Intent(DateCalActivity.this,InputActivity.class);
                intent.putExtra("date1",InputDate.toString());

                startActivity(intent);
            }
        });
    }
}
