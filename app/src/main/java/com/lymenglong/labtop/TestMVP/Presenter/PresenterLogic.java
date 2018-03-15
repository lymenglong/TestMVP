package com.lymenglong.labtop.TestMVP.Presenter;

import android.widget.TextView;

import com.lymenglong.labtop.TestMVP.View.ViewWork;

/**
 * Created by KHAIMINH2 on 3/15/2018.
 */

public class PresenterLogic implements PresenterImp {
    private ViewWork viewWork;

    public PresenterLogic(ViewWork viewWork) {
        this.viewWork = viewWork;
    }

    @Override
    public void DoWork(TextView textView, String s) {
        if (s.equals("Hello")){
            textView.setText(s);
            viewWork.WorkDone();
        } else
        {
            viewWork.WorkFailed();
        }

    }
}
