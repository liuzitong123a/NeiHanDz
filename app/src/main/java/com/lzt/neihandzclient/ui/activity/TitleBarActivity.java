package com.lzt.neihandzclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.TitleBarAdapter;
import com.lzt.neihandzclient.model.TitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public class TitleBarActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.back)
    ImageView back;
    private String title[] = {"每日推荐", "搞笑视频", "爆笑图片", "段友秀出来", "内涵段子", "精华", "笑话大全"};
    private int resouce[] = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titlebar);
        ButterKnife.bind(this);
        getData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        TitleBarAdapter titleBarAdapter = new TitleBarAdapter(getData());
        recyclerView.setAdapter(titleBarAdapter);
        titleBarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("title", title[position]);
                intent.putExtra("type", String.valueOf(position + 1));
                setResult(002, intent);
                finish();
            }
        });
    }

    public List<TitleBar> getData() {
        List<TitleBar> list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            TitleBar titleBar = new TitleBar();
            titleBar.setTitle(title[i]);
            titleBar.setResouce(resouce[i]);
            list.add(titleBar);
        }
        return list;
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
