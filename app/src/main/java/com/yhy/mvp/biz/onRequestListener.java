package com.yhy.mvp.biz;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 */
public interface onRequestListener {

    void onSuccess(List<String> data);
    void onFailed();
}
