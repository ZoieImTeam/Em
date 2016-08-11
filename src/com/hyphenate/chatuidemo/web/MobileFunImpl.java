package com.hyphenate.chatuidemo.web;

import android.content.Context;


/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/7/28
 * 移动端接口的实现类
 */
public class MobileFunImpl implements MobileImpable {
    Context mContext;
    WebConnectable mConnectable;

    public MobileFunImpl(Context context, WebConnectable connectable) {
        mContext = context;
        mConnectable=connectable;
    }
}
