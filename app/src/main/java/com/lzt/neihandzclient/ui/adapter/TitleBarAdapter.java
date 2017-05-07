package com.lzt.neihandzclient.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzt.neihandzclient.R;
import com.lzt.neihandzclient.model.TitleBar;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/26.
 */

public class TitleBarAdapter extends BaseQuickAdapter<TitleBar,BaseViewHolder> {


    public TitleBarAdapter(List<TitleBar> data) {
        super(R.layout.item_titlebar, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TitleBar titleBar) {
        baseViewHolder.setText(R.id.tilte_text,titleBar.getTitle());
        baseViewHolder.setImageResource(R.id.title_icon,titleBar.getResouce());
    }
}
