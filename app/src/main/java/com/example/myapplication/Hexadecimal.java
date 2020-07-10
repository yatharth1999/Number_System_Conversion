package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Hexadecimal extends AppCompatActivity {
    private Button buttonx;
    TextView te,te1,te2;
    EditText bi;
    int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexadecimal);
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
                    m = Integer.parseInt(bi.getText().toString(),16);
                } catch (NumberFormatException e) {
                    numeric = false;
                }

                if(numeric)
                {
                    String a=bi.getText().toString();
                    binarytodecimal(a);

                }
                else
                {

                    showToast("not a Hexadecimal number");
                }



            }
        });
    }
    private void binarytodecimal(String hex){
        int decimal=Integer.parseInt(hex,16);
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
        te2.setText(octal);

    }
    private void showToast(String text) {

        Toast.makeText(Hexadecimal.this, text, Toast.LENGTH_LONG).show();
    }
}