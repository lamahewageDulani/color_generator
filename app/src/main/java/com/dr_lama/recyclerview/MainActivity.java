package com.dr_lama.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText red;
    EditText blue;
    EditText green;
    LinearLayout layout;
    Button generate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (EditText) findViewById(R.id.et_red);
        blue = (EditText) findViewById(R.id.et_blue);
        green = (EditText) findViewById(R.id.et_green);
        layout = (LinearLayout) findViewById(R.id.main_layout);
        generate = (Button) findViewById(R.id.btn_generate);
    }

    public void generateColor (View view) {
        int redColor = Integer.parseInt(red.getText().toString());
        int blueColor = Integer.parseInt(blue.getText().toString());
        int greenColor = Integer.parseInt(green.getText().toString());
        String toastMsg = "";
        boolean validated = true;
        if (redColor > 255) {
            toastMsg += " Red ";
            validated = false;
        }
        if (greenColor > 255) {
            toastMsg += " Green ";
            validated = false;
        }
        if (blueColor > 255) {
            toastMsg += " Blue ";
            validated = false;
        }
        if (validated) {
            int color = Color.argb(255, redColor, greenColor, blueColor);
            layout.setBackgroundColor(color);
        } else {
            Toast.makeText(this, toastMsg + " not in range", Toast.LENGTH_SHORT).show();
        }
    }
}