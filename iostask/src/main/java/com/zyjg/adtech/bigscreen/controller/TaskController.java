package com.zyjg.adtech.bigscreen.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyjg.adtech.bigscreen.entity.Iosptxfdd;
import com.zyjg.adtech.bigscreen.entity.Log;
import com.zyjg.adtech.bigscreen.services.AllService;
import com.zyjg.adtech.bigscreen.utils.HttpClientUtil;
import com.zyjg.adtech.bigscreen.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
*
* 半结构化调阅服务接口
*
* */
@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    private AllService allService;



    /**
     * 第三方订单添状态查询 getOrderStatusThird
     *
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getOrderStatusThird", method = RequestMethod.GET)
    public String getOrderStatusThird(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> mapThird = new HashMap<String, Object>();// 调用存第三的API参数
        Log log = StringUtil.log("第三方订单添状态查询", "getOrderStatusThird", "");
        try {
            List<Iosptxfdd> ptxfddLiist = allService.getPtxfddInfoByZt(
                    "1000000025", null);

            String message = null;
            if (ptxfddLiist.size() > 0) {
                int group = 0;
                int count = 100;
                if (ptxfddLiist.size() % count == 0) {
                    group = ptxfddLiist.size() / 100;
                } else {
                    group = (ptxfddLiist.size() / 100) + 1;
                }
                for (int i = 0; i < group; i++) {
                    if (group - 1 == i) {
                        allOrderInfo(mapThird, ptxfddLiist.subList(i * 100,
                                ptxfddLiist.size()), log);// 调用第1次第三方接口查询订单
                    } else {
                        allOrderInfo(mapThird,
                                ptxfddLiist.subList(i * 100, i * 100 + 100),
                                log);// 调用第1次第三方接口查询订单
                    }
                }

                message = "查询订单" + ptxfddLiist.size() + "个成功";
            } else {
                message = "查询订单0个";
            }
            log.setZt("1");
            StringUtil.rightMap(map, StringUtil.INFOSUCCESS, log, message,
                    StringUtil.STATUS200, StringUtil.INFOSUCCESS, "");
        } catch (Exception e) {
            log.setMessage("第三方订单添状态查询报错");
            StringUtil.catchMap(map, e.toString(), StringUtil.SERVICESERRO,
                    log, "第三方订单添状态查询整体报错,", e.toString(), StringUtil.STATUS500,
                    "");
        } finally {
            allService.insetLog(log);
        }
        return StringUtil.getJsonString(map);
    }

    private void allOrderInfo(Map<String, Object> mapThird,
                              List<Iosptxfdd> ptxfddLiist, Log log) {

        mapThird.put("key", StringUtil.KEY);
        mapThird.put("action", "status");
        StringBuffer orderBuffer = new StringBuffer();
        for (int i = 0; i < ptxfddLiist.size(); i++) {
            orderBuffer.append(ptxfddLiist.get(i).getOrderThird());
            if (ptxfddLiist.size() - i != 1) {
                orderBuffer.append(",");
            }
        }
        mapThird.put("orders", orderBuffer.toString());
        String result = HttpClientUtil.doPostForJson(StringUtil.THIRDURL,
                JSON.toJSONString(mapThird));// 调用验证接口
        System.out.println(result);

        JSONObject thirdJson = JSON.parseObject(result);// 获取的返回数据
        for (int i = 0; i < ptxfddLiist.size(); i++) {

            try {
                JSONObject orderIdJson = JSON.parseObject(thirdJson.get(
                        ptxfddLiist.get(i).getOrderThird()).toString());
                int remains = 100;
                if (orderIdJson.containsKey("remains")) {
                    remains = Integer.parseInt(orderIdJson.get("remains")
                            .toString());
                }
                if (orderIdJson.get("status").equals("Completed")
                        || remains <= 5) {
                    finshOrder(ptxfddLiist.get(i));
                } else if (orderIdJson.get("status").equals("Canceled")) {
                    canceledOrder(ptxfddLiist.get(i));// 取消订单
                }
            } catch (Exception e) {
                log.setMessage("第三方订单查询状态个别报错");
                StringUtil.logCatch(log, "第三方订单查询状态个别报错第三方订单ID为："
                                + ptxfddLiist.get(i).getOrderThird(), e.toString(),
                        ptxfddLiist.get(i).getYhid());
                allService.insetLog(log);
            }
        }

    }

    /**
     * 订单第三方取消
     *
     * @param iosptxfdd
     * @throws Exception
     */
    private void canceledOrder(Iosptxfdd iosptxfdd) throws Exception {
        // 订单取消
        Iosptxfdd pt = new Iosptxfdd();// 1000000027
        pt.setZt("1000000048");
        pt.setDdwcsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));
        pt.setId(iosptxfdd.getId());
        SimpleDateFormat myFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        long sh = (myFormatter.parse(pt.getDdwcsj()).getTime() - myFormatter
                .parse(iosptxfdd.getDdscsj()).getTime()) / 1000 / 60;
        pt.setXhsj(String.valueOf(sh));
        allService.updatePtxxdd(pt);
    }

    private void finshOrder(Iosptxfdd iosptxfdd) throws Exception {
        // 订单完成
        Iosptxfdd pt = new Iosptxfdd();// 1000000027
        pt.setZt("1000000027");
        pt.setDdwcsj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date()));
        pt.setId(iosptxfdd.getId());
        SimpleDateFormat myFormatter = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        long sh = (myFormatter.parse(pt.getDdwcsj()).getTime() - myFormatter
                .parse(iosptxfdd.getDdscsj()).getTime()) / 1000 / 60;
        pt.setXhsj(String.valueOf(sh));
        allService.updatePtxxdd(pt);
    }

}
