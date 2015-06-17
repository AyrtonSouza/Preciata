/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.dao;

import com.inb.projeto.model.entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author INB-07
 */
@Repository("usuarioDao")
public class UsuarioDAO extends GenericDAO<Usuario>{

    public UsuarioDAO() {
       super(Usuario.class);
    }
    
    public List<Usuario> getFunci(){
    
    return entityManager.createQuery("From Usuario u where u.fkPermiId = 1",entity).getResultList();
    }
    
    public List<Usuario> getUsu(){
    
    return entityManager.createQuery("From Usuario u where u.fkPermiId = 2",entity).getResultList();
    }
}
