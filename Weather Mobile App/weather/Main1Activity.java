
//Sign-Up
package com.example.weather;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.os.Bundle;
        import android.accessibilityservice.GestureDescription;
        import android.content.Context;
        import android.content.ContentValues;
        import android.content.DialogInterface;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.Cursor;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.app.AlertDialog.Builder;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.jar.Attributes;
public class Main1Activity extends AppCompatActivity {
    EditText user, password, email, phn;
    String temperature="30",hum="44",press="99252",ph="5",phosphorous="8",potassium="10";
    Button register;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        user = (EditText) findViewById(R.id.editTextTextPersonName2);
        password = (EditText) findViewById(R.id.editTextTextPassword2);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        phn = (EditText) findViewById(R.id.editTextPhone);
        register = (Button) findViewById(R.id.button2);

        db = (SQLiteDatabase) openOrCreateDatabase("UserDB", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS users(username VARCHAR,passwd VARCHAR,emailid VARCHAR,phone VARCHAR,temperature VARCHAR,hum VARCHAR,press VARCHAR,ph VARCHAR,phosphorous VARCHAR,potassium VARCHAR);");

    }

    public void onClick(View view) {
        // Inserting a record to the Student table
        if (view == register) {
            // Checking for empty fields
            if (user.getText().toString().trim().length() == 0 ||
                    password.getText().toString().trim().length() == 0 || email.getText().toString().trim().length() == 0 || phn.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }

            db.execSQL("INSERT INTO users VALUES('" + user.getText() + "','" + password.getText() +
                    "','" + email.getText() + "','" + phn.getText()+ "','" +temperature+"','" + hum + "','" +press+ "','" + ph+ "','" + phosphorous+ "','" + potassium+"');");
            showMessage("Success", "Record added");
            clearText();
            db.close();
        }
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void clearText() {
        user.setText("");
        password.setText("");
        email.setText("");
        phn.setText("");


    }
}