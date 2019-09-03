package com.bawei.liuhe20190903.contarct;

public interface HomeContarct {
    //契约类
    interface Iview{
        //成功
        void  onHomeCheng(String data);
        //失败
        void  onHomeShi(String e);
    }
    interface  Imodel{
        //获取数据
        void onHomegetData(String path,ImodelCallBack imodelCallBack);
        //接口回调
        interface ImodelCallBack{
            //成功
            void  onHomeCheng(String data);
            //失败
            void  onHomeShi(String shi);
        }
    }
    //初始化
    interface IgetPresenter{
        //绑定
         void acctach(HomeContarct.Iview iview);
        //解绑
        void datach();
        //初始化
        void getpresenter(String path);
    }
}
