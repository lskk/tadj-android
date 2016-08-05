package batch9.crayonpedia.tadj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class Index extends AppCompatActivity {
    String email,password;
    Button bSignin;
    EditText tvEmail,tvPassword;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" TADJ");
        toolbar.setLogo(R.mipmap.ic_tadj_bird);
        setSupportActionBar(toolbar);

        tvEmail = (EditText)findViewById(R.id.tvEmail);
        tvPassword = (EditText)findViewById(R.id.tvPassword);

        bSignin = (Button)findViewById(R.id.bSignin);
        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(tvEmail.getText().toString().equals("enroll")){
                    mContext = v.getContext();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.Berita");
                    intent.putExtra("Status","Enroll");
                    v.getContext().startActivity(intent);
                }else{
                    mContext = v.getContext();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.Berita");
                    intent.putExtra("Status","NoEnroll");
                    v.getContext().startActivity(intent);
                }*/
                login_task(v);
            }
        });



    }

    public void login_task(View view){
        email = tvEmail.getText().toString();
        password = tvPassword.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, email, password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent("batch9.crayonpedia.tadj.Copyright");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
