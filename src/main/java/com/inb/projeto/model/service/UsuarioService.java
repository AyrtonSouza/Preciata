/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.service;

import com.inb.projeto.model.dao.DAOException;
import com.inb.projeto.model.dao.UsuarioDAO;
import com.inb.projeto.model.entity.Usuario;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author INB-07
 */
@Service
public class UsuarioService {

    private Usuario usuario;

    @Inject
    private UsuarioDAO usuarioDAO;

    public void salvar(Usuario usuario) throws ServiceException {
        // Validacao de regra de negocio
        try {
            if (usuario.getUsuNome() == null || "".equals(usuario.getUsuNome())) {
                throw new ServiceException("Nome do Usuario obrigatorio");
            } else {
                usuarioDAO.salvar(usuario);
            }
        } catch (DAOException e) {
            throw new ServiceException("Nao foi possivel salvar", e);
        }
    }

    public void excluir(Usuario usuario) throws DAOException {

        usuarioDAO.deleta(usuario);
    }

    public Usuario getUsuario(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> getAll() {
        return usuarioDAO.getAll();
    }
    
    public List<Usuario> getFunci() {
        return usuarioDAO.getFunci();
    }
    
    public List<Usuario> getUsu() {
        return usuarioDAO.getUsu();
    }   
}
