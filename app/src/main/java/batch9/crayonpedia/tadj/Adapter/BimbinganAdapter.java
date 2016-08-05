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
 * Created by Emilham on 11/25/15.
 */
public class BimbinganAdapter extends RecyclerView.Adapter<BimbinganAdapter.ViewHolder> {
    private String[] dataSetTanggal,dataSetPembimbing,dataSetPermasalahan,dataSetSolusi,dataSetStatus;
    private int[] dataImagePembimbing;

    public BimbinganAdapter(String[] dataSetTanggal, String[] dataSetPembimbing, String[] dataSetPermasalahan, String[] dataSetSolusi, String[] dataSetStatus, int[] dataImagePembimbing) {
        this.dataSetTanggal = dataSetTanggal;
        this.dataSetPembimbing = dataSetPembimbing;
        this.dataSetPermasalahan = dataSetPermasalahan;
        this.dataSetSolusi = dataSetSolusi;
        this.dataSetStatus = dataSetStatus;
        this.dataImagePembimbing = dataImagePembimbing;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvTanggal,tvPembimbing,tvPermasalahan,tvSolusi,tvStatus;
        public ImageView ivPembimbing;
        public Context mContext;
        public ViewHolder(View v) {
            super(v);
            tvTanggal = (TextView)v.findViewById(R.id.tvTanggal);
            tvPembimbing = (TextView)v.findViewById(R.id.tvPembimbing);
            tvPermasalahan = (TextView)v.findViewById(R.id.tvPermasalahan);
            tvSolusi = (TextView)v.findViewById(R.id.tvSolusi);
            tvStatus = (TextView)v.findViewById(R.id.tvStatus);
            ivPembimbing = (ImageView)v.findViewById(R.id.ivPembimbing);
            //Click Event
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*mContext = v.getContext();
                    Toast.makeText(v.getContext(),"Test",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.BeritaDetail");
                    intent.putExtra("Judul","Laporan Tugas Akhir 2015");
                    v.getContext().startActivity(intent);*/
                }
            });
        }

    }
    @Override
    public BimbinganAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_bimbingan, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(BimbinganAdapter.ViewHolder holder, int position) {
        holder.tvTanggal.setText(dataSetTanggal[position]);
        holder.tvPembimbing.setText(dataSetPembimbing[position]);
        holder.tvPermasalahan.setText(dataSetPermasalahan[position]);
        holder.tvSolusi.setText(dataSetSolusi[position]);
        holder.tvStatus.setText(dataSetStatus[position]);
        holder.ivPembimbing.setImageResource(dataImagePembimbing[position]);
    }

    @Override
    public int getItemCount() {
        return dataSetPembimbing.length;
    }
}
