package com.wangdakeji.wongder.core.exception;

/**
 * @Description 所有业务异常的枚举
 * @author cj
 * @date 2016年11月12日 下午5:04:51
 */
public enum WongderExceptionEnum {

	/**
	 * 其他
	 */
	WRITE_ERROR(500,"渲染界面错误"),

	/**
	 * 文件上传
	 */
	FILE_READING_ERROR(400,"FILE_READING_ERROR!"),
	FILE_NOT_FOUND(400,"FILE_NOT_FOUND!"),

	/**
	 * 错误的请求
	 */
	REQUEST_NULL(400, "请求有错误"),
	SERVER_ERROR(500, "服务器异常");

	WongderExceptionEnum(int code, String message) {
		this.exceptionCode = code;
		this.exceptionMsg = message;
	}

	WongderExceptionEnum(int code, String message, String urlPath) {
		this.exceptionCode = code;
		this.exceptionMsg = message;
		this.urlPath = urlPath;
	}

	private int exceptionCode;

	private String exceptionMsg;

	private String urlPath;

	public int getCode() {
		return exceptionCode;
	}

	public void setCode(int code) {
		this.exceptionCode = code;
	}

	public String getMessage() {
		return exceptionMsg;
	}

	public void setMessage(String message) {
		this.exceptionMsg = message;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

}
