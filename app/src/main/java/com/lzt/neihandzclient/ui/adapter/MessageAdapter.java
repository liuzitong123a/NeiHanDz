package com.lzt.neihandzclient.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.model.Message;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/29.
 */

public class MessageAdapter extends BaseQuickAdapter<Message,BaseViewHolder> {
    public MessageAdapter(List<Message> data) {
        super(R.layout.item_message, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Message message) {
        baseViewHolder.setText(R.id.text, message.getTitle());
        baseViewHolder.setImageResource(R.id.image1, message.getImage());
    }
}
