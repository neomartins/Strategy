package com.strategy.service;

/**
 * Created by Gustavo Martins
 */
public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8188590394221178207L;

	/**
	 * Generic Exception
	 * 
	 * @param String
	 */
	public GenericException(String message) {
		super(message);
	}

}
