package com.tiancaibao.controller.recharge.sub.exception;

import com.tiancaibao.utils.LogUtil;

public class RechargeException extends RuntimeException {

	public RechargeException() {
		super();
		LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public RechargeException(String message) {

		super(message);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public RechargeException(String message, Throwable cause) {
		super(message, cause);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

	public RechargeException(Throwable cause) {
		super(cause);
		//LogUtil.serviceExceptionLogger.error(this.toString(), this);
	}

}
