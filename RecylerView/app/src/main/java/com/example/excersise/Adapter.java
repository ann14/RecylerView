package com.example.excersise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public int count=0;

    public List<String> mData;
    public List<Boolean> cData;
    Adapter(List<String> data ,List<Boolean> cdata) {
        mData = data;
        cData= cdata;
        }
    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtItem;
        private CheckBox check;
        private TextView txt;


        ViewHolder(final View itemView) {
            super(itemView);
            final TextView listItemNumberView = (TextView) itemView.findViewById(R.id.txtItem);
            txtItem = (TextView) itemView.findViewById(R.id.txtItem);
            check=(CheckBox) itemView.findViewById(R.id.check);

            }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position)  {


        holder.txtItem.setText(mData.get(position));
        holder.check.setChecked(cData.get(position));
        holder.check.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean b = ((CheckBox) v).isChecked();
                holder.check.setChecked(b);
                cData.set(position, b);
                if(holder.check.isChecked()){
                    count++;
                }else{
                    count--;
                }
                }
        });

    }
    @Override
    public int getItemCount() {
        return mData.size();
    }


}