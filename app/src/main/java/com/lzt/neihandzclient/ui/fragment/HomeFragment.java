package com.lzt.neihandzclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.TabPagerAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by 刘子樋 on 2017/4/23.
 */

public class HomeFragment extends Fragment {
    @Bind(R.id.my)
    ImageView my;
    @Bind(R.id.send)
    ImageView send;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    private String[] mTitles;
    private TabPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_home, null);
        ButterKnife.bind(this, view);
        mTitles = getResources().getStringArray(R.array.news_tags);
        for (int i = 0; i < mTitles.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitles[i]));
        }
        adapter = new TabPagerAdapter(getChildFragmentManager(), mTitles);
        viewpager.setAdapter(adapter);
        //给ViewPager添加监听(这里我们直接使用TabLayout里面提供的TabLayoutOnPageChangeListener无需自己再编写)
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //设置setOnTabSelectedListener
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换到指定的item
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.my, R.id.send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my:
                break;
            case R.id.send:
                break;
        }
    }
}
