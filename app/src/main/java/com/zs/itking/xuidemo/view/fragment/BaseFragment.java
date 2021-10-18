package com.zs.itking.xuidemo.view.fragment;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.xuexiang.xaop.annotation.MemoryCache;
import com.xuexiang.xaop.cache.XMemoryCache;
import com.xuexiang.xpage.base.XPageActivity;
import com.xuexiang.xpage.base.XPageFragment;
import com.xuexiang.xpage.core.PageOption;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xrouter.facade.service.SerializationService;
import com.xuexiang.xrouter.launcher.XRouter;
import com.xuexiang.xui.utils.DrawableUtils;
import com.xuexiang.xui.utils.KeyboardUtils;
import com.xuexiang.xui.utils.ThemeUtils;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.actionbar.TitleUtils;
import com.xuexiang.xui.widget.progress.loading.IMessageLoader;
import com.zs.itking.xuidemo.R;

import java.io.Serializable;

/**
 * @author xuexiang
 * @since 2018/5/25 下午3:44
 */

public abstract class BaseFragment extends XPageFragment {

    /**
     * 消息加载框
     */
    private IMessageLoader mMessageLoader;

    @Override
    protected void initPage() {
        initTitle();
        initViews();
        initListeners();
    }

    protected TitleBar initTitle() {
        return TitleUtils.addTitleBarDynamic((ViewGroup) getRootView(), getPageTitle(), v -> popToBack())
                .setLeftImageDrawable(getNavigationBackDrawable(R.attr.xui_actionbar_ic_navigation_back));
    }

    @MemoryCache
    private Drawable getNavigationBackDrawable(int navigationBackId) {
        return DrawableUtils.getSupportRTLDrawable(ThemeUtils.resolveDrawable(getContext(), navigationBackId));
    }

    public IMessageLoader getMessageLoader() {
        if (mMessageLoader == null) {
            mMessageLoader = WidgetUtils.getMiniLoadingDialog(getContext());
        }
        return mMessageLoader;
    }

    public IMessageLoader getMessageLoader(String message) {
        if (mMessageLoader == null) {
            mMessageLoader = WidgetUtils.getMiniLoadingDialog(getContext(), message);
        } else {
            mMessageLoader.updateMessage(message);
        }
        return mMessageLoader;
    }

    @Override
    protected void initListeners() {

    }

    @Override
    public void onDestroyView() {
        if (mMessageLoader != null) {
            mMessageLoader.dismiss();
        }
        super.onDestroyView();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        //屏幕旋转时刷新一下title
        super.onConfigurationChanged(newConfig);
        XMemoryCache.getInstance().clear();
        ViewGroup root = (ViewGroup) getRootView();
        if (root.getChildAt(0) instanceof TitleBar) {
            root.removeViewAt(0);
            initTitle();
        }
    }


    @Override
    protected void hideCurrentPageSoftInput() {
        if (getActivity() == null) {
            return;
        }
        // 记住，要在xml的父布局加上android:focusable="true" 和 android:focusableInTouchMode="true"
        KeyboardUtils.hideSoftInputClearFocus(getActivity().getCurrentFocus());
    }
}

