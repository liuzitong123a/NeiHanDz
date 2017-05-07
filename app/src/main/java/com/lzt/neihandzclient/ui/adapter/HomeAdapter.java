package com.lzt.neihandzclient.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.retrofit.ApiService;
import com.lzt.neihandzclient.utils.GlideCircleTransform;
import com.lzt.neihandzclient.ui.weight.MyPlayerView;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 刘子樋 on 2017/4/24.
 */

/**
 * 这种Adapter类可以直接在Activity中用匿名内部类方式实现,这样就不用创建不同的adapter了,
 * 以后可以只用这一个MyMultitypeItemAdapter给多个界面的RecyclerView,只要设置addItemType()
 * 和不同的bean即可,无需设置holder
 */
public class HomeAdapter extends BaseMultiItemQuickAdapter<HomeModel.ListBean,BaseViewHolder> {

    private List<HomeModel.ListBean> data;

    public HomeAdapter(List<HomeModel.ListBean> data) {
        super(data);
        this.data = data;
        addItemType(0, R.layout.item_home_text);
        addItemType(1, R.layout.item_home_pic);
        addItemType(2, R.layout.item_home_video);
    }


    @Override
    public int getItemViewType(int position) {
        if (data.get(position).getHomeurl().contains(".mp4")) {
            return 2;
        } else if (data.get(position).getHomeurl().equals("")) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomeModel.ListBean listBean) {
        baseViewHolder.setText(R.id.nickName, listBean.getUser().getNickName());
        baseViewHolder.setText(R.id.time, listBean.getHomeTime());
        baseViewHolder.setText(R.id.likeTimes, String.valueOf(listBean.getLikeCount()));
        baseViewHolder.setText(R.id.notLikeTimes, String.valueOf(listBean.getDisLikeCount()));
        baseViewHolder.setText(R.id.commentTimes, String.valueOf(listBean.getCommentCount()));
        baseViewHolder.setText(R.id.collectionTimes, String.valueOf(listBean.getColCount()));
        ImageView header = baseViewHolder.getView(R.id.header);
        Glide.with(mContext).load(ApiService.API_SERVER_URL + listBean.getUser().getPath()).transform(new GlideCircleTransform(mContext)).into(header);
        switch (baseViewHolder.getItemViewType()) {
            case 0:
                baseViewHolder.setText(R.id.textContents, listBean.getHomeContent());
                break;
            case 1:
                NineGridView nineGridView = baseViewHolder.getView(R.id.nineGrid);
                ArrayList<ImageInfo> imageInfo = new ArrayList<>();
                String imageUrls[] = listBean.getHomeurl().split(",");
                for (int i = 0; i < imageUrls.length; i++) {
                    ImageInfo info = new ImageInfo();
                    info.setThumbnailUrl(ApiService.API_SERVER_URL + imageUrls[i]);
                    info.setBigImageUrl(ApiService.API_SERVER_URL + imageUrls[i]);
                    imageInfo.add(info);
                }
                nineGridView.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
                baseViewHolder.setText(R.id.content, listBean.getHomeContent());
                break;
            case 2:
                baseViewHolder.setText(R.id.item_view_contentId, listBean.getHomeContent());
                final MyPlayerView videoPlayer = baseViewHolder.getView(R.id.videoPlayer);
                Glide.with(mContext).load(ApiService.API_SERVER_URL + listBean.getHomePic()).into(videoPlayer.thumbImageView);
                videoPlayer.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                setPlayer(videoPlayer, listBean);
                break;
        }
    }

    private void setPlayer(JCVideoPlayerStandard videoPlayer, HomeModel.ListBean listBean) {
        videoPlayer.setUp(ApiService.API_SERVER_URL + listBean.getHomeurl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, listBean.getHomeContent());

    }
}