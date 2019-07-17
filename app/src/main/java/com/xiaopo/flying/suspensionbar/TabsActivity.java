package com.xiaopo.flying.suspensionbar;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.xiaopo.flying.adapter.FragmentAdapter;
import com.xiaopo.flying.fragment.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class TabsActivity extends AppCompatActivity {
    //    private Toolbar toolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.list_anim);
        mTabLayout.setAnimation(animation);


        initView();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initView() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("励志");
        titles.add("图文");
        titles.add("本地");
        titles.add("动漫");
        titles.add("搞笑");
        titles.add("幽默");

        List<android.support.v4.app.Fragment> fragments = new ArrayList<>();

        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)).setIcon(R.drawable.face1).setCustomView(R.layout.list_item_card_main));

        }
        for (int i = 0; i < titles.size(); i++) {
            /**ViewPages里面的每一个fragment的list**/
            fragments.add(new ListFragment(titles.get(i)));
        }

        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);

        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);


        //将TabLayout和ViewPager关联起来。
        //必须在ViewPager.setAdapter() 之后调用
        mTabLayout.setupWithViewPager(mViewPager);

        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);


        //设置被选中Tab的文字的颜色
        mTabLayout.setTabTextColors(Color.BLACK, Color.RED);
        //设置被选中Tab指示条的颜色
        mTabLayout.setSelectedTabIndicatorColor(Color.RED);
        //设置被选中Tab指示条的高度
        mTabLayout.setSelectedTabIndicatorHeight(10);
        //设置Tab的模式  MODE_FIXED/MODE_SCROLLABLE
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
