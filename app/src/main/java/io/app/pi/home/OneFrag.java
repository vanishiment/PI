package io.app.pi.home;


import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import io.app.pi.R;
import io.app.pi.base.BaseFrag;
import io.app.pi.data.model.Poe;
import io.app.pi.data.model.PoeDate;
import io.app.pi.data.model.PoeDateViewBinder;
import io.app.pi.data.model.PoeImage;
import io.app.pi.data.model.PoeImageViewBinder;
import io.app.pi.data.model.PoeViewBinder;
import io.app.pi.tool.LoadMoreDelegate;
import io.app.pi.tool.SwipeRefreshDelegate;
import me.drakeet.multitype.MultiTypeAdapter;

//http://kkpoem.duowan.com/api/recommend/list.do
//
//        http://kkpoem.duowan.com/api/recommend/cover.do
public class OneFrag extends BaseFrag implements SwipeRefreshDelegate.OnSwipeRefreshListener, LoadMoreDelegate.LoadMoreSubject {

    SwipeRefreshLayout mSRL;
    RecyclerView mRV;
    MultiTypeAdapter mAdapter;
    ArrayList<Object> mList = new ArrayList<>();

    SwipeRefreshDelegate delegate;
    LoadMoreDelegate loadMoreDelegate;
    private boolean mIsLoadingMore = false;

    public OneFrag() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(View view) {
        super.initView(view);
        mSRL = view.findViewById(R.id.swipe_fresh_layout);
        delegate = new SwipeRefreshDelegate(this);
        delegate.attach(mSRL);
        mRV = view.findViewById(R.id.recycler_view);
        loadMoreDelegate = new LoadMoreDelegate(this);
        loadMoreDelegate.attach(mRV);
        mAdapter = new MultiTypeAdapter();
        mAdapter.register(PoeImage.class, new PoeImageViewBinder());
        mAdapter.register(PoeDate.class, new PoeDateViewBinder());
        mAdapter.register(Poe.class, new PoeViewBinder());
        mRV.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {
        mList.clear();
        mList.add(new PoeImage("http://kkpoem.bs2dl.yy.com/898f4ad649f7fddfa82ddb90319a0d07.jpg"));
        mList.add(new PoeDate("2018-03-12", "农历正月廿五"));
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
}
