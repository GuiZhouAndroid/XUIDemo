package com.zs.itking.xuidemo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zs.itking.xuidemo.R;

public class MainActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void id(View view) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}