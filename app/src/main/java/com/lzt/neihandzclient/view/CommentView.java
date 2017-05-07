package com.lzt.neihandzclient.view;

import com.lzt.neihandzclient.base.BaseView;
import com.lzt.neihandzclient.model.Attention;
import com.lzt.neihandzclient.model.Collection;
import com.lzt.neihandzclient.model.Comment;
import com.lzt.neihandzclient.model.DisLike;
import com.lzt.neihandzclient.model.HomeModel;
import com.lzt.neihandzclient.model.Like;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public interface CommentView extends BaseView {
    //添加评论、点赞、点踩、收藏、关注
    void addCommentSuccess(Comment model);

    void addLikeSuccess(Like model);

    void addDisLikeSuccess(DisLike model);

    void addCollectionSuccess(Collection model);

    void addAttentionSuccess(Attention attention);

    //查询评论、点赞、点踩、收藏、关注
    void getCommentSuccess(Comment model);

    void getLikeSuccess(Like model);

    void getDisLikeSuccess(DisLike model);

    void getCollectionSuccess(Collection model);

    void getAttentionSuccess(Attention attention);

    //删除收藏
    void delCollectionSuccess(Collection model);

    //错误反馈
    void getDataFail(String msg);
}
