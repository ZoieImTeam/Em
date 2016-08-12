package com.kyluzoi.easeui.zoihttp;

import android.text.TextUtils;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/8/10
 */
public class PassWordCom {

    private static String[] mAdminPassworld = new String[]
            {
                    "00c", "00e", "00r", "00u", "00w", "00y",
                    "02b", "02c", "02e", "02f", "02s", "02v",
                    "02w", "03a", "03h", "03m", "03p", "03u",
                    "03u", "03y", "04e", "04v", "05a", "05d",
                    "05d", "05d", "05q", "05r", "05r", "05y",
                    "06b", "06d", "06e", "06j", "06k", "06k",
                    "06p", "06t", "06u", "06u", "07b", "07d",
                    "07m", "07q", "07q", "08n", "08q", "08r",
                    "08w", "08z", "09b", "09f", "09g", "09w",
                    "09z", "0a3", "0ag", "0ak", "0ar", "0as",
                    "0az", "0ax", "0b0", "0b6", "0b7", "0bj",
                    "0br", "0bw", "0bx", "0c2", "0c3", "0ca",
                    "0cab", "0cn", "0d6", "0dd", "0dy", "0ed",
                    "0ej", "0f0", "0f5", "0f6", "0fb", "0fg",
                    "0fv", "0fx", "0g6", "0gk", "0gq", "0gs",
                    "0h0", "0h4", "0h5", "0h6", "0hz", "0j5",
                    "0j6", "0j7", "0j8", "0jb", "0jc", "0jm",
                    "0jt", "0jv", "0k4", "0k6", "0k9", "0kd",
                    "0kk", "0kz", "0m0", "0ms", "0n2", "0na",
                    "0nf", "0nx", "0ny", "0p4", "0p5", "0p9",
                    "0pj", "0ps", "0q0", "0q4", "0q9", "0qr",
                    "0qy", "0qz", "0r3", "0r5", "0r7", "0rn",
                    "0rs", "0s4", "0s5", "0s8", "0sh", "0su",
                    "0sz", "0t4", "0t5", "0tr", "0te", "0tt",
                    "0tw", "0u2", "0ug", "0up", "0ux", "0uv",
                    "0v2", "0v4", "0v7", "0va", "0ve", "0vj",
                    "0w0", "0w5", "0wa", "0we", "0wj", "0wm",
                    "0wz", "0x0", "0x7", "0xa", "0xs", "0y6",
                    "0yh", "0yj", "0ym", "0z2", "0z4", "0z7",
                    "0z8", "0z9", "0ze", "0zf", "4rw", "4rv",
                    "4s5", "4s6", "4s9", "4sa", "4sn", "4t5",
                    "4t7", "4tm", "4tq", "4tu", "4tw", "4tx",
                    "4u0", "4u2", "4u5", "nil"
            };

    /**
     * Created by Zoi
     * Method Name: adminPassworld
     * Description:
     */
    public static boolean adminPassworld(String pass) {

        for(String aa:mAdminPassworld)
        {
            if (TextUtils.equals(aa,pass))
            {
                return true;
            }
        }
        return false;
    }
}
