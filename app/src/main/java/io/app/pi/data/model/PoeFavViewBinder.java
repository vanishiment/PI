package io.app.pi.data.model;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.app.pi.R;
import io.app.pi.home.DetailAct;
import me.drakeet.multitype.ItemViewBinder;


public class PoeFavViewBinder extends ItemViewBinder<PoeFav, PoeFavViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_poe_fav, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PoeFav poeFav) {
        String title = poeFav.getTitle();
        String dynasty = poeFav.getDynasty();
        String author = poeFav.getAuthor();
        String content = poeFav.getContent();
        if (!TextUtils.isEmpty(title)){
            holder.poeTitle.setText(title);
        }
        String a = "";
        if (!TextUtils.isEmpty(dynasty)){
            a = dynasty;
        }
        if (!TextUtils.isEmpty(author)){
            a = author;
        }
        if (!TextUtils.isEmpty(dynasty) && !TextUtils.isEmpty(author)){
            a = dynasty + "/" + author;
        }
        holder.poeAuthor.setText(a);

        if (!TextUtils.isEmpty(content)){
            holder.poeContent.setText(content);
        }
        holder.poeLL.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, DetailAct.class);
            context.startActivity(intent);
        });

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout poeLL;
        TextView poeTitle,poeAuthor,poeContent;

        ViewHolder(View itemView) {
            super(itemView);
            poeLL = itemView.findViewById(R.id.poe_item_content_ll);
            poeTitle = itemView.findViewById(R.id.poe_item_title);
            poeAuthor = itemView.findViewById(R.id.poe_item_author);
            poeContent = itemView.findViewById(R.id.poe_item_content);
        }

    }

}
