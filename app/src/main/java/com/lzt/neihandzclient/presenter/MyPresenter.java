package com.lzt.neihandzclient.presenter;

import com.lzt.neihandzclient.base.BasePresenter;
import com.lzt.neihandzclient.view.MyView;

/**
 * Created by 刘子樋 on 2017/5/1.
 */

public class MyPresenter extends BasePresenter {
    public MyPresenter(MyView view) {
        attachView(view);
    }
}
