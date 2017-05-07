package com.lzt.neihandzclient.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.fragment.AttentionFragment;
import com.lzt.neihandzclient.ui.fragment.FansFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public class AttentionActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        ButterKnife.bind(this);
        replaceFragment(new AttentionFragment(), R.id.frameLayout);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.radio:
                replaceFragment(new AttentionFragment(), R.id.frameLayout);
                break;
            case R.id.radio1:
                replaceFragment(new FansFragment(), R.id.frameLayout);
                break;
        }
    }

    public void replaceFragment(Fragment frg, int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(id, frg);
        tx.commit();
    }
}
