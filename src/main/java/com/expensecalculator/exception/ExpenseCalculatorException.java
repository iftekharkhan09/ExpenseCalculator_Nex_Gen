package com.expensecalculator.exception;

import com.expensecalculator.utils.ResultStatusConstants;

public class ExpenseCalculatorException extends Exception{
	private static final long serialVersionUID = 1L;
	private ResultStatusConstants errorCode;

	public ExpenseCalculatorException(final ResultStatusConstants code,
			final String message) {
		super(message);
		this.errorCode = code;
	}

	public ExpenseCalculatorException(final ResultStatusConstants code,
			final String message, final Throwable cause) {
		super(message, cause);
		this.errorCode = code;
	}

	public ResultStatusConstants getErrorCode() {
		return errorCode;
	}
}
