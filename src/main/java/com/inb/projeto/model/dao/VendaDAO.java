/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import com.inb.projeto.model.entity.Venda;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ale
 */
@Repository("vendaDao")
public class VendaDAO extends GenericDAO<Venda> {

    public VendaDAO() {
        super(Venda.class);
    }

}
