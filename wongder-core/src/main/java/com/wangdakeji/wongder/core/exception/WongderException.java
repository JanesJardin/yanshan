package com.wangdakeji.wongder.core.exception;

import lombok.Data;

/**
 * @author cj
 * @Description 业务异常的封装
 * @date 2016年11月12日 下午5:05:10
 */
@Data
public class WongderException extends RuntimeException {

	//友好提示的code码
	protected int code;

	//友好提示
	protected String message;

	//业务异常跳转的页面
	protected String urlPath;

	protected WongderException(int friendlyCode, String friendlyMsg, String urlPath) {
		this.setValues(friendlyCode, friendlyMsg, urlPath);
	}

	public WongderException(WongderExceptionEnum bizExceptionEnum) {
		this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}

	private void setValues(int friendlyCode, String friendlyMsg, String urlPath) {
		this.code = friendlyCode;
		this.message = friendlyMsg;
		this.urlPath = urlPath;
	}
}
