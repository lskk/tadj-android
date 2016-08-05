package batch9.crayonpedia.tadj;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import batch9.crayonpedia.tadj.Adapter.BeritaAdapter;
import batch9.crayonpedia.tadj.Adapter.BimbinganAdapter;

public class Bimbingan extends AppCompatActivity {
    //Recycle View
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Data Recycle View Bimbingan
    protected String[] dataTanggal = {"3-12-2015","2-12-2015"};
    protected String[] dataPembimbing = {"Dr. Ary Setijadi Prihatmanto","Dr. Pranoto Hidaya Rusmin"};
    protected String[] dataPermasalahan = {"User Interface Mobile TADJ","Diagram Flow Chart"};
    protected String[] dataSolusi = {"Sudah cukup user friendly.","pada diagram nya perlu ditambahkan suatu penjelasan."};
    protected String[] dataStatus = {"Diterima","Diterima"};
    protected int[] dataSetPembimbing = {R.drawable.dr_ary,R.drawable.dr_pranoto};

    //FAB
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bimbingan);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Bimbingan");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //End of toolbar

        //Recycle View
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Adapter Recycle View
        mAdapter = new BimbinganAdapter(dataTanggal,dataPembimbing,dataPermasalahan,dataSolusi,dataStatus,dataSetPembimbing);
        mRecyclerView.setAdapter(mAdapter);
        //End of Recycle View

        //Floating Action Button
        final View fab_bimbingan = findViewById(R.id.action_d);
        final View fab_ubah_deskripsi = findViewById(R.id.action_c);
        final View fab_ubah_video_produk_tugas_akhir = findViewById(R.id.action_b);
        final View fab_ubah_sampul_gambar_tugas_akhir = findViewById(R.id.action_a);

        fab_bimbingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("batch9.crayonpedia.tadj.LakukanBimbingan");
                startActivity(intent);
            }
        });

        fab_ubah_deskripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("batch9.crayonpedia.tadj.UbahDeskripsiTugasAkhir");
                startActivity(intent);
            }
        });

        fab_ubah_video_produk_tugas_akhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("batch9.crayonpedia.tadj.UbahVideoProdukTugasAkhir");
                startActivity(intent);
            }
        });

        fab_ubah_sampul_gambar_tugas_akhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //batch9.crayonpedia.tadj.UbahSampulGambarTugasAkhir
                Intent intent = new Intent("batch9.crayonpedia.tadj.UbahSampulGambarTugasAkhir");
                startActivity(intent);
            }
        });

        //FAB
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*com.getbase.floatingactionbutton.FloatingActionButton actionC = new com.getbase.floatingactionbutton.FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        menuMultipleActions.addButton(actionC);*/
        //End of floating action button

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if(i == android.R.id.home){
            finish();
        }
        return true;
    }
}
