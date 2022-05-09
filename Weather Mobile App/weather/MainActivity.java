//login-page
package com.example.weather;

import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.app.AlertDialog.Builder;

import androidx.appcompat.app.AppCompatActivity;

import java.util.jar.Attributes;
public class MainActivity extends AppCompatActivity {
    Button signin,signup;
    EditText user,password;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signin=(Button) findViewById(R.id.button);
        signup=(Button) findViewById(R.id.button3);
        db = (SQLiteDatabase) openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);
        signin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //name = e1.getText().toString();

                //i.putExtra("name_key",name);
                user = (EditText) findViewById(R.id.editTextTextPersonName);
                password = (EditText) findViewById(R.id.editTextTextPassword);
                Cursor c = db.rawQuery("SELECT * FROM users WHERE username='"
                                + user.getText().toString().trim() + "'" +
                                "AND passwd='"+password.getText().toString().trim()+"'"
                        , null);
                if (c.moveToFirst()) {

                    String loginUsername = c.getString(1);
                    String loginPassword = c.getString(2);
                    showMessage("Success", "Welcome");

                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("name_key",c.getString(0));

                    i.putExtra("temperature",c.getString(4));
                    i.putExtra("humidity",c.getString(5));
                    i.putExtra("pressure",c.getString(6));
                    i.putExtra("ph-value",c.getString(7));
                    i.putExtra("phosphorous",c.getString(8));
                    i.putExtra("potassium",c.getString(9));

                    startActivity(i);
                }
                else
                {
                    showMessage("Error", "Enter the correct username and passsword!");
                }

            }
            public void showMessage(String title,String message)
            {
                Builder builder=new Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();
            }
        });

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //name = e1.getText().toString();
                Intent i = new Intent(MainActivity.this, Main1Activity.class);
                //i.putExtra("name_key",name);
                startActivity(i);

            }

        });



    }


}