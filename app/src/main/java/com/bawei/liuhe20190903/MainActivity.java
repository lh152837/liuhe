package com.bawei.liuhe20190903;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bawei.liuhe20190903.base.BaseActivity;
import com.bawei.liuhe20190903.base.Bjiji;
import com.bawei.liuhe20190903.contarct.HomeContarct;
import com.bawei.liuhe20190903.presenter.HomePresenter;
import com.bawei.liuhe20190903.utils.MyBase;
import com.bawei.liuhe20190903.utils.MyListview;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements HomeContarct.Iview {
    private ArrayList<Bjiji.DataBean> list = new ArrayList<>();
    int page = 1;
    private String path = "http://blog.zhaoliang5156.cn/api/shop/shop2.json?page=1";
    private PullToRefreshScrollView pullToRefreshListView;
    private HomePresenter homePresenter;
    private Gson gson;
    private Bjiji bjiji;
    private ArrayList<Bjiji.DataBean> bjijiData;
    private MyBase myBase;
    private MyListview myListview;

    @Override
    protected void initView() {
        pullToRefreshListView = findViewById(R.id.list_view);
        myListview = findViewById(R.id.list);
        pullToRefreshListView.setMode(PullToRefreshListView.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //下拉刷新
                page = 1;
                pullToRefreshListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //上拉加载
                page++;
                pullToRefreshListView.onRefreshComplete();
            }
        });
/*    pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
            page=1;
            pullToRefreshListView.onRefreshComplete();
        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
            pullToRefreshListView.onRefreshComplete();
        }
    });*/
    }

    @Override
    protected void initData() {
//初始化
        homePresenter = new HomePresenter();
        if (homePresenter != null) {
            homePresenter.acctach(MainActivity.this);
            homePresenter.getpresenter(path);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomeCheng(String data) {
        //成功解析
        gson = new Gson();
        bjiji = gson.fromJson(data, Bjiji.class);
        bjijiData = bjiji.getData();
        list.addAll(bjijiData);
        //设置适配器
        myBase = new MyBase(MainActivity.this, list);
        myListview.setAdapter(myBase);
    }

    @Override
    public void onHomeShi(String e) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
