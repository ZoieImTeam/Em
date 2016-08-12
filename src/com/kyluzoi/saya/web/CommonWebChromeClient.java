package com.kyluzoi.saya.web;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.Keep;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

/**
 * CommonWebChromeClient
 *
 * @Author: PengWeiwei
 * @E-mail: pengveivei@sina.cn
 * @CreateDate: 2016/5/13 14:53
 * @Version: 1.0.0
 */
public class CommonWebChromeClient extends WebChromeClient {
    public Activity mActivity;
    private OpenFileChooserCallBack mOpenFileChooserCallBack;
    public CommonWebChromeClient(Activity activity, OpenFileChooserCallBack cb) {
        mActivity = activity;
        mOpenFileChooserCallBack = cb;
    }

    //处理javascript中的alert
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        //构建一个Builder来显示网页中的对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("Alert");
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok,
                new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        return true;
    }

    //处理javascript中的confirm
    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("confirm");
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok,
                new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        result.cancel();
                    }
                });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        return true;
    }

    @Override
    //设置网页加载的进度条
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
    }

    //设置应用程序的标题title
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
//        mActivity.setTitle(title);
    }

    public void onExceededDatabaseQuota(String url,
                                        String databaseIdentifier, long currentQuota,
                                        long estimatedSize, long totalUsedQuota,
                                        WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(estimatedSize * 2);
    }

    public void onGeolocationPermissionsShowPrompt(String origin,
                                                   GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    public void onReachedMaxAppCacheSize(long spaceNeeded,
                                         long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(spaceNeeded * 2);
    }


    public CommonWebChromeClient(OpenFileChooserCallBack openFileChooserCallBack) {
        mOpenFileChooserCallBack = openFileChooserCallBack;
    }

    //For Android 3.0+
    @Keep
    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
        mOpenFileChooserCallBack.openFileChooserCallBack(uploadMsg, acceptType);
    }

    // For Android < 3.0
    @Keep
    public void openFileChooser(ValueCallback<Uri> uploadMsg) {
        openFileChooser(uploadMsg, "");
    }

    // For Android  > 4.1.1
    @Keep
    public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
        openFileChooser(uploadMsg, acceptType);
    }



    @Keep
    public interface OpenFileChooserCallBack {
        void openFileChooserCallBack(ValueCallback<Uri> uploadMsg, String acceptType);
        boolean openFileChooserCallBackLollipoPlus(ValueCallback<Uri[]> uploadMsg, String acceptType);
    }
}
