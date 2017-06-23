package com.fuicuiedu.xc.butterknife_20170622;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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

    @BindString(R.string.app_name)
    String app;

    //绑定视图列表
    @BindViews({R.id.main_tv1, R.id.main_tv2, R.id.main_tv3})
    List<TextView> textViews;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//alt + insert 使用Butterknife插件

        //Butterknife绑定！！！
        unbinder = ButterKnife.bind(this);

        textView1.setText(app);
        textView2.setText(app);
        textView3.setText(app);


        //当绑定到集合中，需要整体发生修改时怎么办？
        //提供了一个apply方法。不过需要实现action或者setter接口。

        //action
        ButterKnife.apply(textViews, new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setText("哈哈哈哈哈哈哈");
            }
        });

        //setter
        ButterKnife.apply(textViews, new ButterKnife.Setter<TextView, String>() {
            @Override
            public void set(@NonNull TextView view, String value, int index) {

            }
        }, "呵呵呵呵呵");

//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //设置点击事件
//            }
//        });
    }

//    @OnClick(R.id.main_btn1)
//    public void onClick1(){
//        //设置点击事件
//        Toast.makeText(this, "点击了main_btn1", Toast.LENGTH_SHORT).show();
//    }
//
//    @OnClick(R.id.main_btn2)
//    public void onClick2(){
//        //设置点击事件
//        Toast.makeText(this, "点击了main_btn2", Toast.LENGTH_SHORT).show();
//    }
//
//    @OnClick(R.id.main_btn3)
//    public void onClick3(){
//        //设置点击事件
//        Toast.makeText(this, "点击了main_btn3", Toast.LENGTH_SHORT).show();
//    }

    @OnClick({R.id.main_btn1, R.id.main_btn2, R.id.main_btn3})
    public void onClick1(View v) {
        switch (v.getId()) {
            case R.id.main_btn1:
                Toast.makeText(this, "1111111", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn2:
                Toast.makeText(this, "2222222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_btn3:
                Toast.makeText(this, "3333333", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife解绑!!!
        unbinder.unbind();
    }


    //使用插件，生成代码
    @OnClick({R.id.main_btn111111, R.id.main_btn222222})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn111111:
                break;
            case R.id.main_btn222222:
                break;
        }
    }
}
