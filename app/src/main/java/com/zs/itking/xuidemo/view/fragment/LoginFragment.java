/*
 * Copyright (C) 2021 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.zs.itking.xuidemo.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.OrientationHelper;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.enums.CoreAnim;
import com.xuexiang.xrouter.annotation.AutoWired;
import com.xuexiang.xui.utils.DrawableUtils;
import com.xuexiang.xui.utils.ResUtils;
import com.xuexiang.xui.utils.ThemeUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.zs.itking.xuidemo.R;
import com.zs.itking.xuidemo.common.Constant;
import com.zs.itking.xuidemo.view.activity.MainActivity;

import java.util.List;


/**
 * 登录页面
 *
 * @author xuexiang
 * @since 2019-11-17 22:15
 */
@Page(name = "登录页面",anim = CoreAnim.slide)
public class LoginFragment extends BaseFragment  {

    @Override
    protected TitleBar initTitle() {
        TitleBar titleBar = super.initTitle()
                .setImmersive(true);
        titleBar.setBackgroundColor(Color.RED);
        titleBar.setTitle("登录页面","123", LinearLayout.VERTICAL).setSubTitleSize(50).setSubTitleColor(Color.GREEN);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            Bundle params = new Bundle();
            @Override
            public void onClick(View view) {
                params.putBoolean(Constant.KEY_IS_NEED_BACK, false);
                params.putString(Constant.KEY_EVENT_NAME, "事件");
                params.putString(Constant.KEY_EVENT_DATA, "携带的数据");
                openPageForResult(TestFragment.class, params,Constant.REQUEST_CODE);
                //popToBack();
            }
        });
        titleBar.setLeftImageDrawable(DrawableUtils.setTint(ResUtils.getVectorDrawable(getContext(), R.drawable.ic_login_close), ThemeUtils.getMainThemeColor(getContext())));
        return titleBar;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, ViewGroup container) {
        return View.inflate(getActivity(),R.layout.fragment_login,null);
    }

    @Override
    protected void initViews() {
        //根据key值接收Bundle的value数据
        Bundle arguments = getArguments();
        String eventData = arguments.getString(Constant.KEY_EVENT_DATA);
        Toast.makeText(getActivity(), "LoginFragment:"+eventData, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * 使用openPageForResult跳转并传标识码，当回掉当前Fragment时，匹配标识码获取相关数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onFragmentResult(int requestCode, int resultCode, Intent data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (data != null) {
            Bundle extras = data.getExtras();
            Toast.makeText(getActivity(), "请求码:" + requestCode +"结果码:"+ resultCode+" 回调数据:" + extras.getString(Constant.KEY_BACK_DATA), Toast.LENGTH_SHORT).show();
        }
    }
}
