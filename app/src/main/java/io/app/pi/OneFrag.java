package io.app.pi;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class OneFrag extends BaseFrag {

    RecyclerView mRV;
    BookAdapter mAdapter;

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
        mRV = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(),2);
        mRV.setHasFixedSize(true);
        mRV.setLayoutManager(gridLayoutManager);
        if (mAdapter == null){
            mAdapter = new BookAdapter();
        }
        mRV.setAdapter(mAdapter);
    }

    @Override
    public void loadData() {

    }
}
