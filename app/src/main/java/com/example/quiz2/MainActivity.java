package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgIphone, rgTambahan1, rgTambahan2;
    private EditText etHariRental;
    private Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgIphone = findViewById(R.id.rgIphone);
        rgTambahan1 = findViewById(R.id.rgTambahan1);
        rgTambahan2 = findViewById(R.id.rgTambahan2);
        etHariRental = findViewById(R.id.etHariRental);
        btnProses = findViewById(R.id.btnProses);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedIphoneId = rgIphone.getCheckedRadioButtonId();
                RadioButton selectedIphone = findViewById(selectedIphoneId);
                String iphone = selectedIphone.getText().toString();

                String tambahan = "";
                if (rgTambahan1.getCheckedRadioButtonId() != -1) {
                    tambahan += ((RadioButton) findViewById(rgTambahan1.getCheckedRadioButtonId())).getText().toString() + " ";
                }
                if (rgTambahan2.getCheckedRadioButtonId() != -1) {
                    tambahan += ((RadioButton) findViewById(rgTambahan2.getCheckedRadioButtonId())).getText().toString();
                }

                String hariRentalStr = etHariRental.getText().toString();
                int hariRental = Integer.parseInt(hariRentalStr.isEmpty() ? "0" : hariRentalStr);

                int hargaIphone = 0;
                switch (iphone) {
                    case "iPhone 15 Pro Max":
                        hargaIphone = 300000;
                        break;
                    case "iPhone 15 Pro":
                        hargaIphone = 280000;
                        break;
                    case "iPhone 14 Pro Max":
                        hargaIphone = 250000;
                        break;
                    case "iPhone 14 Pro":
                        hargaIphone = 200000;
                        break;
                    case "iPhone 13 Pro Max":
                        hargaIphone = 100000;
                        break;
                }

                int hargaTambahan = 0;
                if (tambahan.contains("Air Pods")) {
                    hargaTambahan += 20000;
                }
                if (tambahan.contains("Casing")) {
                    hargaTambahan += 10000;
                }

                int totalHarga = (hargaIphone + hargaTambahan) * hariRental;

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("IPHONE", iphone);
                intent.putExtra("TAMBAHAN", tambahan);
                intent.putExtra("LAMA_RENTAL", hariRental);
                intent.putExtra("TOTAL_HARGA", totalHarga);
                startActivity(intent);
            }
        });
    }
}