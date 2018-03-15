package com.lymenglong.labtop.TestMVP.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lymenglong.labtop.TestMVP.Presenter.PresenterLogic;
import com.lymenglong.labtop.TestMVP.R;

import static android.content.ContentValues.TAG;

public class ViewActivity extends Activity implements ViewWork, View.OnClickListener{
    private TextView textView ;
    private Button button;
    private EditText editText;
    PresenterLogic presenterLogic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_name);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        presenterLogic = new PresenterLogic(this);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button : {
                String s = editText.getText().toString();
                //call presenter logic to do work
                presenterLogic.DoWork(textView, s);
                Log.d(TAG, "onClick: "+ s);
            }
                break;
        }

    }
    //callback from viewWork in presenter logic class
    @Override
    public void WorkDone() {
        Toast.makeText(this, "Work Done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void WorkFailed() {
        Toast.makeText(this, "Work Failed", Toast.LENGTH_SHORT).show();
    }
}
