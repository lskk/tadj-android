package batch9.crayonpedia.tadj;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import batch9.crayonpedia.tadj.Fragment.TimePickerFragment;

public class LakukanBimbingan extends AppCompatActivity {
    //Date picker
    Calendar calendar = Calendar.getInstance();

    EditText etTanggal;
    Spinner spPembimbing;
    //data dosen pembimbing
    String dosen_pembimbing[] = {"Dr. Ary Setijadi Prihatmanto","Dr. Pranoto Hidaya Rusmin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lakukan_bimbingan);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" Lakukan Bimbingan");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Datepicker callback element
        etTanggal = (EditText)findViewById(R.id.etTanggal);

        //Spinner

        spPembimbing = (Spinner)findViewById(R.id.spPembimbing);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dosen_pembimbing);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPembimbing.setAdapter(spinnerArrayAdapter);
    }

    //Date picker
    public void showTimePickerDialog(View view){
        TimePickerFragment date = new TimePickerFragment();

        Bundle args = new Bundle();
        args.putInt("year", calendar.get(Calendar.YEAR));
        args.putInt("month", calendar.get(Calendar.MONTH));
        args.putInt("day", calendar.get(Calendar.DAY_OF_MONTH));
        date.setArguments(args);
        /**
         * Set Call back to capture selected date
         */
        date.setCallBack(ondate);
        date.show(getFragmentManager(), "Date Picker");
    }

    //Date picker Callback
    DatePickerDialog.OnDateSetListener ondate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            etTanggal.setText(String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear) + "-" + String.valueOf(year));
        }

    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return true;
    }


}
