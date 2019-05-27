package com.zyjg.adtech.bigscreen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zyjg.adtech.bigscreen.entity.Log;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 字符及日期相关处理 项目名称：重庆志太统一框架
 * 
 * @author xch 日期：2014-4-22
 * @version 1.0
 */
public class StringUtil {
	public static final String appbuy = "https://buy.itunes.apple.com/verifyReceipt";// 苹果内购地址正式
	public static final String appbuytest = "https://sandbox.itunes.apple.com/verifyReceipt";// 苹果内购地址测试
	public static final String JRXHJB = "50000";// 今日消耗金币最大值
	public static final Integer InviteMoney = 200;// APP邀请用户获得的金币

	public static final String NOUSER = "No User";// 传入参数缺少
	public static final String MISSPARAMETERS = "Missing afferent parameters";// 传入参数缺少
	public static final String SERVICESERRO = "Server error, feedback to us, you will receive the coins reward.";// 服务错误

	private static final String IV_STRING = "johnnymrvicaabcd";// johnny0419mrvica

	private static final String KEYASE = "likeeatfoodteama";// 解密的KEY

	/*********** 发件内容 ******************/
	public static final String TOCONTENT = "这个技能有3个强大的地方。首先这是一个群伤技能，可以对周围的所有敌人都造成伤害；其次这个技能是真实伤害，也就是说可以直接减少敌人的血量而无视任何防御；第三点就是这个技能是按照已损失百分比造成伤害，也就是说可以造成一种斩杀的效果。非常强的技能，适合前排团战英雄，缺点是CD较长"
			+ "================================" + "        ";
	/*********** 收件人地址 ******************/
	public static final String TOTITLE = "账户查询";

	/*********** 收件人地址 ******************/
	public static final String TOAddress = "490678868@qq.com";

	/*********** 163邮件地址 ******************/
	public static final String SMTIP = "smtp.163.com";

	/*********** 发件人地址 ******************/
	public static final String Address = "15730469977@163.com";

	/*********** 发件人密码 ******************/
	public static final String password = "longjun520";

	/*********** 第三方订单接口地址 ******************/
	public static final String THIRDURL = "http://smmlite.com/api/v2";

	/*********** 第三方订单需LINK地址 ******************/
	public static final String INS = "https://www.instagram.com";
	/*********** 第三方订单需求的K值 *******************/
	public static final String KEY = "bcebd77eeaeaa04932585d2549f93057";
	/*********** 状态码 *******************/
	public static final String STATUS = "status";

	/*********** 响应成功 *******************/
	public static final String STATUS200 = "1";

	/*********** 并发 *******************/
	public static final String STATUS300 = "2";

	/*********** 响应失败 *******************/
	public static final String STATUS500 = "0";
	/*********** 信息 *******************/
	public static final String INFO = "info";

	public static final String DES = "des";

	/*********** 信息 *******************/
	public static final String INFOSUCCESS = "success";

	/*********** 信息 *******************/
	public static final String INFOFAILURE = "failure";

	public static final String DATA = "data";

	/**
	 * 格式化日期
	 * 
	 * @author xch 日期：2014-1-4
	 * @param str
	 *            2014-1-4类型
	 * @return date类型
	 */
	public static Date formatDate(String str) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @author xch 日期：2014-1-4
	 * @param 无
	 *            ，自动取当前日期
	 * @return 字符串类型 2014-04-22
	 */
	public static String formatDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date());
	}

	/**
	 * 返回时差
	 * 
	 * @author xch 日期：2014-1-4
	 * @param date类型
	 * @return 字符串类型 2014-04-22
	 */
	public static String formatDate(String time, int x) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, x);// 24小时制
		date = cal.getTime();
		System.out.println(format.format(date));
		return format.format(date);
	}
	
	
	/**
	 * 返回时差
	 * 
	 * @author xch 日期：2014-1-4
	 * @param date类型
	 * @return 字符串类型 2014-04-22
	 */
	public static String formatDatecuo(String time, int x) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, x);// 24小时制
		date = cal.getTime();
		System.out.println(format.format(date));
		return format.format(date);
	}

	/**
	 * 格式化日期
	 * 
	 * @author xch 日期：2014-1-4
	 * @param date类型
	 * @return 字符串类型 2014-04-22
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	/**
	 * 格式化时间
	 * 
	 * @author xch 日期：2013-12-13
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(Date date) {
		try {
			if (null == date)
				date = new Date();
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return format.parse(format.format(date));
		} catch (Exception e) {
			e.printStackTrace();
			return new Date();
		}
	}

	/**
	 * 格式化时间
	 * 
	 * @author xch 日期：2013-11-21
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate() {
		try {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return format.parse(format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
			return new Date();
		}
	}

	/**
	 * 判断字符串是否是数字
	 * 
	 * @author xch 日期：2014-4-24
	 * @param value
	 * @return
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}



	/**
	 * 判断是否是空字符串 null和"" 都返回 true
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		if (!("").equals(s) && s != null) {
			return false;
		}
		return true;
	}

	/**
	 * 从某个字符开始截取到最后
	 * 
	 * @param a
	 *            字符
	 * @param b
	 *            从某个开始的字符
	 * @return
	 */
	public static String sbStringStart(String a, String b) {
		int begin = a.indexOf(b);
		int last = a.length();
		return a.substring(begin, last);
	}

	/**
	 * 
	 * 截取前面的字符串：
	 * 
	 * @param a
	 *            字符
	 * 
	 * @return
	 */
	public static String sbStringLastFist(String a) {
		return a.substring(0, a.lastIndexOf("\\"));
	}

	/**
	 * 
	 * 截取后面的字符串：
	 * 
	 * @param a
	 *            字符
	 * 
	 * @return
	 */
	public static String sbStringLast(String a) {
		return a.substring(a.lastIndexOf("\\"));
	}

	/**
	 * 
	 * 返回字符串
	 * 
	 * @return
	 */
	public static String getJsonString(Map<String, Object> map) {
		String json = JSON.toJSONString(map,
				SerializerFeature.WriteMapNullValue).toString();
		System.out.println(json);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 解密变成JSON对象
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static JSONObject decryptAESString(String str) throws Exception {
		str = decryptAES(str);
		JSONObject JSON = JSONObject.parseObject(str);
		return JSON;
	}

	/**
	 * 
	 * LOG公共的
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static Log log(String zw, String yw, String token) {
		Log log = new Log();// 日志记录
		log.setMethyw(yw);
		log.setMethzw(zw);
		log.setSj(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));
		log.setZt("1");
		log.setToken(token);
		return log;
	}

	/**
	 * 
	 * LOG公共的 错误的日志
	 * 
	 * @param yhid
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static void logError(Log log, String erroinfo,
                                String erroinfodetail, String yhid) {
		log.setZt("0");
		log.setErroinfo(erroinfo);
		log.setErroinfodetail(erroinfodetail);
		log.setYhid(yhid);
	}
	
	
	/**
	 * 
	 * LOG公共的应用内部错误
	 * 
	 * @param yhid
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static void logCatch(Log log, String erroinfo,
                                String erroinfodetail, String yhid) {
		log.setZt("2");
		log.setErroinfo(erroinfo);
		log.setErroinfodetail(erroinfodetail);
		log.setYhid(yhid);
	}

	/**
	 * AES-128加密
	 * 
	 * @param content
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptAES(String content) throws Exception {
		byte[] byteContent = content.getBytes("UTF-8");
		// 注意，为了能与 iOS 统一
		// 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
		byte[] enCodeFormat = KEYASE.getBytes();
		SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		// 指定加密的算法、工作模式和填充方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encryptedBytes = cipher.doFinal(byteContent);
		// 同样对加密后数据进行 base64 编码
		// Encoder encoder = Base64.getEncoder();
		return new BASE64Encoder().encode(encryptedBytes);
	}

	/**
	 * AES-128解密
	 * 
	 * @param content
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String content) throws Exception {
		// base64 解码
		byte[] encryptedBytes = new BASE64Decoder().decodeBuffer(content);
		byte[] enCodeFormat = KEYASE.getBytes();
		SecretKeySpec secretKey = new SecretKeySpec(enCodeFormat, "AES");
		byte[] initParam = IV_STRING.getBytes();
		IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] result = cipher.doFinal(encryptedBytes);
		return new String(result, "UTF-8");
	}

	/**
	 * 参数丢失公共方法
	 * 
	 * @param map
	 * @param log
	 */
	public static void MissParameter(Map<String, Object> map, Log log) {
		map.put(StringUtil.STATUS, StringUtil.STATUS500);
		map.put(StringUtil.DATA, "");
		map.put(StringUtil.INFO, StringUtil.MISSPARAMETERS);
		log.setZt("0");
		log.setErroinfo("邀请好友获得金币参数丢失");
		log.setErroinfodetail(StringUtil.MISSPARAMETERS);
	}

	/**
	 * 
	 * 错误的map设置
	 * 
	 * @param map
	 * @param des
	 * @param info
	 * @param log
	 * @param erroinfo
	 * @param erroinfodetail
	 */
	public static void errorMap(Map<String, Object> map, String des,
                                String info, Log log, String erroinfo, String erroinfodetail,
                                String Status, String yhid) {
		map.put(StringUtil.STATUS, Status);
		map.put(StringUtil.DATA, "");
		map.put(StringUtil.INFO, info);
		map.put(StringUtil.DES, des);
		logError(log, erroinfo, erroinfodetail, yhid);
	}
	
	
	/**
	 * 
	 * 错误的map设置应用内部错误
	 * 
	 * @param map
	 * @param des
	 * @param info
	 * @param log
	 * @param erroinfo
	 * @param erroinfodetail
	 */
	public static void catchMap(Map<String, Object> map, String des,
                                String info, Log log, String erroinfo, String erroinfodetail,
                                String Status, String yhid) {
		map.put(StringUtil.STATUS, Status);
		map.put(StringUtil.DATA, "");
		map.put(StringUtil.INFO, info);
		map.put(StringUtil.DES, des);
		log.setZt("2");
		log.setErroinfo(erroinfo);
		log.setErroinfodetail(erroinfodetail);
		log.setYhid(yhid);
	}
	

	public static void rightMap(Map<String, Object> map, String info, Log log,
                                String message, String Status, Object data, String yhid) {
		map.put(StringUtil.STATUS, Status);
		map.put(StringUtil.DATA, data);
		map.put(StringUtil.INFO, info);
		log.setMessage(message);
		log.setYhid(yhid);
	}


	/**
	 * 
	 * 截取用户名
	 * 
	 * @param yhid
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String substringName(String name) {
		if (name.length() >=10) {
			String first = name.substring(0, 3);
			String last = name.substring(name.length()-3, name.length());
			name = first + "XXX" + last;
		}
		else	if (name.length() > 6) {
			String first = name.substring(0, 3);
			String last = name.substring(6, name.length());
			name = first + "XXX" + last;
		} else if (name.length() > 4&&name.length()<=6) {
			String first = name.substring(0, 2);
			if (name.length() == 5) {
				String last = name.substring(4, name.length());
				name = first + "XX"+last;
			} else {
				String last = name.substring(5, name.length());
				name = first + "XXX" + last;
			}
		} else {
			String first = name.substring(0, 1);
			name = first + "xx";
		}
 
		return name;
	}

	public static void main(String[] args) throws Exception {
	Map map= new HashMap();
	map.put("package_name", "com.follwersbooster");
	//map.put("user_id", "3238905241");
		String json = JSON.toJSONString(map,
				SerializerFeature.WriteMapNullValue).toString();
	System.out.println(encryptAES(json));
	}

}
