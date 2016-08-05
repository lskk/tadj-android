package batch9.crayonpedia.tadj;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import batch9.crayonpedia.tadj.Adapter.BeritaAdapter;
import batch9.crayonpedia.tadj.Adapter.ListTugasAkhirAdapter;
import batch9.crayonpedia.tadj.Adapter.PengajuanJudulAdapter;

public class Berita extends AppCompatActivity {
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String name,email,photo_url;
    //FAB
    FloatingActionButton fab;

    //Navigation Drawer
    private static final String TAG = "MyActivity";
    PrimaryDrawerItem item1,item2,item3,item4,item5;

    //Recycle View
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Data Berita
    protected String[] dataSetJudul = {"Format Laporan Tugas Akhir Tahun Ajaran 2014", "Format Laporan Tugas Akhir Tahun Ajaran 2015", "Format Laporan Tugas Akhir Tahun Ajaran 2014", "Format Laporan Tugas Akhir Tahun Ajaran 2015", "Format Laporan Tugas Akhir Tahun Ajaran 2014", "Format Laporan Tugas Akhir Tahun Ajaran 2015", "Format Laporan Tugas Akhir Tahun Ajaran 2014", "Format Laporan Tugas Akhir Tahun Ajaran 2015", "Format Laporan Tugas Akhir Tahun Ajaran 2014", "Format Laporan Tugas Akhir Tahun Ajaran 2015"};
    protected String[] dataSetDate = {"dipublikasikan pada 2 Desember 2015", "dipublikasikan pada 1 Desember 2014", "dipublikasikan pada 2 Desember 2015", "dipublikasikan pada 1 Desember 2014", "dipublikasikan pada 2 Desember 2015", "dipublikasikan pada 1 Desember 2014", "dipublikasikan pada 2 Desember 2015", "dipublikasikan pada 1 Desember 2014", "dipublikasikan pada 2 Desember 2015", "dipublikasikan pada 1 Desember 2014"};

    //Data List Tugas Akhir
    protected String[] dataSetJudul2 = {"Judul TA 1", "Judul TA 2", "Judul TA 3", "Judul TA 4", "Judul TA 5", "Judul TA 6", "Judul TA 7", "Judul TA 8", "Judul TA 9", "Judul TA 10"};
    protected int[] dataSetCover = {R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small, R.drawable.bg_4_small};

    //Data List Pengajuan Judul
    protected String[] dataSetJudulPengajuan = {"Crayonpedia Education System","Integrated Education"};
    protected String[] dataSetStatusPengajuan = {"Diterima","Dalam Proses Pengecekan"};

    //Swipe Refresh
    SwipeRefreshLayout swipeRefreshLayout;

    //--Data--
    //email
    List<String> listEmail = new ArrayList<String>();
    List<String> listName = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //Data processing
        json_string = getIntent().getExtras().getString("data_user");
        Toast.makeText(this, json_string, Toast.LENGTH_LONG).show();
        try {
            jsonObject = new JSONObject(json_string);

//            jsonArray = jsonObject.getJSONArray("user_personality");
            int count = 0;
            name = jsonObject.getString("NAMA");
            email = jsonObject.getString("EMAIL");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //data set to each index if need
        /*eachEmail = new String[listEmail.size()];
        listEmail.toArray(eachEmail);*/

        //General

        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Berita");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);
        //End of Toolbar

        //Swipe Refresh Layout
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);

        //End of Swipe Refresh Layout

        //Recycle View

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Adapter Recycle View
        mAdapter = new BeritaAdapter(dataSetJudul, dataSetDate);
        mRecyclerView.setAdapter(mAdapter);

        //End of recycle View

        //FAB

        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent("batch9.crayonpedia.tadj.PengajuanJudulTugasAkhir");
                startActivity(intent);
            }
        });

//        Toast.makeText(this,"Email: "+listEmail.get(0),Toast.LENGTH_LONG).show();
        //Navigation Drawer
        new DrawerBuilder().withActivity(this).build();

        Drawer result = null;
        item1 = new PrimaryDrawerItem().withName("Berita").withIcon(R.mipmap.ic_info_black_48dp).withBadge("5").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.colorAccent));
        item2 = new PrimaryDrawerItem().withName("List Tugas Akhir").withIcon(R.mipmap.ic_list_black_48dp).withBadge("2").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.colorAccent));
        item3 = new PrimaryDrawerItem().withName("Bimbingan").withIcon(R.mipmap.ic_supervisor_account_black_48dp).withBadge("3").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.colorAccent));
        item4 = new PrimaryDrawerItem().withName("Keluar").withIcon(R.mipmap.ic_keyboard_arrow_left_black_48dp);
        item5 = new PrimaryDrawerItem().withName("Ajukan Judul").withIcon(R.mipmap.ic_create_black_48dp);

        //Account Header
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.tadj_drawer)
                .addProfiles(
                        new ProfileDrawerItem().withName(name).withEmail(email).withIcon(getResources().getDrawable(R.drawable.profile_picture))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //Body Navigatiodn
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withToolbar(toolbar)
                .withSelectedItem(-1)
                .addDrawerItems(
                        item1,
                        item2,
                        item3,
                        item5,
                        new DividerDrawerItem(),
                        item4
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D

                        switch (position) {
                            case 1:
                                fab.setVisibility(View.INVISIBLE);
                                item1.withName("Berita").withIcon(R.mipmap.ic_info_black_48dp).withBadge("0").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_white_1000));
                                toolbar.setTitle(" Berita");
                                mAdapter = new BeritaAdapter(dataSetJudul, dataSetDate);
                                mRecyclerView.setAdapter(mAdapter);
                                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                    @Override
                                    public void onRefresh() {
                                        refreshBerita();
                                    }
                                });
                                break;
                            case 2:
                                fab.setVisibility(View.INVISIBLE);
                                item2.withName("List Tugas Akhir").withIcon(R.mipmap.ic_list_black_48dp).withBadge("0").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_white_1000));
                                toolbar.setTitle(" List Tugas Akhir");
                                mAdapter = new ListTugasAkhirAdapter(dataSetJudul2, dataSetCover);
                                mRecyclerView.setAdapter(mAdapter);
                                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                                    @Override
                                    public void onRefresh() {
                                        refreshListTugasAkhir();
                                    }
                                });
                                break;
                            case 3:
                                fab.setVisibility(View.INVISIBLE);
                                item3.withName("Bimbingan").withIcon(R.mipmap.ic_supervisor_account_black_48dp).withBadge("0").withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_white_1000));

                                    toolbar.setTitle(" Ambil Tugas Akhir");
                                    mAdapter = new ListTugasAkhirAdapter(dataSetJudul2, dataSetCover);
                                    mRecyclerView.setAdapter(mAdapter);

                                break;
                            case 4:
                                toolbar.setTitle(" Judul Yang Diajukan");
                                mAdapter = new PengajuanJudulAdapter(dataSetJudulPengajuan,dataSetStatusPengajuan);
                                mRecyclerView.setAdapter(mAdapter);
                                fab.setVisibility(View.VISIBLE);
                                break;
                            case 6:
                                finish();
                                break;
                        }
                        return false;
                    }
                })
                .build();

        //End of Navigation Drawer


    }

    private void refreshBerita() {
        mAdapter = new BeritaAdapter(dataSetJudul, dataSetDate);
        mRecyclerView.setAdapter(mAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    private void refreshListTugasAkhir() {
        mAdapter = new ListTugasAkhirAdapter(dataSetJudul2, dataSetCover);
        mRecyclerView.setAdapter(mAdapter);
        swipeRefreshLayout.setRefreshing(false);
    }

    public void showConfirmationDialog(){
        Toast.makeText(this, "Show Confirmation Now", Toast.LENGTH_SHORT).show();
    }
}
