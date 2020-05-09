package com.example.projectfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class bookActivity extends AppCompatActivity {
    String[] nama={
            "X-Treme Futsal",
            "Planet Futsal",
            "Champion Futsal",
            "Pro Futsal"
        };
    int[] gambar={
            R.drawable.extreme,
            R.drawable.planet,
            R.drawable.champion,
            R.drawable.pro
        };
    String[] lokasiMaps={
            "https://www.google.com/maps/place/X+-+Tream+Futsal/@-6.9399831,109.5459615,12z/data=!4m8!1m2!2m1!1stempat+futsal+di+pekalongan!3m4!1s0x0:0xd96abffdea084908!8m2!3d-6.9239346!4d109.6790457",
            "https://www.google.com/maps/place/Planet+Futsal+Pekalongan/@-6.939632,109.5459613,12z/data=!4m8!1m2!2m1!1stempat+futsal+di+pekalongan!3m4!1s0x2e7024175ed8895b:0xc2a931a51b7d732b!8m2!3d-6.9104102!4d109.6760248",
            "https://www.google.com/maps/place/Futsal+Champion/@-6.9399831,109.5459615,12z/data=!4m8!1m2!2m1!1stempat+futsal+di+pekalongan!3m4!1s0x0:0x8e49270fe39a81b4!8m2!3d-6.8789018!4d109.6830368",
            "https://goo.gl/maps/wNxXdd3TYziko2Am6"
        };
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        list=findViewById(R.id.listview);
        customAdapter myAdapter=new customAdapter();
        list.setAdapter(myAdapter);
    }

    private class customAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return nama.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.row_list,null);

            TextView name=convertView.findViewById(R.id.nama);
            ImageView gmbr=convertView.findViewById(R.id.image);
            Button lokasi=convertView.findViewById(R.id.lokasi);

            name.setText(nama[position]);
            gmbr.setImageResource(gambar[position]);


            lokasi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent b=new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse(lokasiMaps[position]));
                    startActivity(b);
                }
            });
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent y=new Intent(getApplicationContext(),jadwalActivity.class);
                    startActivity(y);
                }
            });
            return convertView;
        }
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
