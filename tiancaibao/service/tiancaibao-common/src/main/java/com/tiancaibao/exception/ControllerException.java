package com.tiancaibao.exception;

import com.tiancaibao.utils.LogUtil;

/**
 * @author Mack
 *
 *  自定义异常处理类
 *
 */
public class ControllerException extends RuntimeException {
	private static final long serialVersionUID = -809108898932598281L;

	public ControllerException() {
		super();
		LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public ControllerException(String message) {

		super(message);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public ControllerException(Throwable cause) {
		super(cause);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}
}
