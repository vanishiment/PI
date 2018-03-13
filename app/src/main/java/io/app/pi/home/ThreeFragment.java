package io.app.pi.home;


import android.app.Activity;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import io.app.pi.R;
import io.app.pi.base.BaseFrag;
import io.app.pi.data.model.Poe;
import io.app.pi.data.model.PoeFav;
import io.app.pi.data.model.PoeFavViewBinder;
import io.app.pi.data.model.PoeViewBinder;
import io.app.pi.tool.LoadMoreDelegate;
import io.app.pi.tool.SwipeRefreshDelegate;
import me.drakeet.multitype.MultiTypeAdapter;


public class ThreeFragment extends BaseFrag implements SwipeRefreshDelegate.OnSwipeRefreshListener,
        LoadMoreDelegate.LoadMoreSubject {

    SwipeRefreshLayout mSRL;
    RecyclerView mRV;
    MultiTypeAdapter mAdapter;
    ArrayList<Object> mList = new ArrayList<>();

    SwipeRefreshDelegate delegate;
    LoadMoreDelegate loadMoreDelegate;
    private boolean mIsLoadingMore = false;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_three;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        setHasOptionsMenu(true);
        mSRL = view.findViewById(R.id.swipe_fresh_layout);
        delegate = new SwipeRefreshDelegate(this);
        delegate.attach(mSRL);
        mRV = view.findViewById(R.id.recycler_view);
        loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attach(mRV);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(PoeFav.class, new PoeFavViewBinder());
        mRV.setAdapter(mAdapter);

        registerForContextMenu(mRV);
    }

    @Override
    public void loadData() {
        mList.clear();
        PoeFav poe = new PoeFav("菩萨蛮·回廊远砌生秋草", "五代", "冯延巳", "回廊远砌生秋草，" +
                "梦魂千里青门道。");
        for (int i = 0; i < 10; i++) {
            mList.add(poe);
        }
        mAdapter.setItems(mList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSwipeRefresh() {
        loadData();
        if (delegate.isShowingRefresh()) {
            delegate.setRefresh(false);
        }
    }

    @Override
    public boolean isLoading() {
        return delegate.isShowingRefresh() || mIsLoadingMore;
    }

    @Override
    public void onLoadMore() {
        mIsLoadingMore = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Poe poe = new Poe("菩萨蛮·回廊远砌生秋草", "五代", "冯延巳", "回廊远砌生秋草，" +
                        "梦魂千里青门道。");
                for (int i = 0; i < 10; i++) {
                    mList.add(poe);
                }
                mAdapter.setItems(mList);
                mAdapter.notifyDataSetChanged();
                mIsLoadingMore = false;
            }
        }, 5000L);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Activity activity = getActivity();
        if (activity != null) {
            activity.getMenuInflater().inflate(R.menu.menu_fav, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_action_delete:
                return true;
            case R.id.menu_action_top:
                return true;
            case R.id.menu_action_share:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
