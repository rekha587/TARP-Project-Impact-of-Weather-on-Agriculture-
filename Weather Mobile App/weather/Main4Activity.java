package com.example.weather;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity {

    EditText temperature, humidity, pressure, ph,phosphorous,potassium;
    TextView h;
    Button submit;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        h = (TextView) findViewById(R.id.textView22);
        temperature = (EditText) findViewById(R.id.editTextNumber);
        humidity = (EditText) findViewById(R.id.editTextNumber2);
        pressure = (EditText) findViewById(R.id.editTextNumber3);
        ph = (EditText) findViewById(R.id.editTextNumber4);
        phosphorous = (EditText) findViewById(R.id.editTextNumber5);
        potassium = (EditText) findViewById(R.id.editTextNumber6);
        submit=(Button) findViewById(R.id.button8);

        Intent i=getIntent();
        String name = i.getExtras().getString("username");
        h.setText(name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = (SQLiteDatabase) openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
                Cursor c = db.rawQuery("SELECT * FROM users WHERE username='" + name.toString().trim() + "'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE users SET temperature='" + temperature.getText() + "',hum='" + humidity.getText() +
                                    "',press='" + pressure.getText()+ "',ph='" + ph.getText()+ "',phosphorous='" + phosphorous.getText()+"',potassium='" + potassium.getText()+
                            "' WHERE username='"+name+"'");
                    Toast.makeText(getApplicationContext(),"Success!! Record modified",Toast.LENGTH_SHORT).show();
//                    showMessage("Success", "Record Modified");
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error!! Invalid Username",Toast.LENGTH_SHORT).show();
//                    showMessage("Error", "Invalid Rollno");
                }
            }

//            private void showMessage(String title, String message) {
//                Builder builder = new Builder(this);
//                builder.setCancelable(true);
//                builder.setTitle(title);
//                builder.setMessage(message);
//                builder.show();
//            }


        });







    }

}