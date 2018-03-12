package io.app.pi.data.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.app.pi.R;
import me.drakeet.multitype.ItemViewBinder;


public class PoeImageViewBinder extends ItemViewBinder<PoeImage, PoeImageViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_poe_image, parent, false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull PoeImage poeImage) {
        String imgUrl = poeImage.getUrl();
        if (!TextUtils.isEmpty(imgUrl)){
            Glide.with(holder.poeImg).load(imgUrl).into(holder.poeImg);
        }
        holder.poeImgFL.setOnClickListener(v -> {

        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        FrameLayout poeImgFL;
        ImageView poeImg;

        ViewHolder(View itemView) {
            super(itemView);
            poeImgFL = itemView.findViewById(R.id.poe_item_img_fl);
            poeImg = itemView.findViewById(R.id.poe_item_img);
        }
    }
}
