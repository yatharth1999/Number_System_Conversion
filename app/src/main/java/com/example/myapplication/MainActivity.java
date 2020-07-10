package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.converter);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.converter_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        final Intent intent1 = new Intent(this,Binary.class);
        final Intent intent2 = new Intent(this,Decimal.class);
        final Intent intent3 = new Intent(this,Octal.class);
        final Intent intent4 = new Intent(this,Hexadecimal.class);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = spinner.getSelectedItem().toString();
                showToast(text);
                if (text.equals("Binary")) {
                    startActivity(intent1);
                }
                else if(text.equals("Decimal")){
                    startActivity(intent2);
                }
                else if(text.equals("Octal")){
                    startActivity(intent3);
                }
                else if(text.equals("Hexadecimal")){
                    startActivity(intent4);
                }
            }
        });
    }


    private void showToast(String text) {

        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
    }

}