package com.bawei.liuhe20190903.utils;

import android.os.AsyncTask;

import com.bawei.liuhe20190903.contarct.HomeContarct;

import java.io.IOException;

public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {
    HomeContarct.Imodel.ImodelCallBack imodelCallBack;
    String path;
    private String qing;

    public MyAsyncTask(HomeContarct.Imodel.ImodelCallBack imodelCallBack, String path) {
        this.imodelCallBack = imodelCallBack;
        this.path = path;
    }
    //刷新UI
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s!=null){
            imodelCallBack.onHomeCheng(s);
        }else {
            imodelCallBack.onHomeShi("网络加载异常");
        }
    }

    //耗时操作
    @Override
    protected String doInBackground(Integer... integers) {
        try {
            qing = HttpUtil.getInstance().getQing(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return qing;
    }
}
