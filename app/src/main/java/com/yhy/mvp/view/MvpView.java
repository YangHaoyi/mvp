package com.yhy.mvp.view;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 */
public interface MvpView {

    void showLoading();
    void hideLoading();
    void setListItem(List<String> data);
    void showMessage(String message);

}
