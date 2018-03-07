package io.app.pi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    Toolbar mToolbar;
    TextView mTitle;
    ViewPager mViewPager;
    BottomNavigationBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        QMUIStatusBarHelper.translucent(this);
        initTitle();
        initViewPager();
        initBottomBar();
    }

    private void initTitle() {
        mToolbar = findViewById(R.id.toolbar);
        mTitle = findViewById(R.id.toolbar_title);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initViewPager() {
        mViewPager = findViewById(R.id.main_view_pager);
        mViewPager.setAdapter(new MainVPAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(3);
    }

    private void initBottomBar() {
        mBottomBar = findViewById(R.id.main_bottom_bar);
        mBottomBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomBar.setAutoHideEnabled(true);
        mBottomBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, R.string.title_home))
                .addItem(new BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, R.string.title_dashboard))
                .addItem(new BottomNavigationItem(R.drawable.ic_notifications_black_24dp, R.string.title_notifications))
                .initialise();
        mBottomBar.setTabSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewPager.removeOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_action_search:
                return true;
            case R.id.menu_action_more:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position, false);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private static class MainVPAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> mFragmentList = new ArrayList<>();

        private MainVPAdapter(FragmentManager fm) {
            super(fm);
            init();
        }

        private void init() {
            if (!mFragmentList.isEmpty()) {
                mFragmentList.clear();
            }
            mFragmentList.add(new OneFrag());
            mFragmentList.add(new TwoFragment());
            mFragmentList.add(new ThreeFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
