package com.lzt.neihandzclient.ui.weight;


import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.drawable.ColorDrawable;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;

import com.lzt.neihandzclient.R;

public class CustomPopupWindow extends PopupWindow implements OnClickListener {
    private Button btnSend;
    private View mPopView;
    private OnItemClickListener mListener;
    private EditText editText;
    private Handler handler;

    public CustomPopupWindow(Context context, Handler handler) {
        super(context);
        init(context);
        setPopupWindow();
        this.handler = handler;
        btnSend.setOnClickListener(this);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // 绑定布局
        mPopView = inflater.inflate(R.layout.custom_popup_window, null);
        editText = (EditText) mPopView.findViewById(R.id.edit);
        btnSend = (Button) mPopView.findViewById(R.id.send);
    }

    /**
     * 设置窗口的相关属性
     */
    @SuppressLint("InlinedApi")
    private void setPopupWindow() {
        this.setContentView(mPopView);// 设置View
        this.setWidth(LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        this.setAnimationStyle(R.style.mypopwindow_anim_style);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
        mPopView.setOnTouchListener(new View.OnTouchListener() {// 如果触摸位置在窗口外面则销毁
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = mPopView.findViewById(R.id.id_pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
    }

    /**
     * 定义一个接口，公布出去 在Activity中操作按钮的单击事件
     */
    public interface OnItemClickListener {
        void setOnItemClick(View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.setOnItemClick(v);
        }
        Message message = new Message();
        message.obj = editText.getText().toString();
        handler.sendMessage(message);
    }
}