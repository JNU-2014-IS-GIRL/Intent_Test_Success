package com.example.zhuwo.intent_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zhuwo on 2016/11/14.
 */

public class FActivity extends Activity{
    private Button bt1;
    private Button bt2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);
    /*
     *通过点击bt1实现页面之间的跳转
     *   1.startActivity的方式来实现
     *   1>初始化Intent
     */
        tv = (TextView) findViewById(R.id.textView1);
        bt1 = (Button)findViewById(R.id.button1_first);
        bt2 = (Button) findViewById(R.id.button2_second);

        //注册点击事件
        //这里和视频不太一样
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第一个参数，是上下文对象this，
                //第二个参数，是目标文件
                Intent intent = new Intent(FActivity.this, SActivity.class );
                //下面需要通过一个startactivity来执行这个跳转
                startActivity(intent);
            }
        });

        /*
         *通过startActivityForresult
         *
         */
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FActivity.this, SActivity.class);
                /*
                 *第一个参数是Intent参数
                 * 第二个参数是请求的一个标识， 是int类型
                 */
                startActivityForResult(intent, 1);
            }
        });

    }

    /*
     *通过startActivityForResult跳转，返回启动接收数据的方法
      * requestCode:请求的标识（用这个标识可以接收不同的返回数据）
      * resultCode:第二个页面返回的标识
      * （通过这个可以知道是哪个页面返回的数据）
      * data:第二个页面回传的数据
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1&&resultCode == 2){
            String content = data.getStringExtra("data");
            tv.setText(content);
        }
    }
}
