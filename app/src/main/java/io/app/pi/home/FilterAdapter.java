package io.app.pi.home;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import io.app.pi.R;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.VH>{

    private List<String> mList = Arrays.asList("唐诗","宋词","元曲","明清","李白","杜甫","白居易","唐诗","宋词","元曲","明清","李白","杜甫","白居易");

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_item,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.filter.setText(mList.get(position));
        holder.filter.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class VH extends RecyclerView.ViewHolder{

        TextView filter;

        VH(View itemView) {
            super(itemView);
            filter = itemView.findViewById(R.id.filter_item_tv);
        }
    }
}
