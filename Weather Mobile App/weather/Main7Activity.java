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


public class Main7Activity extends AppCompatActivity {

    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    CompactCalendarView compactCalendar;
    TextView h1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        h1=(TextView)findViewById(R.id.textView39);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        Event ev1 = new Event(Color.GREEN, 1477040400000L, "Right Day to HARVEST the plants");
        compactCalendar.addEvent(ev1);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                System.out.println(dateClicked.toString());

                    if (dateClicked.toString().compareTo("Tue Jun 28 00:00:00 GMT+05:30 2022") == 0) {
                        h1.setText("Right Day to HARVEST the plants");
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

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });




    }




}
