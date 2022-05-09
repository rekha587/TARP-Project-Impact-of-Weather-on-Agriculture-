package com.example.weather;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Main6Activity extends AppCompatActivity {

//    CalendarView calender;
CompactCalendarView compactCalendar;
Button view;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    TextView h,h1;
    TextView temp,hum;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
//      calender=(CalendarView)findViewById(R.id.calendarView);
        h = (TextView) findViewById(R.id.textView37);
        h1=(TextView)findViewById(R.id.textView38);
        temp = (TextView) findViewById(R.id.textView34);
        hum = (TextView) findViewById(R.id.textView35);
        view=(Button)findViewById(R.id.button12);

        Intent i=getIntent();
        String temperature=i.getExtras().getString("temperature2");
        String humidity=i.getExtras().getString("humidity2");

        temp.setText(temperature);
        hum.setText(humidity);
        float myNum = Float.valueOf(temp.getText().toString());
        float myNum1 = Float.valueOf(hum.getText().toString());

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.GREEN, 1477040400000L, "Right Day to Plant the crops");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                System.out.println(dateClicked.toString());
                if ((myNum >= 27 && myNum <= 32) && (myNum1 <= 72)) {
                    if (dateClicked.toString().compareTo("Thu Apr 28 00:00:00 GMT+05:30 2022") == 0) {
                        h1.setText("Right Day to sow Rice");
                        Toast.makeText(context, "Right Day to sow Rice", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                        h1.setText("No Events Planned for that day");
                    }
//                if(dateClicked.toString().compareTo("Wed Jun 22 00:00:00 GMT+05:30 2022") == 0){
//                    h.setText("Time to harvest the Rice");
////                    Toast.makeText(context, "Time to harvest the Rice", Toast.LENGTH_SHORT).show();
//                }
//                else {
////                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
//                    h.setText("No Events Planned for that day");
//                }


                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });





//        calender.setOnDateChangeListener(
//                new CalendarView.OnDateChangeListener() {
//                    @Override
//                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
//
//                        String Date=i2+" - "+(i1+1)+" - "+i;
//                        h.setText(Date);
//
//                    }
//                }
//        );


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main6Activity.this, Main7Activity.class);
                startActivity(i);
            }
        });



    }
}
