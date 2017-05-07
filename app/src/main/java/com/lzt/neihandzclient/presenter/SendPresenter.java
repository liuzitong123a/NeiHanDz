package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.model.SendModel;
import com.lzt.neihandzclient.retrofit.ApiCallback;
import com.lzt.neihandzclient.ui.activity.SendActivity;
import com.lzt.neihandzclient.view.HomeItemView;
import com.lzt.neihandzclient.view.SendView;

import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public class SendPresenter extends BasePresenter<SendView> {
    public SendPresenter(SendView view) {
        attachView(view);
    }

    public void sendPic(@PartMap Map<String, RequestBody> params) {
        mvpView.showLoading();
        addSubscription(api.sendPic(params), new ApiCallback<SendModel>() {
            @Override
            public void onSuccess(SendModel model) {
                mvpView.getDataSuccess(model);
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

    public void sendVideo(@PartMap Map<String, RequestBody> params) {
        mvpView.showLoading();
        addSubscription(api.sendVideo(params), new ApiCallback<SendModel>() {
            @Override
            public void onSuccess(SendModel model) {
                mvpView.getDataSuccess(model);
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

    public void sendText(Map<String, Object> parmars) {
        mvpView.showLoading();
        addSubscription(api.sendText(parmars), new ApiCallback<SendModel>() {
            @Override
            public void onSuccess(SendModel model) {
                mvpView.getDataSuccess(model);
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
