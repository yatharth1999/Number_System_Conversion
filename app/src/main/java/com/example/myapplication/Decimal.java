package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decimal extends AppCompatActivity {

    private Button button1;
    TextView text4,text5,text6;
    EditText dec;
    int g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal);
        text4 = findViewById(R.id.btod);
        text5 = findViewById(R.id.btoo);
        text6 = findViewById(R.id.d2h);
        dec = (EditText) findViewById(R.id.Decimal);
        button1 = (Button) findViewById(R.id.but);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean numeric = true;

                try {
                    g = Integer.parseInt(dec.getText().toString(),10);
                } catch (NumberFormatException e) {
                    numeric = false;
                }
                if(numeric)
                {
                    int a=Integer.parseInt(dec.getText().toString());
                    decimaltobinary(a);
                    decimaltohex(a);
                    Decimaltooctal(a);

                }
                else
                {

                    showToast("not a Decimal number");
                }



            }
        });
    }
    private void decimaltobinary(int decimal){
        int binary[] = new int[40];
        int index = 0;
        String b="";
        while(decimal > 0){
            binary[index++] = decimal%2;
            decimal = decimal/2;
        }
        for(int i = index-1;i >= 0;i--){
            b=b+binary[i];
        }
        text4.setText(b);
    }
    private void Decimaltooctal(int decimal){
        int rem; //declaring variable to store remainder
        String octal=""; //declareing variable to store octal
        //declaring array of octal numbers
        char octalchars[]={'0','1','2','3','4','5','6','7'};
        //writing logic of decimal to octal conversion
        while(decimal>0)
        {
            rem=decimal%8;
            octal=octalchars[rem]+octal;
            decimal=decimal/8;
        }
        text5.setText(octal);
    }
    private void decimaltohex(int decimal){
        int rem;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            rem=decimal%16;
            hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        text6.setText(hex);

    }
    private void showToast(String text) {

        Toast.makeText(Decimal.this, text, Toast.LENGTH_LONG).show();
    }
}