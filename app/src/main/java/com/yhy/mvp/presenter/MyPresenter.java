package com.yhy.mvp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.yhy.mvp.biz.RequestBiz;
import com.yhy.mvp.biz.RequestBizhml;
import com.yhy.mvp.biz.onRequestListener;
import com.yhy.mvp.view.MvpView;

import java.util.List;


/**
 * Created by Administrator on 2016/5/16.
 */
public class MyPresenter {

    MvpView mvpView;
    RequestBiz requestBiz;
    private Handler mHandler;

    public MyPresenter(MvpView mvpView){
        this.mvpView = mvpView;
        requestBiz = new RequestBizhml();
        mHandler = new Handler(Looper.getMainLooper());
    }
    public void onResume(){
        mvpView.showLoading();
        requestBiz.requestForData(new onRequestListener() {
            @Override
            public void onSuccess(final List<String> data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.hideLoading();
                        mvpView.setListItem(data);
                    }
                });
            }

            @Override
            public void onFailed() {
                mvpView.showMessage("请求失败");
            }
        });

    }
    public void onItemClick(int positon){
        mvpView.showMessage("点击了item"+positon);
    }

}
