/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import org.springframework.stereotype.Repository;

import com.inb.projeto.model.entity.Produto;

/**
 *
 * @author ale
 */
@Repository("produtoDao")
public class ProdutoDAO extends GenericDAO<Produto> {

    public ProdutoDAO() {
        super(Produto.class);
    }
    
    public Integer getLastProduto(){
    
    return (Integer) entityManager.createQuery("SELECT MAX(p.prodId) from Produto p").getResultList().get(0);
    }

}
