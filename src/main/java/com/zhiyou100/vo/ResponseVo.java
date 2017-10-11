package com.zhiyou100.vo;

public class ResponseVo<T> {
	/**
	 * 返回给浏览器的数据做一个包装
	 */
	
	// 说明操作的执行结果
	private int errorCode;
	
	// 执行结果的文字描述
	private String message;
	
	// 真正的数据
	private T data;

	public ResponseVo() {
		super();
	}

	public ResponseVo(int errorCode, String message, T data) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVo [errorCode=" + errorCode + ", message=" + message + ", data=" + data + "]";
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
