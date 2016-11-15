package com.example.zhuwo.intent_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by zhuwo on 2016/11/14.
 */

public class SActivity extends Activity{
    private Button bt;
    private String content = "你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        /*
         *第二个页面什么时候给第一个页面回传数据
         *回传第一个页面的实际上是一个Intent对象
         */
        bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不需要在此回传数据，因为只是要做一个跳转
                Intent data = new Intent();
                data.putExtra("data", content);
                //这个2代表是这个页面回传的数据
                setResult(2, data);
                //结束当前页面
                finish();
            }
        });

    }


}
