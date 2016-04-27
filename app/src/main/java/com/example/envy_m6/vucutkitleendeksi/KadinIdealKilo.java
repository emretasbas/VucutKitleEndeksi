package com.example.envy_m6.vucutkitleendeksi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by envy-m6 on 27.4.2016.
 */
public class KadinIdealKilo extends Activity {
    EditText et;
    Button btn;
    TextView tv;
    double boy, sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ik_kadin);

        et = (EditText)findViewById(R.id.editIKK);
        btn = (Button)findViewById(R.id.btnHesapIKK);
        tv = (TextView)findViewById(R.id.textIKK);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringBoy = et.getText().toString();
                if (stringBoy.matches("")){
                    Toast.makeText(getApplicationContext(), "Boş Bırakılamaz!", Toast.LENGTH_SHORT).show();
                }else {
                    boy = Double.parseDouble(stringBoy);
                    sonuc = (45.5 + 2.3*(0.394*boy - 60));
                    BigDecimal bg = new BigDecimal(sonuc);
                    bg = bg.setScale(2, RoundingMode.HALF_UP);
                    tv.setText("İdeal Kilonuz: " + bg);
                }
            }
        });
    }
}
