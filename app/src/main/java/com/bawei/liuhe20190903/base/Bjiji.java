package com.bawei.liuhe20190903.base;

import java.util.ArrayList;

public class Bjiji {
    private ArrayList<DataBean> data;

    public ArrayList<DataBean> getData() {
        return data;
    }

    public void setData(ArrayList<DataBean> data) {
        this.data = data;
    }

    public Bjiji(ArrayList<DataBean> data) {
        this.data = data;
    }
    public class DataBean{
        private String currency_price;
        private String goods_thumb;

        @Override
        public String toString() {
            return "DataBean{" +
                    "currency_price='" + currency_price + '\'' +
                    ", goods_thumb='" + goods_thumb + '\'' +
                    '}';
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public DataBean(String currency_price, String goods_thumb) {
            this.currency_price = currency_price;
            this.goods_thumb = goods_thumb;
        }
    }
}
