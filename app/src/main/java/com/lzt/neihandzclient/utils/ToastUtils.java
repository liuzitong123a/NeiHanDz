package com.lzt.neihandzclient.utils;

import android.widget.Toast;

import com.lzt.neihandzclient.appliction.BaseAppliction;


public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示Toast
     */
    public static void showToast( CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseAppliction.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }


}
