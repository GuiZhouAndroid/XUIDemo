package com.zs.itking.xuidemo;

import android.app.Application;
import android.content.Context;

import com.xuexiang.xpage.PageConfig;
import com.xuexiang.xpage.PageConfiguration;
import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xpage.config.AppPageConfig;
import com.xuexiang.xpage.model.PageInfo;
import com.xuexiang.xui.XUI;
import com.zs.itking.xuidemo.utils.BasicLibInit;
import com.zs.itking.xuidemo.view.activity.BaseActivity;

import java.util.List;

/**
 * created by on 2021/10/2
 * 描述：
 *
 * @author ZSAndroid
 * @create 2021-10-02-14:11
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        BasicLibInit.init(this);
        super.onCreate();
    }

    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
