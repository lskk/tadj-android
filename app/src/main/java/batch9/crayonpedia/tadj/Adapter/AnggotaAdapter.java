package batch9.crayonpedia.tadj.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import batch9.crayonpedia.tadj.R;

/**
 * Created by Emilham on 11/26/15.
 */
public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.ViewHolder> {
    private String[] dataName;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvName;
        public Context mContext;
        public ViewHolder(View v) {
            super(v);
            tvName = (TextView)v.findViewById(R.id.tvNama);

            //Click Event
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext = v.getContext();
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Peringatan")
                            .setMessage("Jadikan Ketua tugas akhir <judul tugas akhir>")
                            .setIcon(R.mipmap.ic_report_problem_black_48dp)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //Toast.makeText(this, "Yaay", Toast.LENGTH_SHORT).show();

                                }})
                            .setNegativeButton(android.R.string.no, null).show();
                }
            });
        }

        /*public TextView getTextView() {
            return tvJudul;
        }*/
    }

    @Override
    public AnggotaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_anggota, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(AnggotaAdapter.ViewHolder holder, int position) {
        holder.tvName.setText(dataName[position]);
    }

    @Override
    public int getItemCount() {
        return dataName.length;
    }
}
