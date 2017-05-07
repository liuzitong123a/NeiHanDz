package com.lzt.neihandzclient.view;

import com.lzt.neihandzclient.base.BaseView;
import com.lzt.neihandzclient.model.Attention;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public interface AttentionView extends BaseView {

    void getAttentionSuccess(Attention attention);

    void delAttentionSuccess(Attention attention);

    //错误反馈
    void getDataFail(String msg);

}
