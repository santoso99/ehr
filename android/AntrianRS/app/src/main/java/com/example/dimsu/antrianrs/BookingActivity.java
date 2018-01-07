package com.example.dimsu.antrianrs;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
//import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.dimsu.antrianrs.Class.Pendaftaran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class BookingActivity extends AppCompatActivity {


    TextView datetime, namapasien, namapoli, namadokter, nomorpendaftaran,noasuransi, jenisasuransi,namars,terimakasih;
    //private String nama_pasien;
    //private String nama_poli;
    //private String nama_dokter;
    //private String no_antrian;
    private String id_pasien2;
    private String nomor_pendaftaran2;
    private String id_pendaftaran2;
    private String id_user2;

    //@RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        namapasien = (TextView) findViewById(R.id.namapasien);
        namapoli = (TextView) findViewById(R.id.namapoli);
        namadokter = (TextView) findViewById(R.id.namadokter);
        nomorpendaftaran = (TextView) findViewById(R.id.noAntrian);
        terimakasih = (TextView) findViewById(R.id.thanks);
        namars = (TextView) findViewById(R.id.namaRS);
        jenisasuransi = (TextView) findViewById(R.id.jnsasuransi);
        noasuransi = (TextView) findViewById(R.id.noasuransi);

        datetime = (TextView) findViewById(R.id.datetime);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        datetime.setText(dateString);

        //Intent intent = getIntent();
        //Bundle extras = intent.getExtras();
        Bundle bundle = getIntent().getExtras();
        //kode_pasien = bundle.getString("kode_pasien");
        //nama_pasien = bundle.getString("nama_pasien");
        //nama_poli = bundle.getString("nama_poli");
        //nama_dokter = bundle.getString("nama_dokter");
        //no_antrian = bundle.getString("no_antrian");

        id_pasien2 = bundle.getString("id_pasien");
        nomor_pendaftaran2 = bundle.getString("nomor_pendaftaran");
        id_pendaftaran2 = bundle.getString("id_pendaftaran");
        id_user2 = bundle.getString("id_user");

        getData();

        //namapoli.setText(nama_poli);
        //namadokter.setText(nama_dokter);
        //noantrian.setText(no_antrian);

        keAwal();

    }

    private void getData(){

        Response.Listener<String> responseListener = new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                //JSONObject jsonResponse = null;
                //boolean error = false;
                try {
                    //jsonResponse = new JSONObject(response);
                    //error = jsonResponse.getBoolean("error");
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean error = jsonResponse.getBoolean("error");

                    if (!error){
                        String id_pendaftaran = (String) jsonResponse.getJSONObject("pendaftaran").getString("id_pendaftaran");
                        String tanggal_pendaftaran = (String) jsonResponse.getJSONObject("pendaftaran").getString("tanggal_pendaftaran");
                        String nomor_pendaftaran = (String) jsonResponse.getJSONObject("pendaftaran").getString("nomor_pendaftaran");
                        String id_pasien = (String) jsonResponse.getJSONObject("pendaftaran").getString("id_pasien");
                        String nama_pasien = (String) jsonResponse.getJSONObject("pendaftaran").getString("nama_pasien");
                        String no_asuransi = (String) jsonResponse.getJSONObject("pendaftaran").getString("no_asuransi");
                        String nama_rs = (String) jsonResponse.getJSONObject("pendaftaran").getString("nama_rs");
                        String nama_poli = (String) jsonResponse.getJSONObject("pendaftaran").getString("nama_poli");
                        String nama_dokter = (String) jsonResponse.getJSONObject("pendaftaran").getString("nama_dokter");
                        String jenis_asuransi = (String) jsonResponse.getJSONObject("pendaftaran").getString("jenis_asuransi");

                        String NamaPas = "Nama Anda : ";
                        String NamaPol = "Poli : ";
                        String NamaDok = "Dokter : ";
                        String NamRS = "Rumah Sakit : ";
                        String JenAs = "Asuransi Anda : ";
                        String NoAs = "Nomor Asuransi : ";

                        namapasien.setText(String.valueOf(NamaPas + nama_pasien));
                        namapoli.setText(String.valueOf(NamaPol + nama_poli));
                        namadokter.setText(String.valueOf(NamaDok + nama_dokter));
                        nomorpendaftaran.setText(nomor_pendaftaran);
                        jenisasuransi.setText(String.valueOf(JenAs + jenis_asuransi));
                        noasuransi.setText(String.valueOf(NoAs + no_asuransi));
                        namars.setText(String.valueOf(NamRS + nama_rs));


                        //inputNamaPoli.setText(String.valueOf(NP + nama_poli));
                        //JSONArray result = new JSONArray(jsonResponse.getString("jenis_asuransi"));
//                        JSONObject result = new JSONObject(response);
//                        JSONArray array = result.getJSONArray("pendaftaran");
//
//                        for(int i=0;i<array.length();i++){
//
//                            JSONObject asObj = array.getJSONObject(i);
//                            String id_pendaftaran = asObj.getString("id_pendaftaran");
//                            String tanggal_pendaftaran = asObj.getString("tanggal_pendaftaran");
//                            String nomor_pendaftaran = asObj.getString("nomor_pendaftaran");
//                            String id_pasien = asObj.getString("id_pasien");
//                            String nama_pasien = asObj.getString("nama_pasien");
//                            String no_asuransi = asObj.getString("no_asuransi");
//                            String nama_rs = asObj.getString("nama_rs");
//                            String nama_poli = asObj.getString("nama_poli");
//                            String nama_dokter = asObj.getString("nama_dokter");
//                            String jenis_asuransi = asObj.getString("jenis_asuransi");


//                            Pendaftaran Daftar = new Pendaftaran(id_pendaftaran,tanggal_pendaftaran,nomor_pendaftaran,id_pasien, nama_pasien, no_asuransi,nama_rs, nama_poli, nama_dokter, jenis_asuransi);
//                            nama_RS.add(Daftar);


                       // }
                        //spinner.setAdapter(new ArrayAdapter<String>(ProfileActivity.this, android.R.layout.simple_spinner_dropdown_item, jenis_asuransi));
                        //spinner.setAdapter(new ArrayAdapter<Asuransi>(ProfileActivity.this, android.R.layout.simple_spinner_dropdown_item, jenis_asuransi));
                        //adapterRS = new RumahSakitSpinner(BerobatActivity.this,android.R.layout.simple_spinner_dropdown_item,nama_RS);
                        //spinnerRS.setAdapter(adapterRS);
                    }
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
            }
        };

        BookingRequest bookingRequest = new BookingRequest(id_pendaftaran2, responseListener);
        RequestQueue queue = Volley.newRequestQueue(BookingActivity.this);
        queue.add(bookingRequest);
    }

    public void keAwal(){
        terimakasih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookingActivity.this,MainActivity.class);
                i.putExtra("id_pasien",id_pasien2);
                i.putExtra("id_user",id_user2);
                startActivity(i);
            }
        });
    }
}
