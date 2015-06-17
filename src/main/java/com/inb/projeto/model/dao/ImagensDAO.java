/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import com.inb.projeto.model.entity.Imagens;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Thrax
 */
@Repository("imagensDao")
public class ImagensDAO extends GenericDAO<Imagens>{

    public ImagensDAO() {
    super(Imagens.class);
    }
    
    
    
    
}
