package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.retrofit.ApiCallback;
import com.lzt.neihandzclient.view.FansView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘子樋 on 2017/4/30.
 */

public class FansPresenter extends BasePresenter<FansView> {
    public FansPresenter(FansView view) {
        attachView(view);
    }

    public void getFans(int otherId) {
        Map<String, Object> parmars = new HashMap<>();
        parmars.put("type", "selectAll");
        parmars.put("otherId", otherId);
        mvpView.showLoading();
        addSubscription(api.getFans(parmars), new ApiCallback<Attention>() {


            @Override
            public void onSuccess(Attention model) {
                mvpView.getFansSuccess(model);
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
