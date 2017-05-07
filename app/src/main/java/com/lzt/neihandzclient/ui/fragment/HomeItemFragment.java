package com.lzt.neihandzclient.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.base.BaseMvpFragment;
import com.lzt.neihandzclient.model.HomeCount;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.presenter.HomeItemPresenter;
import com.lzt.neihandzclient.ui.activity.CommentActivity;
import com.lzt.neihandzclient.ui.adapter.HomeAdapter;
import com.lzt.neihandzclient.view.HomeItemView;
import com.lzy.ninegrid.NineGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager;

/**
 * Created by 刘子樋 on 2017/4/24.
 */

public class HomeItemFragment extends BaseMvpFragment<HomeItemPresenter> implements HomeItemView,BaseQuickAdapter.RequestLoadMoreListener {
    public static final String NEWS_KEY = "titles";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<HomeModel.ListBean> dataServer = new ArrayList<>();
    private HomeAdapter homeAdapter;
    private int pageNo = 0;
    private int totalNo = 0;
    private int TOTAL_COUNTER = 0;
    private static final int PAGE_SIZE = 5;
    private int type;
    private Handler handler = new Handler();

    @Override
    protected HomeItemPresenter createPresenter() {
        return new HomeItemPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.activity_layout_recycle, null);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        homeAdapter = new HomeAdapter(dataServer);
        homeAdapter.setOnLoadMoreListener(this, recyclerView);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                intent.putExtra("home", dataServer.get(position));
                startActivity(intent);
            }
        });
        NineGridView.setImageLoader(new GlideImageLoader());
        setListener();
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type = getArguments().getInt(NEWS_KEY);
        //请求接口
        mvpPresenter.getHomeCount(type);
        mvpPresenter.getHomeList(type, 1);
    }

    @Override
    public void getDataSuccess(HomeModel model) {
        final List<HomeModel.ListBean> list = model.getList();
        dataServer.addAll(list);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCountSuccess(HomeCount count) {
        TOTAL_COUNTER = count.getCount();
    }

    @Override
    public void getDataFail(String msg) {
        toastShow("网络不给力");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    protected void setListener() {
        //视频监听
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if (JCVideoPlayerManager.getCurrentJcvd() != null) {
                    JCVideoPlayer videoPlayer = JCVideoPlayerManager.getCurrentJcvd();
                    if (((ViewGroup) view).indexOfChild(videoPlayer) != -1 && videoPlayer.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING) {
                        //当滑动的时，正在播放的视频移除屏幕，取消播放这个视频
                        JCVideoPlayer.releaseAllVideos();
                    }
                }
            }
        });
    }

    @Override
    public void onLoadMoreRequested() {
        if (homeAdapter.getData().size() < PAGE_SIZE) {
            homeAdapter.loadMoreEnd(true);
        } else {
            homeAdapter.loadMoreEnd(false);
//            if (mCurrentCounter >= TOTAL_COUNTER) {
////                    pullToRefreshAdapter.loadMoreEnd();//default visible
//                //true is gone,false is visible
//            } else {
//                if (isErr) {
//                    homeAdapter.addData(DataServer.getSampleData(PAGE_SIZE));
//                    mCurrentCounter = homeAdapter.getData().size();
//                    pullToRefreshAdapter.loadMoreComplete();
//                } else {
//                    isErr = true;
//                    //Toast.makeText(PullToRefreshUseActivity.this, R.string.network_err, Toast.LENGTH_LONG).show();
//                    homeAdapter.loadMoreFail();
//
//                }
//            }
            //mSwipeRefreshLayout.setEnabled(true);
        }
    }

    /**
     * Glide 加载
     */
    private class GlideImageLoader implements NineGridView.ImageLoader {
        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            Glide.with(context).load(url)//
                    .placeholder(R.drawable.ic_default_color)//
                    .error(R.drawable.ic_default_color)//
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//
                    .into(imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }
}
