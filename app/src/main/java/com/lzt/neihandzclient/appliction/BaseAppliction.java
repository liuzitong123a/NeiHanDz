package com.lzt.neihandzclient.appliction;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.lzt.neihandzclient.utils.GlideImageLoader;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.inter.IHandlerCallBack;

import java.io.File;
import java.util.List;

import mabeijianxi.camera.VCamera;
import mabeijianxi.camera.util.DeviceUtils;

/**
 * Created by liuzitong on 2017/4/22.
 */

public class BaseAppliction extends Application {
    private static BaseAppliction instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static void initSmallVideo(Context context) {
        // 设置拍摄视频缓存路径
        File dcim = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (DeviceUtils.isZte()) {
            if (dcim.exists()) {
                VCamera.setVideoCachePath(dcim + "/mabeijianxi/");
            } else {
                VCamera.setVideoCachePath(dcim.getPath().replace("/sdcard/",
                        "/sdcard-ext/")
                        + "/mabeijianxi/");
            }
        } else {
            VCamera.setVideoCachePath(dcim + "/mabeijianxi/");
        }
        VCamera.setDebugMode(true);
        VCamera.initialize(context);
    }

    //初始化相册
    public static GalleryConfig initGallery(IHandlerCallBack iHandlerCallBack, List<String> path) {
        GalleryConfig galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.yancy.gallerypickdemo.fileprovide")   // provider(必填)
                .pathList(path)                         // 记录已选的图片
                .multiSelect(false)                      // 是否多选   默认：false
                .multiSelect(false, 9)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(9)                             // 配置多选时 的多选数量。    默认：9
                .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(true)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery/Pictures")          // 图片存放路径
                .build();
        galleryConfig.getBuilder().multiSelect(true).build();
        galleryConfig.getBuilder().imageLoader(new GlideImageLoader()).build();
        return galleryConfig;
    }


    public static BaseAppliction getInstance() {
        return instance;
    }

}
