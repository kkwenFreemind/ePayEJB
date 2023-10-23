package com.epay.ejb.exception;

public class DataNotFound extends Exception {
//	private static final long serialVersionUID = 1L;
	
	public DataNotFound() {
	}

	public DataNotFound(String msg) {
		super(msg);
	}

	public DataNotFound(String msg, Throwable e) {
		super(msg, e);
	}
}
