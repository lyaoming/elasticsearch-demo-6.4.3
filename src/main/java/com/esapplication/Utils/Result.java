package com.esapplication.Utils;

import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

/**
 * 返回数据
 * @author R & D
 * @email 908350381@qq.com
 * @date 2016年10月27日 下午9:59:27
 */
public class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public Result() {
		put("code", 200);
	}
	
	public Result(int code, String msg) {
		put("code", code);
		put("msg", msg);
	}
	
	public Result(int code, String msg, JSONObject data) {
		put("code", code);
		put("msg", msg);
		put("data", data);
	}
	
	public static Result result(int code, String msg, JSONObject data) {
		return new Result(code, msg, data);
	}
	
	public static Result result2(int code, String msg) {
		return new Result(code, msg);
	}
	public static Result result3(int code, String msg, String data) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		r.put("data",data);
		return r;
	}
	
	public static Result result4(int code, String msg, com.alibaba.fastjson.JSONObject data) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		r.put("data",data);
		return r;
	}

	public static Result error() {
		return error(500, "未知异常，请联系管理员吧");
	}

	public static Result error(String msg) {
		return error(500, msg);
	}

	public static Result error(int code, String msg) {
		Result r = new Result();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Result ok(String msg) {
		Result r = new Result();
		r.put("msg", msg);
		return r;
	}

	public static Result ok(Map<String, Object> map) {
		Result r = new Result();
		r.putAll(map);
		return r;
	}

	public static Result ok() {
		Result r = new Result();
		r.put("msg", "success");
		return r;
	}

	public Result put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
