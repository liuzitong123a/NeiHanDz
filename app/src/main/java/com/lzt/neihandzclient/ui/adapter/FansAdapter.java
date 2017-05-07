package com.lzt.neihandzclient.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.retrofit.ApiService;
import com.lzt.neihandzclient.utils.GlideCircleTransform;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/5/1.
 */

public class FansAdapter extends BaseQuickAdapter<Attention.ListBean,BaseViewHolder> {
    public FansAdapter(List<Attention.ListBean> data) {
        super(R.layout.activity_fans_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Attention.ListBean listBean) {
        baseViewHolder.setText(R.id.text, listBean.getUser().getNickName());
        ImageView imageView = baseViewHolder.getView(R.id.image1);
        Glide.with(mContext).load(ApiService.API_SERVER_URL + listBean.getUser().getPath()).transform(new GlideCircleTransform(mContext)).into(imageView);
        baseViewHolder.addOnClickListener(R.id.button);
    }
}
