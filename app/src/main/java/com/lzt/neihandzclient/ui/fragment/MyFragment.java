package com.lzt.neihandzclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.base.BaseMvpFragment;
import com.lzt.neihandzclient.presenter.MyPresenter;
import com.lzt.neihandzclient.view.MyView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘子樋 on 2017/5/1.
 */

public class MyFragment extends BaseMvpFragment<MyPresenter> implements MyView, RadioGroup.OnCheckedChangeListener {
    @Bind(R.id.myHeader)
    ImageView myHeader;
    @Bind(R.id.back)
    ImageButton back;
    @Bind(R.id.login)
    TextView login;
    @Bind(R.id.nickName)
    TextView nickName;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.activity_my, null);
        ButterKnife.bind(this, view);
        replaceFragment(new MyCommenFragment(), R.id.myFragment);
        radioGroup.setOnCheckedChangeListener(this);
        return view;
    }

    public void replaceFragment(Fragment frg, int id) {
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(id, frg);
        tx.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.myHeader, R.id.back, R.id.login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myHeader:
                break;
            case R.id.back:
                break;
            case R.id.login:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.review:
                replaceFragment(new MyCommenFragment(), R.id.myFragment);
                break;
            case R.id.collection:
                replaceFragment(new MyCommenFragment(), R.id.myFragment);
                break;
            case R.id.comment:
                replaceFragment(new MyCommenFragment(), R.id.myFragment);
                break;
        }
    }
}
