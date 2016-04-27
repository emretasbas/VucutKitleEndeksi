package com.example.envy_m6.vucutkitleendeksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb1, rb2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()){
                    Intent i = new Intent(getApplicationContext(), ErkekKitleEndeksi.class);
                    startActivity(i);
                }else if (rb2.isChecked()){
                    Intent i = new Intent(getApplicationContext(), KadinKitleEndeksi.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(), "Seçim Yapmadınız.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
