package com.inb.projeto.controller.bean;

import com.inb.projeto.model.entity.Produto;
import com.inb.projeto.model.entity.Venda;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.inb.projeto.model.service.VendaService;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Controller
@RequestScoped
public class VendaBean {

    private Venda venda = new Venda();

    @Inject
    private VendaService vendaService;

    private List<Venda> vendaList;

    private List<Produto> produtos;
    
    private float ValorVenda;

    @PostConstruct
    public void init() {
        vendaList = vendaService.getAll();
    }

    public void excluir() {
        try {
            vendaService.excluir(venda);
            venda = new Venda();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Excluido com sucesso", null));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao excluir: " + e.getMessage(), null));
            e.printStackTrace();
        }
    }

    public void salvar() {

        try {
            vendaService.salvar(venda);
            venda = new Venda();
            vendaList = vendaService.getAll();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Salvo com sucesso", null));

        } catch (Exception e) {
            venda = new Venda();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro ao salvar: " + e.getMessage(), null));
            e.printStackTrace();
        }

    }

    public void criaLista(Produto produto, HttpSession session) {
        ValorVenda = ValorVenda + produto.getProdPreco();
        if (session.getAttribute("carrinhoLista") == null) {
            produtos = new ArrayList<>();
            session.setAttribute("carrinhoLista", produtos.add(produto));
        }else{
        session.setAttribute("carrinhoLista", produtos.add(produto));
        }

    }

    public VendaService getVendaService() {
        return vendaService;
    }

    public void setVendaService(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getVendaList() {
        return vendaList;
    }

    public void setVendaList(List<Venda> VendaList) {
        this.vendaList = vendaList;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public float getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(float ValorVenda) {
        this.ValorVenda = ValorVenda;
    }
    

}
