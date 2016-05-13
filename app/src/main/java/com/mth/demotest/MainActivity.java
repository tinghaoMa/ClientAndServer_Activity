package com.mth.demotest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import sohuvideo.jar_test.StatusBarCompat;

public class MainActivity extends Activity {
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarCompat.compat(this, Color.TRANSPARENT);
//        changeStatusBarColor();
        setContentView(R.layout.activity_main);
        mBt = (Button) findViewById(R.id.id_click);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, BActivity.class);
                startActivity(intent);
            }
        });

        Log.e("MTH", "dimen====" + getResources().getDimension(R.dimen.mth));
        int v = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.mth), getResources().getDisplayMetrics());
        Log.e("MTH", "值====" + v);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void changeStatusBarColor() {
        Log.e("MTH", "Build.VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Log.e("MTH", "changeStatusBarColor");
            getWindow().setStatusBarColor(Color.BLUE);
            return;
        } else {
            Log.e("MTH", "error");
        }
    }
}
