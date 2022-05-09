package com.example.weather;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Integer.parseInt;


public class Main2Activity extends AppCompatActivity {
    Button graph1, graph2, graph3,log,change,predict,track;
    TextView temp, press, hum;


    TextView txtJson,txtJson1,txtJson2;
    ProgressDialog pd,pd1,pd2;
    String a,b,c;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        graph1 = (Button) findViewById(R.id.button4);
        graph2 = (Button) findViewById(R.id.button5);
        graph3 = (Button) findViewById(R.id.button6);
        log = (Button) findViewById(R.id.button7);
        change = (Button) findViewById(R.id.button9);
        predict=(Button) findViewById(R.id.button11);
        track=(Button) findViewById(R.id.button10);

        txtJson = (TextView) findViewById(R.id.textView11);
        txtJson1 = (TextView) findViewById(R.id.textView12);
        txtJson2= (TextView) findViewById(R.id.textView13);



            Intent i=getIntent();
            String name = i.getExtras().getString("name_key");
            String temperature=i.getExtras().getString("temperature");

        String humidity=i.getExtras().getString("humidity");
        String pressure=i.getExtras().getString("pressure");
        String ph=i.getExtras().getString("ph-value");
        String phosphorous=i.getExtras().getString("phosphorous");
        String potassium=i.getExtras().getString("potassium");

        hello();


        final Handler ha=new Handler();
        ha.postDelayed(new Runnable(){
            public void run() {
                hello();


                ha.postDelayed(this, 10000);
                float myNum = 0;
                float myNum1 = 0;
                float myNum2 = 0;

                try {
                    myNum = Float.valueOf(txtJson.getText().toString());
                    System.out.println(myNum);
                    myNum1 = Float.valueOf(txtJson1.getText().toString());
                    System.out.println(myNum1);
                    myNum2 = Float.valueOf(txtJson2.getText().toString());
                    System.out.println(myNum2);
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
                if(myNum>=Float.valueOf(temperature))
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel channel=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
                        NotificationManager manager=getSystemService(NotificationManager.class);
                        manager.createNotificationChannel(channel);
                    }

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(Main2Activity.this, "My notification");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setContentTitle("Alert!!!!!");
                    builder.setContentText("Temperature is greater than 40");
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Main2Activity.this);
                    managerCompat.notify(1, builder.build());
                }
                if(myNum1>=Float.valueOf(humidity))
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel channel1=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
                        NotificationManager manager1=getSystemService(NotificationManager.class);
                        manager1.createNotificationChannel(channel1);
                    }

                    NotificationCompat.Builder builder1 = new NotificationCompat.Builder(Main2Activity.this, "My notification");
                    builder1.setSmallIcon(R.drawable.ic_launcher_background);
                    builder1.setContentTitle("Alert!!!!!");
                    builder1.setContentText("Humidity is greater than 44.00");
                    builder1.setAutoCancel(true);

                    NotificationManagerCompat managerCompat1 = NotificationManagerCompat.from(Main2Activity.this);
                    managerCompat1.notify(2, builder1.build());
                }
                if(myNum2>=Float.valueOf(pressure))
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        NotificationChannel channel2=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
                        NotificationManager manager2=getSystemService(NotificationManager.class);
                        manager2.createNotificationChannel(channel2);
                    }

                    NotificationCompat.Builder builder2 = new NotificationCompat.Builder(Main2Activity.this, "My notification");
                    builder2.setSmallIcon(R.drawable.ic_launcher_background);
                    builder2.setContentTitle("Alert!!!!!");
                    builder2.setContentText("pressure is greater than 99252.85");
                    builder2.setAutoCancel(true);

                    NotificationManagerCompat managerCompat2 = NotificationManagerCompat.from(Main2Activity.this);
                    managerCompat2.notify(3, builder2.build());
                }

            }
        },20000);









//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//                NotificationChannel channel=new NotificationChannel("My notification","My notification", NotificationManager.IMPORTANCE_DEFAULT);
//                NotificationManager manager=getSystemService(NotificationManager.class);
//                manager.createNotificationChannel(channel);
//            }
//
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(Main2Activity.this, "My notification");
//                builder.setSmallIcon(R.drawable.ic_launcher_background);
//                builder.setContentTitle("Alert!!!!!");
//                builder.setContentText("Temperature is greater than 40");
//                builder.setAutoCancel(true);
//
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Main2Activity.this);
//                managerCompat.notify(1, builder.build());













        graph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("url", "https://thingspeak.com/channels/1635769/charts/1?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");
                startActivity(i);
            }
        });

        graph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("url", "https://thingspeak.com/channels/1635769/charts/2?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&type=line&update=15");
                startActivity(i);
            }
        });

        graph3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                i.putExtra("url", "https://thingspeak.com/channels/1635769/charts/3?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Pressure&type=line");
                startActivity(i);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                //i.putExtra("url", "https://thingspeak.com/channels/1635769/charts/3?api_key=KUWKGSXKWQ5KDXP1&bgcolor=%23ffffff&color=%23d62020&dynamic=true&results=60&title=Pressure&type=line");
                startActivity(i);
                Toast.makeText(getApplicationContext(),"logged out",Toast.LENGTH_SHORT).show();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, Main4Activity.class);
                i.putExtra("username",name);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Change Threshold value Now",Toast.LENGTH_SHORT).show();
            }
        });
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Main2Activity.this, Main5Activity.class);
                i.putExtra("temperature1",txtJson.getText().toString());
                i.putExtra("humidity1",txtJson1.getText().toString());
                i.putExtra("pressure1",txtJson2.getText().toString());
                i.putExtra("ph1",ph);
                i.putExtra("phosphorous1",phosphorous);
                i.putExtra("potassium1",potassium);
                startActivity(i);
                //Toast.makeText(getApplicationContext(),"Change Threshold value Now",Toast.LENGTH_SHORT).show();
            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Main2Activity.this, Main6Activity.class);
                i.putExtra("temperature2",txtJson.getText().toString());
                i.putExtra("humidity2",txtJson1.getText().toString());

                startActivity(i);
                //Toast.makeText(getApplicationContext(),"Change Threshold value Now",Toast.LENGTH_SHORT).show();
            }
        });








    }


    public void hello()
    {
        new JsonTask().execute("https://thingspeak.com/channels/1635769/field/1/last?api_key=KUWKGSXKWQ5KDXP1");
        new JsonTask1().execute("https://thingspeak.com/channels/1635769/field/2/last?api_key=KUWKGSXKWQ5KDXP1");
        new JsonTask2().execute("https://thingspeak.com/channels/1635769/field/3/last?api_key=KUWKGSXKWQ5KDXP1");
    }





    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(Main2Activity.this);
            pd.setMessage("Please wait");
            pd.setCancelable(false);
            pd.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            a = result;

            txtJson.setText(result);


        }
    }
    private class JsonTask1 extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

//            pd1= new ProgressDialog(Main2Activity.this);
//            pd1.setMessage("Please wait");
//            pd1.setCancelable(false);
//            pd1.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            b=result;
            txtJson1.setText(result);
        }
    }
    private class JsonTask2 extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

//            pd2 = new ProgressDialog(Main2Activity.this);
//            pd2.setMessage("Please wait");
//            pd2.setCancelable(false);
//            pd2.show();
        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd.isShowing()) {
                pd.dismiss();
            }
            c=result;
            txtJson2.setText(result);


        }
    }
}