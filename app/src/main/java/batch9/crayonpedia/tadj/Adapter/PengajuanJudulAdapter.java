package batch9.crayonpedia.tadj.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import batch9.crayonpedia.tadj.R;

/**
 * Created by Emilham on 11/26/15.
 */
public class PengajuanJudulAdapter extends RecyclerView.Adapter<PengajuanJudulAdapter.ViewHolder> {
    private String[] dataSetJudul,dataSetStatus;

    public PengajuanJudulAdapter(String[] dataSetJudul, String[] dataSetStatus) {
        this.dataSetJudul = dataSetJudul;
        this.dataSetStatus = dataSetStatus;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvJudul,tvStatus;
        public Context mContext;


        public ViewHolder(View v) {
            super(v);
            tvJudul = (TextView)v.findViewById(R.id.tvJudul);
            tvStatus = (TextView)v.findViewById(R.id.tvStatus);


            //Click Event
            /*v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext = v.getContext();
                    //Toast.makeText(v.getContext(),"Test",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.TugasAkhirDetail");
                    intent.putExtra("Status","Enroll");
                    v.getContext().startActivity(intent);
                    *//*Intent intent = new Intent("batch9.crayonpedia.tadj.TugasAkhirDetail");
                    v.getContext().startActivity(intent);*//*
                }
            });*/
        }

       /* public TextView getTextView() {
            return tvJudul;
        }*/
    }
    @Override
    public PengajuanJudulAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_pengajuan_judul, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PengajuanJudulAdapter.ViewHolder holder, int position) {
        holder.tvJudul.setText(dataSetJudul[position]);
        holder.tvStatus.setText(dataSetStatus[position]);
    }

    @Override
    public int getItemCount() {
        return dataSetJudul.length;
    }
}
