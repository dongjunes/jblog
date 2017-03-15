package com.bit2017.jblog.dto;

public class JSONResult {
	private String result;// true성공 false실패
	private String message;
	private Object data;

	private JSONResult() {
	}

	private JSONResult(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public static JSONResult success(Object data) {
		return new JSONResult("success", null, data);
	}
	
	public static JSONResult fail(String message) {
		return new JSONResult("fail", null, null);
	}
	

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	@Override
	public String toString() {
		return "JSONResult [result=" + result + ", message=" + message + ", data=" + data + "]";
	}

}
