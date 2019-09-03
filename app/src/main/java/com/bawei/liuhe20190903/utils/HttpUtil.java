package com.bawei.liuhe20190903.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    private static  HttpUtil httpUtil;
    private URL url;
    private HttpURLConnection httpURLConnection;
    private InputStream inputStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] bytes;

    private HttpUtil(){}
    public static synchronized  HttpUtil getInstance(){
        if (httpUtil==null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }
    //网络请求
    public String getQing(String path) throws IOException {
        url = new URL(path);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        if (httpURLConnection.getResponseCode()==200){
            inputStream = httpURLConnection.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len;
            bytes = new byte[1024];
            while ((len=inputStream.read(bytes))!=-1){
                byteArrayOutputStream.write(bytes,0,len);
            }
            //关闭流
            inputStream.close();
        }
        return byteArrayOutputStream.toString();
    }
    //网络判断
    public  boolean getWang(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            return networkInfo.isAvailable();
        }
        return false;
    }
}
