package com.wangdakeji.wongder.rest.common.exception;

import com.wangdakeji.wongder.core.exception.WongderException;

/**
 * @author cj
 * @Description 业务异常的封装
 * @date 2016年11月12日 下午5:05:10
 */
public class BussinessException extends WongderException {

	public BussinessException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(),"");
	}
}
