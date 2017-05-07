package com.lzt.neihandzclient.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.AttentionAdapter;
import com.lzt.neihandzclient.base.BaseMvpFragment;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.presenter.AttentionPresenter;
import com.lzt.neihandzclient.view.AttentionView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public class AttentionFragment extends BaseMvpFragment<AttentionPresenter> implements AttentionView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<Attention.ListBean> list = new ArrayList<>();
    private AttentionAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.from(getActivity()).inflate(R.layout.activity_layout_recycle, null);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AttentionAdapter(list);
        recyclerView.setAdapter(adapter);
        setListener();
        return view;

    }

    public void setListener() {
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Attention.ListBean attention = (Attention.ListBean) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.button:
                        delAttention(attention);
                        break;
                }
            }
        });
    }

    public void delAttention(final Attention.ListBean attention) {
        final AlertDialog.Builder aBuilder = new AlertDialog.Builder(getActivity());
        aBuilder.setTitle("确定取消关注吗？");
        aBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                mvpPresenter.delAttention(attention.getAttentionId());
            }
        });
        aBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                aBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });
            }
        });
        aBuilder.show();

//        List<Integer> attentions = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            attentions.add(list.get(i).getUser().getUserId());
//            int fansId = list.get(i).getUser().getUserId();
//            if (fansId == attention.getUser().getUserId()) {
//                view.setSelected(true);
//            }
//        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter.getAttention(41);
    }

    @Override
    public void getAttentionSuccess(Attention attention) {
        List<Attention.ListBean> attentionList = attention.getList();
        list.addAll(attentionList);
        adapter.notifyDataSetChanged();

    }


    @Override
    public void delAttentionSuccess(Attention attention) {
        toastShow("取消成功");
        mvpPresenter.getAttention(41);
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    @Override
    protected AttentionPresenter createPresenter() {
        return new AttentionPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
