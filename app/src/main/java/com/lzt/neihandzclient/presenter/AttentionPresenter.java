package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.retrofit.ApiCallback;
import com.lzt.neihandzclient.view.AttentionView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public class AttentionPresenter extends BasePresenter<AttentionView> {

    public AttentionPresenter(AttentionView view) {
        attachView(view);
    }

    public void getAttention(int myId) {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "select");
        parmars.put("my", myId);
        mvpView.showLoading();
        addSubscription(api.getAttention(parmars), new ApiCallback<Attention>() {
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

    public void delAttention(int attentionId) {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "delete");
        parmars.put("attentionId", attentionId);
        mvpView.showLoading();
        addSubscription(api.delAttention(parmars), new ApiCallback<Attention>() {
            @Override
            public void onSuccess(Attention model) {
                mvpView.delAttentionSuccess(model);
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
