package com.zyjg.adtech.bigscreen.task;
import com.zyjg.adtech.bigscreen.utils.HttpClientUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableAsync
public class Task {

    private static final String urlOne = "http://127.0.0.1:9032/task/";


//    //第三方订单添加 addOrderThird
//    @Scheduled(cron = "0/20 * * * * ?")//20秒
//    @Async
//    public void addOrderThird() {
//        try {
//            String result = HttpClientUtil.doget(urlOne + "addOrderThird");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"=========第三方订单添加 addOrderThird:=======" + result);
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"=========第三方订单添加 addOrderThird:=======报错了");
//        }
//    }


    //第三方订单添状态查询 getOrderStatusThird
    @Scheduled(cron = "0 0/4 * * * ? ")//3分钟都执行
    @Async
    public void getOrderStatusThird() {
        try {
            String result = HttpClientUtil.doget(urlOne + "getOrderStatusThird");
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"======第三方订单添状态查询 getOrderStatusThird====" + result);
        } catch (Exception e) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"======第三方订单添状态查询 getOrderStatusThird====报错了" + e.getStackTrace());
        }

    }

//   // 第三方我的账户余额 getMyBalanceThird
//    @Scheduled(cron = "0 0/3 * * * ? ")//3分钟都执行
//    @Async
//    public void getMyBalanceThird() {
//        try {
//            String result = HttpClientUtil.doget(urlOne + "getMyBalanceThird");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "第三方我的账户余额 getMyBalanceThird");
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "第三方我的账户余");
//        }
//    }
//
//
//    //vip执行第三方订单 vipThirdOrderPerform
//    @Scheduled(cron = "0 0/10 * * * ? ")//10分钟都执行
//    @Async
//    public void vipThirdOrderPerform() {
//
//        try {
//            String result = HttpClientUtil.doget(urlOne + "vipThirdOrderPerform");
//
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip执行第三方订单 vipThirdOrderPerform");
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip执行第三方订单 vipThirdOrderPerform报错");
//        }
//
//    }
//
//
//    //vip执行第三方订单状态查询 vipThirdOrderStatus
//    @Scheduled(cron = "0 0/30 * * * ? ")//10分钟都执行
//    @Async
//    public void vipThirdOrderStatus() {
//        try {
//            String result = HttpClientUtil.doget(urlOne + "vipThirdOrderStatus");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip执行第三方订单状态查询vipThirdOrderStatus");
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip执行第三方订单状态查询vipThirdOrderStatus报错");
//        }
//    }
//
//
//    //vip订单每天自动添加 autoVipThirdOrder
//    @Scheduled(cron = "0 0/30 * * * ? ")//10分钟都执行
//    @Async
//    public void autoVipThirdOrder() {
//        try {
//            String result = HttpClientUtil.doget(urlOne + "autoVipThirdOrder");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip订单每天自动添加 autoVipThirdOrder");
//
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip订单每天自动添加 autoVipThirdOrder报错");
//        }
//
//    }
//
//
//    //自动添加VIP第三方订单第二版
//    @Scheduled(cron = "0 0/5 * * * ? ")//5分钟都执行
//    @Async
//    public void autoVipThirdOrderTwo() {
//        try {
//            String result = HttpClientUtil.doget(urlTwo + "autoVipThirdOrderTwo");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "自动添加VIP第三方订单第二版autoVipThirdOrderTwo");
//
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "自动添加VIP第三方订单第二版autoVipThirdOrderTwo报错");
//        }
//    }
//
//    //vip第三方订单添状态查询第二版
//    @Scheduled(cron = "0 0/5 * * * ? ")//5分钟都执行
//    @Async
//    public void vipThirdOrderStatusTwo() {
//        try {
//            String result = HttpClientUtil.doget(urlTwo + "vipThirdOrderStatusTwo");
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip第三方订单添状态查询第二版vipThirdOrderStatusTwo");
//        } catch (Exception e) {
//            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip第三方订单添状态查询第二版vipThirdOrderStatusTwo报错");
//        }
//    }
//
//    //vip第三方订单执行第二版
//    @Scheduled(cron = "0 0/5 * * * ? ")//5分钟都执行
//    @Async
//    public void vipThirdOrderPerformTwo() {
//    try {    String result = HttpClientUtil.doget(urlTwo + "vipThirdOrderPerformTwo");
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip第三方订单执行第二版vipThirdOrderPerformTwo");
//
//    } catch (Exception e) {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "vip第三方订单执行第二版vipThirdOrderPerformTwo报错");
//    }
//    }

}