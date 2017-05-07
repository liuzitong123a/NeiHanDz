package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.model.HomeCount;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.retrofit.ApiCallback;
import com.lzt.neihandzclient.view.HomeItemView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘子樋 on 2017/4/24.
 */

public class HomeItemPresenter extends BasePresenter<HomeItemView> {
    public HomeItemPresenter(HomeItemView view) {
        attachView(view);
    }

    public void getHomeList(int type, int pageNo) {
        mvpView.showLoading();
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("style", "select");
        parmars.put("type", type);
        parmars.put("pageNo", pageNo);
        addSubscription(api.getHomeList(parmars), new ApiCallback<HomeModel>() {
            @Override
            public void onSuccess(HomeModel model) {
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

    public void getHomeCount(int type) {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("style", "count");
        parmars.put("type", type);
        addSubscription(api.getHomeCount(parmars), new ApiCallback<HomeCount>() {
            @Override
            public void onSuccess(HomeCount model) {
                mvpView.getCountSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.getDataFail(msg);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
