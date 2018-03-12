package io.app.pi.data.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.app.pi.R;
import me.drakeet.multitype.ItemViewBinder;


public class PoeDateViewBinder extends ItemViewBinder<PoeDate, PoeDateViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_poe_date, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PoeDate poeDate) {
        String date = poeDate.getDate();
        String dateHans = poeDate.getDateHans();
        if (!TextUtils.isEmpty(date)){
            holder.date.setText(date);
        }
        if (!TextUtils.isEmpty(dateHans)){
            holder.dateHans.setText(dateHans);
        }
        holder.dateLL.setOnClickListener(v -> {

        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout dateLL;
        TextView date,dateHans;

        ViewHolder(View itemView) {
            super(itemView);
            dateLL = itemView.findViewById(R.id.poe_item_date_ll);
            date = itemView.findViewById(R.id.poe_item_date);
            dateHans = itemView.findViewById(R.id.poe_item_date_hans);
        }
    }
}
