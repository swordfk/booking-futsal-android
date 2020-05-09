package com.example.projectfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class detailActivity extends AppCompatActivity {
    EditText jadwalPilih,ttlBayar;
    EditText namaPel,noPel;
    Button booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        jadwalPilih=findViewById(R.id.jamP);
        ttlBayar=findViewById(R.id.bayarP);
        namaPel=findViewById(R.id.namaP);
        noPel=findViewById(R.id.nomerhp);

        Intent z=getIntent();
        String jamPilih=z.getStringExtra("jadwal1");
        String bayarPilih=z.getStringExtra("bayar1");

        jadwalPilih.setText(jamPilih);
        ttlBayar.setText(bayarPilih);

        booking=findViewById(R.id.book);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dapatNama=namaPel.getText().toString().trim();
                String dapatNohp=noPel.getText().toString().trim();

                boolean isEmpityFields=false;

                if (TextUtils.isEmpty(dapatNama)){
                    isEmpityFields=true;
                    namaPel.setError("Harus di isi yahh");
                }
                if (TextUtils.isEmpty(dapatNohp)){
                    isEmpityFields=true;
                    noPel.setError("Harus di isi yahh");
                }
                if (!isEmpityFields){
                    Intent o=new Intent(getApplicationContext(),loadingBook.class);
                    startActivity(o);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_kontak:
                Uri uri = Uri.parse("smsto:0823111229988");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", "Saya ingin menanyakan tentang FUTSAL PEDIA");
                startActivity(it);
                break;
        }
    }
}
