package com.lzt.neihandzclient.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class RequestUtil {
    public static RequestBody create(String message) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("form-data"), message);
        return requestBody;
    }
}
