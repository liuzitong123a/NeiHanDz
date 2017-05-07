package com.lzt.neihandzclient.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.FansAdapter;
import com.lzt.neihandzclient.base.BaseMvpFragment;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.presenter.FansPresenter;
import com.lzt.neihandzclient.view.FansView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘子樋 on 2017/4/30.
 */

public class FansFragment extends BaseMvpFragment<FansPresenter> implements FansView {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private FansAdapter adapter;
    private List<Attention.ListBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.activity_layout_recycle, null);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FansAdapter(list);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.getFans(41);
    }

    @Override
    public void getFansSuccess(Attention attention) {
        List<Attention.ListBean> fans = attention.getList();
        list.addAll(fans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addAttentionSuccess(Attention attention) {

    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    @Override
    protected FansPresenter createPresenter() {
        return new FansPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
