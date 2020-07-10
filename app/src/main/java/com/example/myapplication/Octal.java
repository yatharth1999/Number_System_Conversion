package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Octal extends AppCompatActivity {
    private Button buttonx;
    TextView te,te1,te2;
    EditText bi;
    int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal);
        te = findViewById(R.id.o2b);
        te1 = findViewById(R.id.o2d);
        te2 = findViewById(R.id.o2h);
        bi = (EditText) findViewById(R.id.oct);
        buttonx = (Button) findViewById(R.id.butt);
        buttonx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean numeric = true;

                try {
                    m = Integer.parseInt(bi.getText().toString(),8);
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                if(numeric)
                {
                    String a=bi.getText().toString();
                    binarytodecimal(Integer.parseInt(a));

                }
                else
                {

                    showToast("not a Octal number");
                }



            }
        });
    }
    private void binarytodecimal(int octal){
        int decimal = 0;
        //Declaring variable to use in power
        int n = 0;
        //writing logic
        while(true){
            if(octal == 0){
                break;
            } else {
                int temp = octal%10;
                decimal += temp*Math.pow(8, n);
                octal = octal/10;
                n++;
            }
        }
        binarytooctal(decimal);
        binarytohex(decimal);
        te1.setText(String.valueOf(decimal));
    }
    private void binarytooctal(int decimal){
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
        te.setText(b);

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
        te2.setText(hex);

    }
    private void showToast(String text) {

        Toast.makeText(Octal.this, text, Toast.LENGTH_LONG).show();
    }
}