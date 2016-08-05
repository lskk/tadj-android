package batch9.crayonpedia.tadj;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Emilham on 11/26/15.
 */
public class BackgroundTask extends AsyncTask<String,Void,String>{
    Context ctx;
    String json_string;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        //penentu metode
        String method = params[0];

        //url
        String url_login = "http://tadj.lskk.ee.itb.ac.id/api/user/login";
        String response = "";

        if(method.equals("login")){
            String email = params[1];
            String password = params[2];

            try {
                URL url = new URL(url_login);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("email", "UTF-8") +"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8") +"="+URLEncoder.encode(password,"UTF-8");//encode a string using the format required by application/x-www-form-urlencoded MIME content type
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream IS = httpURLConnection.getInputStream();//adapt a byte stream like this one into a character stream
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(IS,"iso-8859-1"));//wraps an existing Reader and buffers the input

                String line = "";
                while((line = bufferedReader.readLine())!=null){
                    response += line;
                }
//                bufferedReader.close();
//                IS.close();
//                httpURLConnection.disconnect();

                return  response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        JSONObject json = null;
        String code = "";
        String message = "";
        String item = "";
        try {
            json = new JSONObject(s);
            code = json.getString("code");
            message = json.getString("msg");
            item = json.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (code.equals("1"))
        {
            Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
            Intent intent = new Intent("batch9.crayonpedia.tadj.Berita");
            intent.putExtra("data_user", item);
            ctx.startActivity(intent);
        }
        else
        {
            Toast.makeText(ctx, message, Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
//        Toast.makeText(ctx, code, Toast.LENGTH_SHORT).show();
//        if(s.equals("username atau password yang anda masukan salah")){
//            //Toast.makeText(ctx, "email atau password yang masukan tidak sesuai", Toast.LENGTH_SHORT).show();
//            Toast.makeText(ctx, "username atau password yang anda masukan salah", Toast.LENGTH_SHORT).show();
//        }else {
//            json_string = s;
//            Intent intent = new Intent("batch9.crayonpedia.tadj.Berita");
//            intent.putExtra("data_user",json_string);//melemparkan data user jika berhasil login
//            ctx.startActivity(intent);
//
//            //Toast.makeText(ctx, "welcome!", Toast.LENGTH_SHORT).show();
//        }
    }

    /*public void json_parse(View view){
        if(json_string == null){
            Toast.makeText(ctx, "email atau password yang masukan tidak sesuai", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent("batch9.crayonpedia.tadj.Berita");
            intent.putExtra("data_user",json_string);//melemparkan data user jika berhasil login
            ctx.startActivity(intent);
        }
    }*/
}
