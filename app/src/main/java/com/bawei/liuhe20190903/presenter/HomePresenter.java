package com.bawei.liuhe20190903.presenter;

import android.util.Log;

import com.bawei.liuhe20190903.contarct.HomeContarct;
import com.bawei.liuhe20190903.model.HomeModel;

import java.lang.ref.WeakReference;

public class HomePresenter implements HomeContarct.IgetPresenter {

    private HomeModel homeModel;
    private WeakReference<HomeContarct.Iview> iviewWeakReference;

    @Override
    public void acctach(HomeContarct.Iview iview) {
        //绑定
        homeModel = new HomeModel();
        //弱引用
        iviewWeakReference = new WeakReference<>(iview);

    }
    public HomeContarct.Iview getView(){
        return iviewWeakReference.get();
    }

    @Override
    public void datach() {
        //解绑
        if (iviewWeakReference!=null){
            iviewWeakReference.clear();
            iviewWeakReference =null;
        }
    }

    @Override
    public void getpresenter(String path) {
        //初始化
        homeModel.onHomegetData(path, new HomeContarct.Imodel.ImodelCallBack() {
            @Override
            public void onHomeCheng(String data) {
                Log.d("sss", "onHomeCheng: "+data);
                getView().onHomeCheng(data);
            }
            @Override
            public void onHomeShi(String shi) {
            getView().onHomeShi(shi);
            }
        });
    }
}
