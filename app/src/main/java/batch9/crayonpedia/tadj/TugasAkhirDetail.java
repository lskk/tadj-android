package batch9.crayonpedia.tadj;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class TugasAkhirDetail extends AppCompatActivity {
    VideoView videoView;
    Button btEnrollTugasAkhir;
    TextView tvKuota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_akhir_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Judul Tugas Akhir");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btEnrollTugasAkhir = (Button)findViewById(R.id.btEnrollTugasAkhir);
        tvKuota = (TextView)findViewById(R.id.tvKuota);

        if(getIntent().getExtras().getString("Status").equals("Enroll")){
            btEnrollTugasAkhir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(),"Enroll?",Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Peringatan")
                            .setMessage("Apakah anda yakin akan mengambil judul Tugas Akhir ini? Hanya bisa memilih satu kali saja.")
                            .setIcon(R.mipmap.ic_report_problem_black_48dp)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //Toast.makeText(this, "Yaay", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent("batch9.crayonpedia.tadj.Bimbingan");
                                    startActivity(intent);
                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }
            });
        }else{
            btEnrollTugasAkhir.setVisibility(View.INVISIBLE);
            tvKuota.setVisibility(View.INVISIBLE);
        }



        //Playing Video
        videoView = (VideoView)findViewById(R.id.tvVideo);
        videoView.setVideoPath("http://www.w3schools.com/html/mov_bbb.mp4");
        videoView.start();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
