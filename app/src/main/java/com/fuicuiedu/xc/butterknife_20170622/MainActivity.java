package com.fuicuiedu.xc.butterknife_20170622;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //当行复制 ctrl + d
    //当行删除 ctrl + y
    //格式化代码 ctrl + alt + l

    @BindView(R.id.main_tv1)
    TextView textView1;
    @BindView(R.id.main_tv2)
    TextView textView2;
    @BindView(R.id.main_tv3)
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Butterknife绑定！！！
        ButterKnife.bind(this);

        textView1.setText("面对疾风吧！11111");
        textView2.setText("面对疾风吧！222222");
        textView3.setText("面对疾风吧！333333");
    }
}
