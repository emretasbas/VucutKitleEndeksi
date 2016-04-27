package com.example.envy_m6.vucutkitleendeksi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by envy-m6 on 26.4.2016.
 */
public class ErkekKitleEndeksi extends Activity {
    EditText et1, et2;
    Button btn1, btn2;
    TextView tv, tvSonuc;
    double vke, boy, mBoy, agirlik;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vke_erkek);

        et1 = (EditText)findViewById(R.id.editVKEE1);
        et2 = (EditText)findViewById(R.id.editVKEE2);
        btn1 = (Button)findViewById(R.id.btnVKEE);
        btn2 = (Button)findViewById(R.id.btnIKE);
        tv = (TextView)findViewById(R.id.textVKEE);
        tvSonuc = (TextView)findViewById(R.id.textSonuc);

        btn2.setEnabled(false);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringBoy = et1.getText().toString();
                String stringAgirlik = et2.getText().toString();
                if (stringBoy.matches("") || stringAgirlik.matches("")) {
                    Toast.makeText(getApplicationContext(), "Boş Bırakılamaz!", Toast.LENGTH_SHORT).show();
                } else {
                    boy = Double.parseDouble(stringBoy);
                    agirlik = Double.parseDouble(stringAgirlik);
                    mBoy = boy / 100;
                    vke = agirlik / (mBoy * mBoy);
                    BigDecimal bg = new BigDecimal(vke);
                    bg = bg.setScale(2, RoundingMode.HALF_UP);
                    tvSonuc.setText("" + bg);
                    btn2.setEnabled(true);
                    Toast.makeText(getApplicationContext(), "İdeal Kilonuzu Öğrenebilirsiniz.", Toast.LENGTH_SHORT).show();
                }

                if (0 < vke && vke <= 18.4) {
                    tv.setText("Zayıf!\n" +
                            "Boyunuza göre uygun ağırlıkta olmadığınızı, " +
                            "zayıf olduğunuzu gösterir. " +
                            "Zayıflık, bazı hastalıklar için risk oluşturan ve istenmeyen bir durumdur. " +
                            "Boyunuza uygun ağırlığa erişmeniz için yeterli ve dengeli beslenmeli, " +
                            "beslenme alışkanlıklarınızı geliştirmeye özen göstermelisiniz.");
                } else if (18.4 < vke && vke <= 24.9) {
                    tv.setText("Normal!\n" +
                            "Boyunuza göre uygun ağırlıkta olduğunuzu gösterir. " +
                            "Yeterli ve dengeli beslenerek ve " +
                            "düzenli fiziksel aktivite yaparak bu ağırlığınızı korumaya özen gösteriniz.");
                } else if (24.9 < vke && vke <= 29.9) {
                    tv.setText("Fazla Kilolu!\n" +
                            "Boyunuza göre vücut ağırlığınızın fazla olduğunu gösterir. " +
                            "Fazla kilolu olma durumu gerekli önlemler alınmadığı takdirde " +
                            "pek çok hastalık için risk faktörü olan obeziteye (şişmanlık) yol açar.");
                } else if (29.9 < vke && vke <= 34.9) {
                    tv.setText("Şişman (Obez)! - I. Sınıf\n" +
                            "Boyunuza göre vücut ağırlığınızın fazla olduğunu " +
                            "bir başka deyişle şişman olduğunuzun bir göstergesidir. " +
                            "Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. " +
                            "kronik hastalıklar için risk faktörüdür. " +
                            "Bir sağlık kuruluşuna başvurarak hekim / diyetisyen kontrolünde " +
                            "zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. " +
                            "Lütfen, sağlık kuruluşuna başvurunuz.");
                } else if (34.9 < vke && vke <= 44.9) {
                    tv.setText("Şişman (Obez)! - II. Sınıf\n" +
                            "Boyunuza göre vücut ağırlığınızın fazla olduğunu " +
                            "bir başka deyişle şişman olduğunuzun bir göstergesidir. " +
                            "Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. " +
                            "kronik hastalıklar için risk faktörüdür. " +
                            "Bir sağlık kuruluşuna başvurarak hekim / diyetisyen kontrolünde " +
                            "zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. " +
                            "Lütfen, sağlık kuruluşuna başvurunuz.");
                } else if (vke > 44.9) {
                    tv.setText("Aşırı Şişman (Aşırı Obez)! - III. Sınıf\n" +
                            "Boyunuza göre vücut ağırlığınızın fazla olduğunu " +
                            "bir başka deyişle şişman olduğunuzun bir göstergesidir. " +
                            "Şişmanlık, kalp-damar hastalıkları, diyabet, hipertansiyon v.b. " +
                            "kronik hastalıklar için risk faktörüdür. " +
                            "Bir sağlık kuruluşuna başvurarak hekim / diyetisyen kontrolünde " +
                            "zayıflayarak normal ağırlığa inmeniz sağlığınız açısından çok önemlidir. " +
                            "Lütfen, sağlık kuruluşuna başvurunuz.");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ErkekIdealKilo.class);
                startActivity(i);
            }
        });

    }
}
