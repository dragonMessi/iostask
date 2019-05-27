package com.zyjg.adtech.bigscreen.config;


import com.alibaba.fastjson.serializer.ValueFilter;

public class JsonConfig {
    //json 字段为null,在页面显示为空字符
    private static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };
/*
*
* 获取JSON过滤器
* **/
    public static ValueFilter filter() {
        return   filter;
    }

}
