package com.bawei.liuhe20190903.model;

import android.util.Log;

import com.bawei.liuhe20190903.app.App;
import com.bawei.liuhe20190903.contarct.HomeContarct;
import com.bawei.liuhe20190903.utils.HttpUtil;
import com.bawei.liuhe20190903.utils.MyAsyncTask;

public class HomeModel implements HomeContarct.Imodel {
    //网络判断
    @Override
    public void onHomegetData(String path, ImodelCallBack imodelCallBack) {
        if (HttpUtil.getInstance().getWang(App.context)){
        new MyAsyncTask(imodelCallBack, path).execute();
        }else {
            Log.d("sss", "加载失败");
        }
    }
}
