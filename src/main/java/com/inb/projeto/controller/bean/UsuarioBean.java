/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.controller.bean;

import com.inb.projeto.model.entity.Usuario;
import com.inb.projeto.model.service.ServiceException;
import com.inb.projeto.model.service.UsuarioService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;

/**
 *
 * @author INB-07
 */
@Controller
@RequestScoped
public class UsuarioBean {

    private Usuario usuario = new Usuario();

    private List<Usuario> usuarioList;

    @Inject
    private UsuarioService usuarioService;

    public UsuarioBean() {
    }

    public void salvar() throws ServiceException {
        try {
            usuario.setUsuStatus(true);
            usuarioService.salvar(usuario);
            usuario.setFkPermiId(2);
            usuario = new Usuario();
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar: " + e.getMessage(), null));
        }

    }

    public void salvarFunci() throws ServiceException {
        try {
            usuario.setUsuStatus(true);
            usuario.setFkPermiId(1);
            usuarioService.salvar(usuario);
            usuario = new Usuario();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso ao salvar: " ,null));
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar: " + e.getMessage(), null));
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> getUsuarioList() {
        
        return usuarioList;
    }
    
    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }
    
    public List<Usuario> getFunciList() {
        usuarioList = usuarioService.getFunci();
        return usuarioList;
    }

}
