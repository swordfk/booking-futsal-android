package com.example.projectfutsal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class jadwalActivity extends AppCompatActivity {
    String[] jadwal={
            "10.00 - 11.00",
            "11.00 - 12.00",
            "12.00 - 13.00",
            "13.00 - 14.00",
            "14.00 - 15.00",
            "15.00 - 16.00",
            "16.00 - 17.00",
            "17.00 - 18.00",
            "18.00 - 19.00",
            "19.00 - 20.00",
            "20.00 - 21.00",
            "21.00 - 22.00",
            "22.00 - 23.00",
            "23.00 - 24.00",
            "24.00 - 01.00"
        };
    String[] tarif={
            "80.000",
            "80.000",
            "80.000",
            "80.000",
            "80.000",
            "80.000",
            "80.000",
            "80.000",
            "120.000",
            "120.000",
            "120.000",
            "120.000",
            "120.000",
            "120.000",
            "120.000"
        };
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        listview=findViewById(R.id.listView);
        jadwalAdapter meAdap=new jadwalAdapter();
        listview.setAdapter(meAdap);
    }

    private class jadwalAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return jadwal.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.list_tarif,null);
            TextView jam=convertView.findViewById(R.id.jam);
            TextView trf=convertView.findViewById(R.id.harga);

            jam.setText(jadwal[position]);
            trf.setText(tarif[position]);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                            jadwalActivity.this);

// Setting Dialog Title
                    alertDialog2.setTitle("Konfirmasi Booking");

// Setting Dialog Message
                    alertDialog2.setMessage("Booking jam "+jadwal[position]+" ?");

// Setting Positive "Yes" Btn
                    final String jadwal1=jadwal[position];
                    final String tarif1=tarif[position];
                    alertDialog2.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to execute after dialog
                                    Intent x=new Intent(getApplicationContext(), detailActivity.class);
                                    x.putExtra("jadwal1", jadwal1);
                                    x.putExtra("bayar1", tarif1);
                                    startActivity(x);
                                }
                            });

// Setting Negative "NO" Btn
                    alertDialog2.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

// Showing Alert Dialog
                    alertDialog2.show();

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
