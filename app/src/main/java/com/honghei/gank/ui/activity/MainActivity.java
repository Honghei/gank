package com.honghei.gank.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.honghei.gank.R;
import com.honghei.gank.ui.fragment.gank.GankFragment;
import com.honghei.gank.ui.fragment.zhihu.ZhihuNewsFragment;
import com.honghei.gank.util.LayoutUtil;
import com.honghei.gank.widght.SelfDefinedViewPager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab;

    /**
     * 表示的是当前选中的是第几页，在dispatchtouch中与手势一起作用于tab的hide和show，如果是1.2.页就直接不显示了
     *
     * 这样考虑的原因是 hide和show方法会影响到fab的gone和visiable属性。
     */
    private int selectedPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.smarttablayout_fragmentname_1, ZhihuNewsFragment.class)
                .add(R.string.smarttablayout_fragmentname_2, GankFragment.class)
                .add(R.string.smarttablayout_fragmentname_3, ZhihuNewsFragment.class)
                .create());



        SelfDefinedViewPager viewPager = (SelfDefinedViewPager) findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(true);
        viewPager.setAdapter(adapter);

       /* setViewPagerMargin(viewPager);*/


        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        setTabPageChangeListen(viewPagerTab);
    }



    float x;
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float nextX = event.getRawY();
                float desX = x-nextX;
                if(selectedPage == 0 && desX >0){
                    fab.hide();
                }else if(selectedPage == 0 && desX<0){
                    fab.show();
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    /**
     * 设置smarttablayout的margintop值。
     */
    private void setViewPagerMargin(SelfDefinedViewPager viewPager) {

        int dimension = (int) getResources().getDimension(R.dimen.tablayout_height);


        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        LayoutUtil.setViewMargin(viewPager,dimension+actionBarHeight);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setTabPageChangeListen(SmartTabLayout tabLayout){
        tabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    fab.setVisibility(View.VISIBLE);
                }else {
                    fab.setVisibility(View.GONE);
                }
                selectedPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
