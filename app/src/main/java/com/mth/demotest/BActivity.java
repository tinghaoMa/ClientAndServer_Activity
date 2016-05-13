package com.mth.demotest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import sohuvideo.jar_test.JarTest;


public class BActivity extends Activity {

    private Button mBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mBt = (Button) findViewById(R.id.id_click);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BActivity.this, BActivity.class);
                startActivity(intent);
            }
        });
        new JarTest().test();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("tag", "onNewIntent");
    }
}
