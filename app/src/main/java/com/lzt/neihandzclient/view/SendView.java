package com.lzt.neihandzclient.view;

import com.lzt.neihandzclient.base.BaseView;
import com.lzt.neihandzclient.model.SendModel;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public interface SendView extends BaseView {
    void getDataSuccess(SendModel model);

    void getDataFail(String msg);
}
