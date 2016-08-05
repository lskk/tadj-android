package batch9.crayonpedia.tadj;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PengajuanJudulTugasAkhir extends AppCompatActivity {
    Spinner spUniversitas,spJurusan,spDosenPembimbing,spTahun;
    //data spinner
    String universitas[] = {"Institut Teknologi Bandung","Universitas Padjajaran"};
    String jurusan[] = {"TKJMD","Teknik Informatika"};
    String dosen_pembimbing[] = {"Dr. Ary Setijadi Prihatmanto","Dr. Pranoto Hidaya Rusmin"};
    String tahun[] = {"2014","2015"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengajuan_judul_tugas_akhir);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Pengajuan Judul Tugas Akhir");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Spinner
        spUniversitas = (Spinner)findViewById(R.id.spUniversitas);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,universitas);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUniversitas.setAdapter(spinnerArrayAdapter);

        spDosenPembimbing = (Spinner)findViewById(R.id.spDosenPembimbing);
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dosen_pembimbing);
        spinnerArrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDosenPembimbing.setAdapter(spinnerArrayAdapter2);

        spJurusan = (Spinner)findViewById(R.id.spJurusan);
        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,jurusan);
        spinnerArrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJurusan.setAdapter(spinnerArrayAdapter3);

        spTahun = (Spinner)findViewById(R.id.spTahun);
        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tahun);
        spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTahun.setAdapter(spinnerArrayAdapter4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

}
