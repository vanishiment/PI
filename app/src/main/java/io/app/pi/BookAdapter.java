package io.app.pi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.VH> {

    private List<BookFrame> mBookFrameList;

    public BookAdapter() {
        init();
    }

    private void init() {
        if (mBookFrameList == null) {
            mBookFrameList = new ArrayList<>();
        }

        mBookFrameList.clear();
        mBookFrameList.addAll(Data.genCardList());
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (mBookFrameList != null && !mBookFrameList.isEmpty()) {
            BookFrame bookFrame = mBookFrameList.get(position);
            String title = bookFrame.getName();
            String cover = bookFrame.getCover();
            if (!TextUtils.isEmpty(title))
                holder.title.setText(title);

            if (!TextUtils.isEmpty(cover))
                Glide.with(holder.cover.getContext()).load(cover).into(holder.cover);
        }
        holder.mItem.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return mBookFrameList == null ? 0 : mBookFrameList.size();
    }

    static class VH extends RecyclerView.ViewHolder {

        CardView mItem;
        TextView title;
        ImageView cover;

        VH(View itemView) {
            super(itemView);
            mItem = itemView.findViewById(R.id.book_card);
            title = itemView.findViewById(R.id.book_title);
            cover = itemView.findViewById(R.id.book_cover);
        }
    }
}
