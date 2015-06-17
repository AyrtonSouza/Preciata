/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.dao.ImagensDAO;
import com.inb.projeto.model.entity.Imagens;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thrax
 */
@Service
public class ImagensService {
    
    @Inject
    private ImagensDAO imagensDAO;
    
    
    public void salvar(Imagens imagens) throws DAOException{
    
    imagensDAO.salvar(imagens);
    }
    
}
