package com.inb.projeto.model.dao;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String mensagem, Exception e) {
		super(mensagem,e);
	}

}
