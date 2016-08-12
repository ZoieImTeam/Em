package com.kyluzoi.saya.web;

import android.os.Bundle;
import android.view.View;


import com.kyluzoi.saya.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/28
 */
public class WebviewFragment extends BaseFragment {
    @Bind(R.id.webView)
    CustomWebview mWebView;
    private static final String KEY_URL = "URL";
    private String mUrl;

    public static WebviewFragment newInstance(String url) {
        Bundle args = new Bundle();
        WebviewFragment fragment = new WebviewFragment();
        args.putString(KEY_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.webview_custom;
    }

    @Override
    protected void initView(View contentView) {
        ButterKnife.bind(this, contentView);
        if (getArguments() != null) {
            mUrl = getArguments().getString(KEY_URL);
        }
        initWebView();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void doAfterReConnectNewWork() {

    }


    private void initWebView() {
        mWebView.setCommonWebChromeClient(getActivity());
        mWebView.loadUrl(mUrl);
    }

}
