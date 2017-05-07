package com.lzt.neihandzclient.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.CommentAdapter;
import com.lzt.neihandzclient.base.BaseMvpActivity;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.model.Collection;
import com.lzt.neihandzclient.model.Comment;
import com.lzt.neihandzclient.model.DisLike;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.model.Like;
import com.lzt.neihandzclient.presenter.CommentPresenter;
import com.lzt.neihandzclient.retrofit.ApiService;
import com.lzt.neihandzclient.utils.EmptyUtil;
import com.lzt.neihandzclient.utils.GlideCircleTransform;
import com.lzt.neihandzclient.view.CommentView;
import com.lzt.neihandzclient.ui.weight.CustomPopupWindow;
import com.lzt.neihandzclient.ui.weight.MyLayoutManager;
import com.lzt.neihandzclient.ui.weight.MyPlayerView;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class CommentActivity extends BaseMvpActivity<CommentPresenter> implements CommentView {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.share)
    ImageView share;
    @Bind(R.id.userHeader)
    ImageView userHeader;
    @Bind(R.id.nickName)
    TextView nickName;
    @Bind(R.id.attentionBtn)
    ImageButton attentionBtn;
    @Bind(R.id.time)
    TextView time;
    @Bind(R.id.icon)
    TextView icon;
    @Bind(R.id.textContent)
    TextView textContent;
    @Bind(R.id.like)
    ImageView like;
    @Bind(R.id.likeTimes)
    TextView likeTimes;
    @Bind(R.id.notLike)
    ImageView notLike;
    @Bind(R.id.notLikeTimes)
    TextView notLikeTimes;
    @Bind(R.id.comment)
    ImageView comment;
    @Bind(R.id.commentTimes)
    TextView commentTimes;
    @Bind(R.id.collection)
    ImageView collection;
    @Bind(R.id.collectionTimes)
    TextView collectionTimes;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.img)
    ImageView img;
    @Bind(R.id.text)
    TextView text;
    @Bind(R.id.l)
    LinearLayout l;
    private NineGridView nineGridView;
    private MyPlayerView myPlayerView;
    private HomeModel.ListBean home;
    private List<Integer> likes = new ArrayList<>();
    private List<Integer> disLikes = new ArrayList<>();
    private List<Integer> users = new ArrayList<>();
    private List<Integer> collections = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        home = (HomeModel.ListBean) getIntent().getSerializableExtra("home");
        if (home.getHomeurl().contains(".mp4")) {
            setContentView(R.layout.activity_comment_video);
            myPlayerView = (MyPlayerView) findViewById(R.id.myPlayer);
        } else if (home.getHomeurl().equals("")) {
            setContentView(R.layout.activity_comment_text);
        } else {
            setContentView(R.layout.activity_comment_pic);
            nineGridView = (NineGridView) findViewById(R.id.nineGrid);
        }

        recyclerView.setFocusable(false);
        MyLayoutManager manager = new MyLayoutManager(this);
        manager.setScrollEnabled(false);
        recyclerView.setLayoutManager(manager);
        init();
        data();
    }

    public void init() {
        nickName.setText(home.getUser().getNickName());
        Glide.with(this).load(ApiService.API_SERVER_URL + home.getUser().getPath()).transform(new GlideCircleTransform(this)).into(userHeader);
        time.setText(home.getHomeTime());
        textContent.setText(home.getHomeContent());
        if (home.getHomeurl().contains(".mp4")) {
            myPlayerView.setUp(ApiService.API_SERVER_URL + home.getHomeurl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, home.getHomeContent());
            Glide.with(this).load(ApiService.API_SERVER_URL + home.getHomePic()).into(myPlayerView.thumbImageView);
            myPlayerView.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        if (!home.getHomeurl().contains(".mp4") && !home.getHomeurl().equals("")) {
            ArrayList<ImageInfo> imageInfo = new ArrayList<>();
            String imageUrls[] = home.getHomeurl().split(",");
            for (int i = 0; i < imageUrls.length; i++) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(ApiService.API_SERVER_URL + imageUrls[i]);
                info.setBigImageUrl(ApiService.API_SERVER_URL + imageUrls[i]);
                imageInfo.add(info);
            }
            nineGridView.setAdapter(new NineGridViewClickAdapter(this, imageInfo));
        }

    }

    public void data() {
        if (home.getUser().getUserId() == 41) {
            attentionBtn.setVisibility(View.GONE);
        }
        mvpPresenter.getComment(home.getHomeId());
        mvpPresenter.getLike(home.getHomeId());
        mvpPresenter.getDisLike(home.getHomeId());
        mvpPresenter.getCollection(home.getHomeId());
        mvpPresenter.getAttention(41);
    }

    @Override
    protected CommentPresenter createPresenter() {
        return new CommentPresenter(this);
    }

    @OnClick({R.id.back, R.id.share, R.id.attentionBtn, R.id.like, R.id.notLike, R.id.comment, R.id.collection,R.id.l})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.share:
                break;
            case R.id.attentionBtn:
                if (attentionBtn.isSelected()) {

                } else {
                    addAttnetion();
                }
                break;
            case R.id.like:
                if (!likes.contains(41) && !disLikes.contains(41)) {
                    mvpPresenter.addLike(commen());
                } else {
                    toastShow("已参与过评价");
                }
                break;
            case R.id.notLike:
                if (!likes.contains(41) && !disLikes.contains(41)) {
                    mvpPresenter.addDisLike(commen());
                } else {
                    toastShow("已参与过评价");
                }
                break;
            case R.id.comment:
                popouWindow(R.id.comment);
                break;
            case R.id.collection:
                if (collection.isSelected()) {
                    delCollection();
                } else {
                    mvpPresenter.addCollection(commen());
                }
                break;
            case R.id.l:
                popouWindow(R.id.l);
                break;
        }
    }

    public Map<String, Object> commen() {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "add");
        parmars.put("homeId", home.getHomeId());
        parmars.put("userId", 41);
        return parmars;
    }

    public void addAttnetion() {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "add");
        parmars.put("otherUser", home.getUser().getUserId());
        parmars.put("my", 41);
        mvpPresenter.addAttention(parmars);
    }

    @Override
    public void addCommentSuccess(Comment model) {
        //mvpPresenter.add
        toastShow("评论成功");
        mvpPresenter.getComment(home.getHomeId());
    }

    @Override
    public void addLikeSuccess(Like model) {
        toastShow("点赞成功");
        mvpPresenter.getLike(home.getHomeId());
    }

    @Override
    public void addDisLikeSuccess(DisLike model) {
        toastShow("点踩成功");
        mvpPresenter.getDisLike(home.getHomeId());
        notLike.setSelected(true);
    }

    @Override
    public void addCollectionSuccess(Collection model) {
        toastShow("收藏成功");
        mvpPresenter.getCollection(home.getHomeId());
    }

    @Override
    public void addAttentionSuccess(Attention attention) {
        toastShow("关注成功");
        attentionBtn.setSelected(true);
//        mvpPresenter.getAttention(41);
    }

    @Override
    public void getCommentSuccess(Comment model) {
        List<Comment.ListBean> list = model.getList();
        recyclerView.setAdapter(new CommentAdapter(list));
        commentTimes.setText(String.valueOf(list.size()));
    }


    @Override
    public void getLikeSuccess(Like model) {
        List<Like.ListBean> list = model.getList();
        likeTimes.setText(String.valueOf(list.size()));
        for (int i = 0; i < list.size(); i++) {
            likes.add(list.get(i).getUser().getUserId());
        }
        if (likes.contains(41)) {
            like.setSelected(true);
        }
    }


    @Override
    public void getDisLikeSuccess(DisLike model) {
        List<DisLike.ListBean> list = model.getList();
        notLikeTimes.setText(String.valueOf(list.size()));
        for (int i = 0; i < list.size(); i++) {
            disLikes.add(list.get(i).getUser().getUserId());
        }
        if (disLikes.contains(41)) {
            notLike.setSelected(true);
        }
    }

    @Override
    public void getCollectionSuccess(Collection model) {
        collections.removeAll(collections);
        List<Collection.ListBean> list = model.getList();
        collectionTimes.setText(String.valueOf(list.size()));
        for (int i = 0; i < list.size(); i++) {
            collections.add(list.get(i).getUser().getUserId());
        }
        if (collections.contains(41)) {
            collection.setSelected(true);
        } else {
            collection.setSelected(false);
        }
    }


    @Override
    public void getAttentionSuccess(Attention attention) {
        List<Attention.ListBean> list = attention.getList();
        for (int i = 0; i < list.size(); i++) {
            users.add(list.get(i).getUser().getUserId());
        }
        if (!users.contains(home.getUser().getUserId())) {
            attentionBtn.setSelected(false);
        } else {
            attentionBtn.setSelected(true);
        }
    }

    public void delCollection() {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "delete");
        parmars.put("userId", 41);
        parmars.put("homeId", home.getHomeId());
        mvpPresenter.delCollection(parmars);
    }

    @Override
    public void delCollectionSuccess(Collection model) {
        toastShow("收藏删除成功");
        mvpPresenter.getCollection(home.getHomeId());
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            String message = (String) msg.obj;
            if (!EmptyUtil.isEmpty(message)) {
                Map<String, Object> parmars = new HashMap<>();
                parmars.put("type", "add");
                parmars.put("userId", 41);
                parmars.put("homeId", home.getHomeId());
                parmars.put("commentContent", message);
                mvpPresenter.addComment(parmars);
            } else {
                toastShow("评论内容不能为空");
            }

        }
    };

    public void popouWindow(int id) {
        final CustomPopupWindow mPop = new CustomPopupWindow(
                CommentActivity.this, handler);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        mPop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
        mPop.setOnItemClickListener(new CustomPopupWindow.OnItemClickListener() {
            @Override
            public void setOnItemClick(View v) {
                mPop.dismiss();
            }
        });
        mPop.setFocusable(true);
        mPop.showAtLocation(CommentActivity.this.findViewById(id),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
}
