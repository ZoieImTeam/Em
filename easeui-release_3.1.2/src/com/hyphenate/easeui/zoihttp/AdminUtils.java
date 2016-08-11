package com.hyphenate.easeui.zoihttp;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/8/6
 */
public class AdminUtils {

    public static boolean isAdmin(String xxx) {
        xxx = xxx.substring(2,5);
        Log.d("AdminUtils", xxx);
        if (TextUtils.equals(xxx, "gly")) {
            return true;
        }
        return false;
    }
}
