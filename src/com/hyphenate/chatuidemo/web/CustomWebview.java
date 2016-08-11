package com.hyphenate.chatuidemo.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/28
 */
public class CustomWebview extends WebView implements CommonWebChromeClient.OpenFileChooserCallBack {


    public void setIWebBinder(IWebBinder IWebBinder) {
        mIWebBinder = IWebBinder;
    }

    private IWebBinder mIWebBinder;

    public CustomWebview(Context context) {
        this(context,null);
    }

    public CustomWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initSet();
    }

    private void initSet() {
        clearCookies(getContext());
        WebSettings webSettings = this.getSettings();
        //设置支持JavaScript脚本
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        webSettings.setDatabaseEnabled(true);

        //使用localStorage则必须打开
//        webSettings.setDomStorageEnabled(true);

        webSettings.setGeolocationEnabled(true);
        //webSettings.setGeolocationDatabasePath(dir);

        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setBlockNetworkImage(false);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        // webSettings.setDisplayZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // TODO CACHE_DEFAULT

        //设置WebViewClient
        this.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Log.e("kyluzoi", "shouldOverrideUrlLoading  load url == " + url);
                if (isMyApi(url)) {
                    return true;
                }
                return false;
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

        });

    }

    private boolean isMyApi(String url) {
        // TODO  判断是否要拦截url
        return false;
    }

    /**
     * 必须调用 传activity 用于后期变更标题
     * @param activity
     */
    public void setCommonWebChromeClient(Activity activity)
    {
        //设置WebChromeClient
        this.setWebChromeClient(new CommonWebChromeClient(activity, this));
        // 覆盖默认后退按钮的作用，替换成WebView里的查看历史页面
        this.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_BACK)
                            && CustomWebview.this.canGoBack()) {
                        CustomWebview.this.goBack();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void clearCookies(Context context) {
        CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieSyncMngr.sync();
    }


    @Override
    public void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType) {
        mIWebBinder.openFileChooserZ(uploadMsg, acceptType);
    }

    @Override
    public boolean openFileChooserCallBackLollipoPlus(ValueCallback<Uri[]> uploadMsg, String acceptType) {
        return mIWebBinder.openFileChooserCallBackLollipoPlus(uploadMsg,acceptType);
    }

    public interface IWebBinder
    {
        void openFileChooserZ(ValueCallback<Uri> uploadMsg, String acceptType);
        boolean openFileChooserCallBackLollipoPlus(ValueCallback<Uri[]> uploadMsg, String acceptType);
    }
}
