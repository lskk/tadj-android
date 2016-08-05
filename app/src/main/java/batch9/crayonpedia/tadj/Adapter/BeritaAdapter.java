package batch9.crayonpedia.tadj.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import batch9.crayonpedia.tadj.R;

/**
 * Created by Emilham on 11/23/15.
 */
public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private String[] dataSetJudul,dataSetDate;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvJudul,tvDate;
        public Context mContext;
        public ViewHolder(View v) {
            super(v);
            tvJudul = (TextView)v.findViewById(R.id.judul);
            tvDate = (TextView)v.findViewById(R.id.date);

            //Click Event
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext = v.getContext();
                    //Toast.makeText(v.getContext(),"Test",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.BeritaDetail");
                    intent.putExtra("Judul","Laporan Tugas Akhir 2015");
                    v.getContext().startActivity(intent);
                }
            });
        }

        /*public TextView getTextView() {
            return tvJudul;
        }*/
    }

    public BeritaAdapter(String[] dataSet1,String[] dataSet2) {
        this.dataSetJudul = dataSet1;
        this.dataSetDate = dataSet2;
    }

    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_berita, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BeritaAdapter.ViewHolder holder, int position) {
        holder.tvJudul.setText(dataSetJudul[position]);
        holder.tvDate.setText(dataSetDate[position]);
    }

    @Override
    public int getItemCount() {
        return dataSetJudul.length;
    }
}
