package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String mensagem) {
		super(mensagem);
	}

	public ServiceException(String mensagem, DAOException e) {
		super(mensagem,e);
	}
	
	

}
