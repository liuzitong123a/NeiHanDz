package com.lzt.neihandzclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.base.BaseActivity;
import com.lzt.neihandzclient.ui.fragment.HomeFragment;
import com.lzt.neihandzclient.ui.fragment.MessageFragment;
import com.lzt.neihandzclient.ui.fragment.MyFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.radio)
    RadioButton radio;
    @Bind(R.id.radio1)
    RadioButton radio1;
    @Bind(R.id.radio2)
    RadioButton radio2;
    @Bind(R.id.radio3)
    RadioButton radio3;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.send)
    ImageView send;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        replaceFragment(new HomeFragment(), R.id.frameLayout);
        radioGroup.setOnCheckedChangeListener(this);
    }

    public void replaceFragment(Fragment frg, int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(id, frg);
        tx.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.radio:
                replaceFragment(new HomeFragment(), R.id.frameLayout);
                break;
            case R.id.radio1:
                break;
            case R.id.radio2:
                replaceFragment(new MessageFragment(), R.id.frameLayout);
                break;
            case R.id.radio3:
                replaceFragment(new MyFragment(), R.id.frameLayout);
                break;
        }
    }

    @OnClick(R.id.send)
    public void onViewClicked() {
        Intent intent = new Intent(MainActivity.this, SendActivity.class);
        startActivity(intent);
    }
}
