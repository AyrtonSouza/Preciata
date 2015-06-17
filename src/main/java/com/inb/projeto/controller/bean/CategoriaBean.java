/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.controller.bean;

import com.inb.projeto.model.entity.Categoria;
import com.inb.projeto.model.entity.Subcategoria;
import com.inb.projeto.model.service.CategoriaService;
import com.inb.projeto.model.service.SubCategoriaService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class CategoriaBean {

    private Categoria categoria;

    private Subcategoria subcategoria;

    @Inject
    private CategoriaService categoriaService;

    @Inject
    private SubCategoriaService subCategoriaService;

    private List<Categoria> categorias;
    
    private List<Subcategoria> subcategorias;

    public List<Subcategoria> getSubcategorias() {
        subcategorias = subCategoriaService.listAll();
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public CategoriaBean() {
        categoria = new Categoria();
        subcategoria = new Subcategoria();
    }

    @PostConstruct
    public void init() {

    }

    public String salvar() {
        try {
            categoriaService.salvar(categoria);
            categoria = new Categoria();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Salvo com sucesso", null));
                 return "/listarCategoria.faces?faces-redirect=true";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Salvo com sucesso", e.getMessage()));

        }
        return null;
    }

    
    public void salvarSub() {
        try {
            subCategoriaService.salvar(subcategoria);
            subcategoria = new Subcategoria();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Salvo com sucesso", null));

        } catch (Exception e) {
            subcategoria = new Subcategoria();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao Salvar", null));

        }

    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public SubCategoriaService getSubCategoriaService() {
        return subCategoriaService;
    }

    public void setSubCategoriaService(SubCategoriaService subCategoriaService) {
        this.subCategoriaService = subCategoriaService;
    }

    public List<Categoria> getCategorias() {
        categorias = categoriaService.listAll();
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategoriasForSubs() {
        List<Subcategoria> subcategorias = subCategoriaService.listAll();
        List<Categoria> categorias = new ArrayList<>();
        for (Subcategoria subs : subcategorias) {
            categorias.add(categoriaService.findById(subs.getFkCatId()));
        }

        return categorias;
    }

}
