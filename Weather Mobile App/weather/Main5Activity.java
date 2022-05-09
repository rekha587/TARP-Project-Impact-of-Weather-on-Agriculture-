package com.example.weather;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main5Activity extends AppCompatActivity {

    Button b;

    TextView temp,hum,press,ph_value,phos,potassium_value,result;
    EditText nitrogen, rain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b=(Button) findViewById(R.id.predict);
        temp = (TextView) findViewById(R.id.t);
        hum = (TextView) findViewById(R.id.h);
        press = (TextView) findViewById(R.id.textView28);
        ph_value = (TextView) findViewById(R.id.ph);
        phos = (TextView) findViewById(R.id.p);
        potassium_value = (TextView) findViewById(R.id.k);
        result=(TextView) findViewById(R.id.result);

        nitrogen = (EditText) findViewById(R.id.n);
        rain = (EditText) findViewById(R.id.r);

        Intent i=getIntent();
        String temperature=i.getExtras().getString("temperature1");
        String humidity=i.getExtras().getString("humidity1");
        String pressure=i.getExtras().getString("pressure1");
        String ph=i.getExtras().getString("ph1");
        String phosphorous=i.getExtras().getString("phosphorous1");
        String potassium=i.getExtras().getString("potassium1");

//        String rain="100";
//        String nitrogen="40";

        temp.setText(temperature);
        hum.setText(humidity);
        press.setText(pressure);
        ph_value.setText(ph);
        phos.setText(phosphorous);
        potassium_value.setText(potassium);

        String url = "https://tarp-1.herokuapp.com/predict";

        b.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {



                 //hit the API -> Volley
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("placement");
                                    if(data.equals("0"))
                                    {
                                        result.setText("Apple");
                                    }
                                    else if(data.equals("1")){
                                        result.setText("Banana");
                                    }
                                    else if (data.equals("2")){
                                        result.setText("Black Gram");
                                    }
                                    else if (data.equals("3")){
                                        result.setText("Chickpeas");
                                    }
                                    else if (data.equals("4")){
                                        result.setText("Coconut");
                                    }
                                    else if (data.equals("5")){
                                        result.setText("Coffee");
                                    }
                                    else if (data.equals("6")){

                                        result.setText("Cotten");
                                    }
                                    else if (data.equals("7")){

                                        result.setText("grapes");

                                    }
                                    else if (data.equals("8")){
                                        result.setText("Jute");
                                    }
                                    else if (data.equals("9")){
                                        result.setText("Kindey Beans");

                                    }
                                    else if (data.equals("10")){

                                        result.setText("Lentil");

                                    }
                                    else if (data.equals("11")){

                                        result.setText("Maize");
                                    }
                                    else if (data.equals("12")){

                                        result.setText("Mango");

                                    }
                                    else if (data.equals("13")){
                                        result.setText("Moth Beans");
                                    }
                                    else if (data.equals("14")){
                                        result.setText("Moung Beans");
                                    }
                                    else if (data.equals("15")){

                                        result.setText("Musk melon");

                                    }
                                    else if (data.equals("16")){

                                        result.setText("Orange");

                                    }
                                    else if (data.equals("17")){
                                        result.setText("Papaya");
                                    }
                                    else if (data.equals("18")){

                                        result.setText("Pigeon peas");

                                    }
                                    else if (data.equals("19")){

                                        result.setText("Pomegranate");

                                    }
                                    else if (data.equals("20")){
                                        result.setText("Rice");

                                    }
                                    else if (data.equals("21")){

                                        result.setText("Watermelon");

                                    }

                                    else{
                                        result.setText("No crop found");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Main5Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){

                        Map<String,String> params = new HashMap<String,String>();
                        params.put("t",temp.getText().toString());
                        params.put("h",hum.getText().toString());
                        //params.put("p",press.getText().toString());
                        params.put("ph",ph_value.getText().toString());
                        params.put("p",phos.getText().toString());
                        params.put("k",potassium_value.getText().toString());
                        params.put("r",rain.getText().toString());
                        params.put("n",nitrogen.getText().toString());
                        Log.i("temperature",temp.getText().toString());
                        Log.i("humidity",hum.getText().toString());
                        Log.i("ph",ph_value.getText().toString());
//                        Log.i("param",new Gson().toJson(params));


                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(Main5Activity.this);
                queue.add(stringRequest);




            }
  });


    }
}
