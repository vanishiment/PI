package io.app.pi.base;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.app.pi.tool.LoadMoreDelegate;
import io.app.pi.tool.SwipeRefreshDelegate;
import me.drakeet.multitype.MultiTypeAdapter;

public abstract class ListFrag extends BaseFrag {

    SwipeRefreshLayout mSRL;
    RecyclerView mRV;
    MultiTypeAdapter mAdapter;
    ArrayList<Object> mList = new ArrayList<>();

    SwipeRefreshDelegate delegate;
    LoadMoreDelegate loadMoreDelegate;
    private boolean mIsLoadingMore = false;



}
