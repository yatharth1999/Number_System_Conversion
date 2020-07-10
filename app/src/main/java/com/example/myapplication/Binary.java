package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Binary extends AppCompatActivity {
    private Button button;
    TextView text,text1,text2;
    EditText binary;
    int m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        text = findViewById(R.id.textView3);
        text1 = findViewById(R.id.textView5);
        text2 = findViewById(R.id.textView2);
        binary = (EditText) findViewById(R.id.bin);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean numeric = true;

                try {
                    m = Integer.parseInt(binary.getText().toString(),2);
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                if(numeric)
                {
                    String a=binary.getText().toString();
                    binarytodecimal(a);

                }
                else
                {

                    showToast("not a binary number");
                }



            }
        });
    }
    private void binarytodecimal(String a){
        int n = Integer.parseInt(binary.getText().toString(),2);
        binarytooctal(n);
        binarytohex(n);
        text.setText(String.valueOf(n));
    }
    private void binarytooctal(int decimal){
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
        text1.setText(octal);
    }
    private void binarytohex(int decimal){
        int rem;
        String hex="";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            rem=decimal%16;
            hex=hexchars[rem]+hex;
            decimal=decimal/16;
        }
        text2.setText(hex);

    }
    private void showToast(String text) {

        Toast.makeText(Binary.this, text, Toast.LENGTH_LONG).show();
    }
}