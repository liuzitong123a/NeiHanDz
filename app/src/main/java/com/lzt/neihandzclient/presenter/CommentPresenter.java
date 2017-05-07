package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.model.Collection;
import com.lzt.neihandzclient.model.Comment;
import com.lzt.neihandzclient.model.DisLike;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.model.Like;
import com.lzt.neihandzclient.retrofit.ApiCallback;
import com.lzt.neihandzclient.retrofit.ApiService;
import com.lzt.neihandzclient.view.AttentionView;
import com.lzt.neihandzclient.view.CommentView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class CommentPresenter extends BasePresenter<CommentView> {
    private Map<String, Object> parmars = new HashMap<>();
    private Map<String, Object> map = new HashMap<>();
    private Map<String, Object> attentionMap = new HashMap<>();

    public CommentPresenter(CommentView commentView) {
        attachView(commentView);
    }

    public void getComment(int homeId) {
        parmars.put("type", "select");
        parmars.put("homeId", homeId);
        mvpView.showLoading();
        addSubscription(api.getComment(parmars), new ApiCallback<Comment>() {
            @Override
            public void onSuccess(Comment model) {
                mvpView.getCommentSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void getLike(int homeId) {
        parmars.put("type", "select");
        parmars.put("homeId", homeId);
        //mvpView.showLoading();
        addSubscription(api.getLike(parmars), new ApiCallback<Like>() {
            @Override
            public void onSuccess(Like model) {
                mvpView.getLikeSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void getDisLike(int homeId) {
        parmars.put("type", "select");
        parmars.put("homeId", homeId);
        //mvpView.showLoading();
        addSubscription(api.getDisLike(parmars), new ApiCallback<DisLike>() {

            @Override
            public void onSuccess(DisLike model) {
                mvpView.getDisLikeSuccess(model);

            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void getCollection(int homeId) {
        map.put("type", "selectAll");
        map.put("homeId", homeId);
        //mvpView.showLoading();
        addSubscription(api.getCollection(map), new ApiCallback<Collection>() {

            @Override
            public void onSuccess(Collection model) {
                mvpView.getCollectionSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void getAttention(int userId) {
        attentionMap.put("type", "select");
        attentionMap.put("my", userId);
        //mvpView.showLoading();
        addSubscription(api.getAttention(attentionMap), new ApiCallback<Attention>() {

            @Override
            public void onSuccess(Attention model) {
                mvpView.getAttentionSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void addComment(Map<String, Object> parmars) {
//        mvpView.showLoading();
        addSubscription(api.addComment(parmars), new ApiCallback<Comment>() {
            @Override
            public void onSuccess(Comment model) {
                mvpView.addCommentSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void addLike(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.addLike(parmars), new ApiCallback<Like>() {
            @Override
            public void onSuccess(Like model) {
                mvpView.addLikeSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void addDisLike(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.addDisLike(parmars), new ApiCallback<DisLike>() {
            @Override
            public void onSuccess(DisLike model) {
                mvpView.addDisLikeSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void addCollection(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.addCollection(parmars), new ApiCallback<Collection>() {
            @Override
            public void onSuccess(Collection model) {
                mvpView.addCollectionSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void addAttention(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.addAttention(parmars), new ApiCallback<Attention>() {
            @Override
            public void onSuccess(Attention model) {
                mvpView.addAttentionSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }

        });
    }

    public void delCollection(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.delCollection(parmars), new ApiCallback<Collection>() {
            @Override
            public void onSuccess(Collection model) {
                mvpView.delCollectionSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {
                mvpView.hideLoading();
            }
        });
    }
}
