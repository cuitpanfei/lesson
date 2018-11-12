package com.pfinfo.util.exception;

/**
 * 自定义异常
 * @author pys1714
 *
 */
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6318956416116251113L;
	
	public CustomException(){
		super();
	}
	
	public CustomException(String msg){
		super(msg);
	}

	public CustomException(String msg,Throwable e){
		super(msg,e);
	}
}
