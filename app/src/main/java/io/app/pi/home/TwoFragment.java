package io.app.pi.home;


import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import io.app.pi.R;
import io.app.pi.base.BaseFrag;
import io.app.pi.data.model.Poe;
import io.app.pi.data.model.PoeViewBinder;
import io.app.pi.tool.LoadMoreDelegate;
import io.app.pi.tool.SwipeRefreshDelegate;
import me.drakeet.multitype.MultiTypeAdapter;


public class TwoFragment extends BaseFrag implements SwipeRefreshDelegate.OnSwipeRefreshListener, LoadMoreDelegate.LoadMoreSubject{

    SwipeRefreshLayout mSRL;
    RecyclerView mRV;
    MultiTypeAdapter mAdapter;
    ArrayList<Object> mList = new ArrayList<>();

    SwipeRefreshDelegate delegate;
    LoadMoreDelegate loadMoreDelegate;
    private boolean mIsLoadingMore = false;

    private OnShowAction mOnShowAction;

    public interface OnShowAction{
        void onShowFilter();
    }

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnShowAction){
            mOnShowAction = (OnShowAction) context;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_two;
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
        mAdapter.register(Poe.class, new PoeViewBinder());
        mRV.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {
        mList.clear();
        Poe poe = new Poe("菩萨蛮·回廊远砌生秋草", "五代", "冯延巳", "回廊远砌生秋草，" +
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
        if (delegate.isShowingRefresh()){
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_sc,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_action_filter:
                if (mOnShowAction != null){
                    mOnShowAction.onShowFilter();
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
