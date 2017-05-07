package com.lzt.neihandzclient.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.ui.adapter.PhotoAdapter;
import com.lzt.neihandzclient.appliction.BaseAppliction;
import com.lzt.neihandzclient.base.BaseMvpActivity;
import com.lzt.neihandzclient.model.SendModel;
import com.lzt.neihandzclient.presenter.SendPresenter;
import com.lzt.neihandzclient.utils.EmptyUtil;
import com.lzt.neihandzclient.utils.RequestUtil;
import com.lzt.neihandzclient.view.SendView;
import com.orhanobut.logger.Logger;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mabeijianxi.camera.MediaRecorderActivity;
import mabeijianxi.camera.model.AutoVBRMode;
import mabeijianxi.camera.model.BaseMediaBitrateConfig;
import mabeijianxi.camera.model.MediaRecorderConfig;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public class SendActivity extends BaseMvpActivity<SendPresenter> implements SendView {
    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.send)
    TextView send;
    @Bind(R.id.edit)
    EditText edit;
    @Bind(R.id.rvResultPhoto)
    RecyclerView rvResultPhoto;
    @Bind(R.id.sendPic)
    ImageView sendPic;
    @Bind(R.id.sendVideo)
    ImageView sendVideo;
    @Bind(R.id.btnSelector)
    Button btnSelector;
    @Bind(R.id.tilteBar)
    RelativeLayout tilteBar;
    @Bind(R.id.thumbPic)
    ImageView thumbPic;
    @Bind(R.id.lina)
    LinearLayout lina;
    @Bind(R.id.lina1)
    LinearLayout lina1;
    private String TAG = "Lzt";
    private Context mContext;
    private Activity mActivity;
    private IHandlerCallBack iHandlerCallBack;
    private final int PERMISSIONS_REQUEST_READ_CONTACTS = 8;

    private PhotoAdapter photoAdapter;

    private List<String> path = new ArrayList<>();
    private List<String> videoPath = new ArrayList<>();
    private GalleryConfig galleryConfig;
    private String type;
    private String videoUrl, thumbUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        ButterKnife.bind(this);
        mContext = this;
        mActivity = this;
        initGallery();
        init();
    }

    @Override
    protected SendPresenter createPresenter() {
        return new SendPresenter(this);
    }


    public void init() {
        //初始化相册
        galleryConfig = BaseAppliction.initGallery(iHandlerCallBack, path);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvResultPhoto.setLayoutManager(gridLayoutManager);
        photoAdapter = new PhotoAdapter(this, path);
        rvResultPhoto.setAdapter(photoAdapter);
        videoUrl = getIntent().getStringExtra(MediaRecorderActivity.VIDEO_URI);
        thumbUrl = getIntent().getStringExtra(MediaRecorderActivity.VIDEO_SCREENSHOT);
        if (videoUrl != null && thumbUrl != null) {
            videoPath.add(videoUrl);
            videoPath.add(thumbUrl);
        }

        Bitmap bitmap = BitmapFactory.decodeFile(thumbUrl);
        thumbPic.setImageBitmap(bitmap);
    }

    // 授权管理
    private void initPermissions() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(SendActivity.this);
        }
    }

    public void go() {
        //初始化摄像路径
        BaseAppliction.initSmallVideo(this);
        MediaRecorderConfig config = new MediaRecorderConfig.Buidler()
                .doH264Compress(new AutoVBRMode()
                        .setVelocity(BaseMediaBitrateConfig.Velocity.ULTRAFAST)
                )
                .setMediaBitrateConfig(new AutoVBRMode()
                        .setVelocity(BaseMediaBitrateConfig.Velocity.ULTRAFAST)
                )
                .smallVideoWidth(480)
                .smallVideoHeight(480)
                .recordTimeMax(10 * 1000)
                .maxFrameRate(20)
                .captureThumbnailsTime(1)
                .recordTimeMin((int) (1.5 * 1000))
                .build();
        MediaRecorderActivity.goSmallVideoRecorder(this, SendActivity.class.getName(), config);
        if (videoPath.size() != 0) {
            finish();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "同意授权");
                GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(SendActivity.this);
            } else {
                Log.i(TAG, "拒绝授权");
            }
        }
    }


    private void initGallery() {
        iHandlerCallBack = new IHandlerCallBack() {
            @Override
            public void onStart() {
                Log.i(TAG, "onStart: 开启");
            }

            @Override
            public void onSuccess(List<String> photoList) {
                Log.i(TAG, "onSuccess: 返回数据");
                path.clear();
                for (String s : photoList) {
                    Log.i(TAG, s);
                    path.add(s);
                }
                photoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancel() {
                Log.i(TAG, "onCancel: 取消");
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "onFinish: 结束");
            }

            @Override
            public void onError() {
                Log.i(TAG, "onError: 出错");
            }
        };

    }

    @OnClick({R.id.back, R.id.send, R.id.sendPic, R.id.sendVideo, R.id.btnSelector, R.id.thumbPic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.send:
                send();
                break;
            case R.id.sendPic:
                Toast.makeText(SendActivity.this, "", Toast.LENGTH_LONG).show();
                galleryConfig.getBuilder().maxSize(9).build();
                galleryConfig.getBuilder().isOpenCamera(false).build();
                initPermissions();
                break;
            case R.id.sendVideo:
                go();
                break;
            case R.id.btnSelector:
                Intent intent = new Intent(mContext, TitleBarActivity.class);
                startActivityForResult(intent, 001);
                break;
            case R.id.thumbPic:
                Intent intentVideo = new Intent(mContext, VideoPlayerActivity.class);
                intentVideo.putExtra("videoUrl", videoUrl);
                startActivity(intentVideo);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 001 && resultCode == 002 && data.getStringExtra("title") != null) {
            btnSelector.setText(data.getStringExtra("title"));
            type = data.getStringExtra("type");
        }
    }

    public void send() {
        String content = edit.getText().toString();
        if (!EmptyUtil.isEmpty(content) && !EmptyUtil.isEmpty(type)) {
            if (path.size() != 0) {
                Map<String, RequestBody> parmars = new HashMap<>();
                parmars.put("userId", RequestUtil.create("41"));
                parmars.put("sendContent", RequestUtil.create(content));
                parmars.put("type", RequestUtil.create(type));
                for (int i = 0; i < path.size(); i++) {
                    File file = new File(path.get(i));
                    parmars.put("file" + i + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
                }
                mvpPresenter.sendPic(parmars);
            } else if (videoPath.size() != 0) {
                Map<String, RequestBody> parmars = new HashMap<>();
                parmars.put("userId", RequestUtil.create("41"));
                parmars.put("sendContent", RequestUtil.create(content));
                parmars.put("type", RequestUtil.create(type));
                for (int i = 0; i < videoPath.size(); i++) {
                    File file = new File(videoPath.get(i));
                    parmars.put("file" + i + "\"; filename=\"" + file.getName(), RequestBody.create(MediaType.parse("media/*"), file));
                }
                mvpPresenter.sendVideo(parmars);
            } else {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("userId", 41);
                map.put("sendContent", content);
                map.put("type", type);
                mvpPresenter.sendText(map);
            }
        } else {
            toastShow("内容不能为空");
        }
    }

    @Override
    public void getDataSuccess(SendModel model) {
        Logger.i("成功");
    }

    @Override
    public void getDataFail(String msg) {
        Logger.i(msg);
    }
}
