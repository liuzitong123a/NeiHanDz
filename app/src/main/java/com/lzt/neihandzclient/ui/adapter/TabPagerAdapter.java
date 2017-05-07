package com.lzt.neihandzclient.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lzt.neihandzclient.ui.fragment.HomeItemFragment;

/**
 * Created by 刘子樋 on 2017/4/23.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    String[] newsTags;

    public TabPagerAdapter(FragmentManager fm, String[] newsTags) {
        super(fm);
        this.newsTags = newsTags;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = new HomeItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(HomeItemFragment.NEWS_KEY,position+1);
        fg.setArguments(bundle);
        return fg;
    }

    @Override
    public int getCount() {
        return (newsTags != null) ? newsTags.length : 0;
    }
}
