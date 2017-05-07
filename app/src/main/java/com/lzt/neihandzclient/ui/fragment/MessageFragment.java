package com.lzt.neihandzclient.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.MessageAdapter;
import com.lzt.neihandzclient.model.Message;
import com.lzt.neihandzclient.ui.activity.AttentionActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public class MessageFragment extends Fragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private String[] title = {"投稿互动", "系统消息", "粉丝关注"};
    private int[] imgs = {R.drawable.a4x, R.drawable.a4v, R.drawable.a4t};
    private MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.activity_layout_message, null);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        messageAdapter = new MessageAdapter(getData());
        recyclerView.setAdapter(messageAdapter);
        setListener();
        return view;
    }

    public void setListener() {
        messageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent attentionIntent = new Intent(getActivity(), AttentionActivity.class);
                        startActivity(attentionIntent);
                        break;
                }
            }
        });
    }

    public List<Message> getData() {
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Message message = new Message();
            message.setTitle(title[i]);
            message.setImage(imgs[i]);
            list.add(message);
        }
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
