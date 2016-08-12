package com.kyluzoi.easeui.zoihttp;

import java.util.List;

/**
 * Created by Zoi.
 * E-mail：KyluZoi@gmail.com
 * 2016/8/6
 */
public class MinganEntity {

    /**
     * status : false
     * code : 1
     * msg : 检测到敏感字符！
     * data : {"error":[{"word":"我日","times":1,"weight":20,"attr":"*"}],"new_str":"***","input_str":"我日"}
     */

    private boolean status;
    private int code;
    private String msg;
    private DataBean data;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean {
        /**
         * error : [{"word":"我日","times":1,"weight":20,"attr":"*"}]
         * new_str : ***
         * input_str : 我日
         */

        private String new_str;
        private String input_str;
        private List<ErrorBean> error;

        public void setNew_str(String new_str) {
            this.new_str = new_str;
        }

        public void setInput_str(String input_str) {
            this.input_str = input_str;
        }

        public void setError(List<ErrorBean> error) {
            this.error = error;
        }

        public String getNew_str() {
            return new_str;
        }

        public String getInput_str() {
            return input_str;
        }

        public List<ErrorBean> getError() {
            return error;
        }
    }
}
