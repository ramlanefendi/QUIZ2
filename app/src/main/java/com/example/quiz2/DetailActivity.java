package com.example.quiz2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


public class DetailActivity extends AppCompatActivity {

    private TextView tvIphone, tvTambahan, tvLamaRental, tvTotalHarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil);

        tvIphone = findViewById(R.id.tvIphone);
        tvTambahan = findViewById(R.id.tvTambahan);
        tvLamaRental = findViewById(R.id.tvLamaRental);
        tvTotalHarga = findViewById(R.id.tvTotalHarga);

        Intent intent = getIntent();
        String iphone = intent.getStringExtra("IPHONE");
        String tambahan = intent.getStringExtra("TAMBAHAN");
        int lamaRental = intent.getIntExtra("LAMA_RENTAL", 0);
        int totalHarga = intent.getIntExtra("TOTAL_HARGA", 0);

        tvIphone.setText(iphone);
        tvTambahan.setText(tambahan);
        tvLamaRental.setText(lamaRental + " Hari");
        tvTotalHarga.setText("RP. " + totalHarga);
    }
}