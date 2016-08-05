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
 * Created by Emilham on 11/24/15.
 */
public class ListTugasAkhirAdapter extends RecyclerView.Adapter<ListTugasAkhirAdapter.ViewHolder> {
    protected String status;
    private String[] dataSetJudul;
    private int[]dataSetCover;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView ivCover;
        public TextView tvJudul;
        public Context mContext;


        public ViewHolder(View v) {
            super(v);
            ivCover = (ImageView)v.findViewById(R.id.ivCover);
            tvJudul = (TextView)v.findViewById(R.id.tvJudul);


            //Click Event
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext = v.getContext();
                    //Toast.makeText(v.getContext(),"Test",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("batch9.crayonpedia.tadj.TugasAkhirDetail");
                    intent.putExtra("Status","Enroll");
                    v.getContext().startActivity(intent);
                    /*Intent intent = new Intent("batch9.crayonpedia.tadj.TugasAkhirDetail");
                    v.getContext().startActivity(intent);*/
                }
            });
        }

       /* public TextView getTextView() {
            return tvJudul;
        }*/
    }

    public ListTugasAkhirAdapter(String[] dataSet1, int[] dataSet2) {
        this.dataSetJudul = dataSet1;
        this.dataSetCover = dataSet2;

    }

    @Override
    public ListTugasAkhirAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_list_tugas_akhir, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ListTugasAkhirAdapter.ViewHolder holder, int position) {
        holder.tvJudul.setText(dataSetJudul[position]);
        holder.ivCover.setImageResource(dataSetCover[position]);
    }

    @Override
    public int getItemCount() {
        return dataSetJudul.length;
    }
}
