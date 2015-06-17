/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import com.inb.projeto.model.entity.Categoria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author INB-07
 */
@Repository("categoriaDao")
public class CategoriaDAO extends GenericDAO<Categoria>{

    public CategoriaDAO() {
    super(Categoria.class);
    }
    
}
