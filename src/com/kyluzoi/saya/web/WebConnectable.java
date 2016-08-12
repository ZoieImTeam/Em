package com.kyluzoi.saya.web;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/28
 */
public interface WebConnectable {
    void uploadcallback(String tag);
    void shareCallback(String title, String content, String imgUrl, String targetUrl);
    void back();
}
