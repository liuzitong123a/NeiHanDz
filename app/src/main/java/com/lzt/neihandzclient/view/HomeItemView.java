package com.lzt.neihandzclient.view;

import com.lzt.neihandzclient.base.BaseView;
import com.lzt.neihandzclient.model.HomeCount;
import com.lzt.neihandzclient.model.HomeModel;

/**
 * Created by 刘子樋 on 2017/4/24.
 */

public interface HomeItemView extends BaseView {
    void getDataSuccess(HomeModel model);

    void getCountSuccess(HomeCount count);

    void getDataFail(String msg);
}
