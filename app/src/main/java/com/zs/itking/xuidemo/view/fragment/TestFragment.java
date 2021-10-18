package com.zs.itking.xuidemo.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xrouter.annotation.AutoWired;
import com.xuexiang.xui.utils.DrawableUtils;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.ThemeUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.zs.itking.xuidemo.R;
import com.zs.itking.xuidemo.common.Constant;

/**
 * created by on 2021/10/2
 * 描述：
 *
 * @author ZSAndroid
 * @create 2021-10-02-17:28
 */
@Page(anim = CoreAnim.slide)
public class TestFragment extends BaseFragment{





    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return View.inflate(getActivity(), R.layout.fragment_test,null);
    }

    @Override
    protected void initViews() {
        Bundle arguments = getArguments();
        String eventName = arguments.getString(Constant.KEY_EVENT_NAME);
        String eventData = arguments.getString(Constant.KEY_EVENT_DATA);
        Toast.makeText(getActivity(), "TestFragment:"+eventName+eventData, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected TitleBar initTitle() {
        TitleBar titleBar = super.initTitle()
                .setImmersive(true);
        titleBar.setBackgroundColor(Color.BLUE);
        titleBar.setTitle("4156");
        titleBar.setLeftClickListener(new View.OnClickListener() {
            Bundle params = new Bundle();
            @Override
            public void onClick(View view) {
//                params.putBoolean(Constant.KEY_IS_NEED_BACK, false);
//                params.putString(Constant.KEY_EVENT_NAME, "TestFragment事件");
//                params.putString(Constant.KEY_EVENT_DATA, "TestFragment携带的数据");
//                // 设置返回的数据，类似Activity里的setResult
//                Intent intent = new Intent();
//                intent.putExtra(Constant.KEY_BACK_DATA, params);
//                setFragmentResult(Constant.REQUEST_CODE, intent);
//                // 关闭当前页，返回上一页
//                //popToBack();
//                // 关闭当前页并跳转至某个页面
//                popToBack("登录页面",null);
                // 设置返回的数据，类似Activity里的setResult
                Intent intent1 = new Intent();
                intent1.putExtra(Constant.KEY_BACK_DATA, "==【返回的数据】==");
                setFragmentResult(Constant.RESULT_CODE, intent1);
                // 返回操作
                popToBack();

            }
        });
        titleBar.setLeftImageDrawable(DrawableUtils.setTint(ResUtils.getVectorDrawable(getContext(), R.drawable.ic_login_close), ThemeUtils.getMainThemeColor(getContext())));
        return titleBar;
    }
}
