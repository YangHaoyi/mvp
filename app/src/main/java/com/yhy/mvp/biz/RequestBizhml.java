package com.yhy.mvp.biz;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/16.
 */
public class RequestBizhml implements RequestBiz {
    @Override
    public void requestForData(final onRequestListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<String> data = new ArrayList<String>();
                    for(int i=0;i<9;i++){
                        data.add("item"+i);
                    }
                    if(null!=listener){
                        listener.onSuccess(data);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
