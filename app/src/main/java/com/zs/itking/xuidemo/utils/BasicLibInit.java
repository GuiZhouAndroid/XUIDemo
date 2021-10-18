package com.zs.itking.xuidemo.utils;

import android.app.Application;
import android.content.Context;

import com.xuexiang.xpage.PageConfig;
import com.xuexiang.xpage.PageConfiguration;
import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xpage.config.AppPageConfig;
import com.xuexiang.xpage.model.PageInfo;
import com.xuexiang.xui.XUI;
import com.xuexiang.xutil.XUtil;
import com.zs.itking.xuidemo.MyApplication;
import com.zs.itking.xuidemo.view.activity.BaseActivity;

import java.util.List;

/**
 * created by on 2021/10/2
 * 描述：
 *
 * @author ZSAndroid
 * @create 2021-10-02-17:02
 */
public class BasicLibInit {

    private BasicLibInit() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化基础库
     */
    public static void init(Application application) {
        XUI.init(application); //初始化UI框架
        XUI.debug(true);
        initPage(application);
        initUtils(application);

    }

    /**
     * 初始化工具类
     *
     * @param application
     */
    private static void initUtils(Application application) {
        XUtil.init(application);
        XUtil.debug(MyApplication.isDebug());
    }

    /**
     * 初始化XPage页面框架
     *
     * @param application
     */
    private static void initPage(Application application) {
        //自动注册页面
        PageConfig.getInstance()
                .setPageConfiguration(new PageConfiguration() { //页面注册
                    @Override
                    public List<PageInfo> registerPages(Context context) {
                        //自动注册页面,是编译时自动生成的，build一下就出来了。如果你还没使用@Page的话，暂时是不会生成的。
                        return AppPageConfig.getInstance().getPages(); //自动注册页面
                    }
                })
                .debug(MyApplication.isDebug() ? "PageLog" : null)
                .setContainActivityClazz(XPageActivity.class)
                .init(application);
    }
}
