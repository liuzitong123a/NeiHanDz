package com.lzt.neihandzclient.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.model.Comment;
import com.lzt.neihandzclient.retrofit.ApiService;
import com.lzt.neihandzclient.utils.GlideCircleTransform;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class CommentAdapter extends BaseQuickAdapter<Comment.ListBean,BaseViewHolder> {

    public CommentAdapter(List<Comment.ListBean> data) {
        super(R.layout.comment_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Comment.ListBean listBean) {
        baseViewHolder.setText(R.id.commentName, listBean.getUser().getNickName());
        baseViewHolder.setText(R.id.commentContent, listBean.getCommentContent());
        baseViewHolder.setText(R.id.time, listBean.getCommentDate());
        ImageView imageView = baseViewHolder.getView(R.id.commentHeader);
        Glide.with(mContext).load(ApiService.API_SERVER_URL + listBean.getUser().getPath()).transform(new GlideCircleTransform(mContext)).into(imageView);
    }


}
