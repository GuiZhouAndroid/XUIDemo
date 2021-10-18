package com.zs.itking.xuidemo.view.activity;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xpage.core.CoreSwitchBean;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.widget.slideback.SlideBack;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * created by on 2021/10/2
 * 描述：
 *
 * @author ZSAndroid
 * @create 2021-10-02-15:12
 */
@Keep
public class BaseActivity extends XPageActivity {
    /**
     * 是否支持侧滑返回
     */
    public static final String KEY_SUPPORT_SLIDE_BACK = "key_support_slide_back";

    Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initStatusBarStyle();
        super.onCreate(savedInstanceState);
        mUnbinder = ButterKnife.bind(this);
        registerSlideBack();
    }

    /**
     * 初始化状态栏的样式
     */
    protected void initStatusBarStyle() {

    }


    @Override
    protected void onRelease() {
        mUnbinder.unbind();
        unregisterSlideBack();
        super.onRelease();
    }

    /**
     * 注册侧滑回调
     */
    protected void registerSlideBack() {
        if (isSupportSlideBack()) {
            SlideBack.with(this)
                    .haveScroll(true)
                    .edgeMode(ResUtils.isRtl() ? SlideBack.EDGE_RIGHT : SlideBack.EDGE_LEFT)
                    .callBack(this::popPage)
                    .register();
        }
    }

    /**
     * @return 是否支持侧滑返回
     */
    protected boolean isSupportSlideBack() {
        CoreSwitchBean page = getIntent().getParcelableExtra(CoreSwitchBean.KEY_SWITCH_BEAN);
        return page == null || page.getBundle() == null || page.getBundle().getBoolean(KEY_SUPPORT_SLIDE_BACK, true);
    }

    /**
     * 注销侧滑回调
     */
    protected void unregisterSlideBack() {
        if (isSupportSlideBack()) {
            SlideBack.unregister(this);
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetSlideBack();
    }

    private void resetSlideBack() {
        unregisterSlideBack();
        registerSlideBack();
    }
}
