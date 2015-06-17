/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import com.inb.projeto.model.entity.Subcategoria;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author INB-07
 */
@Repository("subCategoriaDao")
public class SubCategoriaDao extends GenericDAO<Subcategoria> {

    public SubCategoriaDao() {
        super(Subcategoria.class);
    }

    public List<Subcategoria> findByCategoria(int id) {
         return entityManager.createQuery("from Subcategoria s where s.fkCatId = '"+ id+"'").getResultList();
    }
}
