package com.zs.itking.xuidemo.view.activity;

import android.os.Bundle;
import android.view.KeyEvent;

import com.xuexiang.xui.utils.KeyboardUtils;
import com.xuexiang.xui.utils.StatusBarUtils;
import com.xuexiang.xutil.display.Colors;
import com.zs.itking.xuidemo.common.Constant;
import com.zs.itking.xuidemo.view.fragment.LoginFragment;

/**
 * created by on 2021/10/2
 * 描述：
 *
 * @author ZSAndroid
 * @create 2021-10-02-16:45
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity传递数据到Fragment
        Bundle params = new Bundle();
        params.putString(Constant.KEY_EVENT_DATA, "LoginActivity携带数据");
        openPage(LoginFragment.class,params);

    }

    @Override
    protected void initStatusBarStyle() {
        StatusBarUtils.initStatusBarStyle(this, false, Colors.TRANSPARENT);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return KeyboardUtils.onDisableBackKeyDown(keyCode) && super.onKeyDown(keyCode, event);
    }
}
