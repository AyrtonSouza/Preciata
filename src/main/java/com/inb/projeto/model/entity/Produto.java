/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ale
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = -6940287749063012534L;

    @Basic(optional = false)
    @Column(name = "prod_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;

    @Basic(optional = false)
    @Column(name = "prod_nome")
    private String prodNome;

    @Basic(optional = false)
    @Column(name = "prod_preco")
    private float prodPreco;

    @Basic(optional = false)
    @Column(name = "prod_quantidade")
    private int prodQuantidade;

    @Column(name = "prod_descricao")
    private String prodDescricao;

    @Basic(optional = false)
    @Column(name = "fk_desc_id")
    private Integer fkDescId;

    @Basic(optional = false)
    @Column(name = "fk_cat_id")
    private int fkCatId;

    @Basic(optional = false)
    @Column(name = "fk_subcat_id")
    private int fkSubCatId;

    public Produto() {
    }

    public Produto(int prodId, String prodNome, float prodPreco, int prodQuantidade, String prodDescricao, int fkDescId, int fkCatId, int fkSubCatId) {
        this.prodId = prodId;
        this.prodNome = prodNome;
        this.prodPreco = prodPreco;
        this.prodQuantidade = prodQuantidade;
        this.prodDescricao = prodDescricao;
        this.fkDescId = fkDescId;
        this.fkCatId = fkCatId;
        this.fkSubCatId = fkSubCatId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdNome() {
        return prodNome;
    }

    public void setProdNome(String prodNome) {
        this.prodNome = prodNome;
    }

    public float getProdPreco() {
        return prodPreco;
    }

    public void setProdPreco(float prodPreco) {
        this.prodPreco = prodPreco;
    }

    public int getProdQuantidade() {
        return prodQuantidade;
    }

    public void setProdQuantidade(int prodQuantidade) {
        this.prodQuantidade = prodQuantidade;
    }

    public String getProdDescricao() {
        return prodDescricao;
    }

    public void setProdDescricao(String prodDescricao) {
        this.prodDescricao = prodDescricao;
    }

    public int getFkDescId() {
        return fkDescId;
    }

    public void setFkDescId(int fkDescId) {
        this.fkDescId = fkDescId;
    }

    public int getFkCatId() {
        return fkCatId;
    }

    public void setFkCatId(int fkCatId) {
        this.fkCatId = fkCatId;
    }

    public int getFkSubCatId() {
        return fkSubCatId;
    }

    public void setFkSubCatId(int fkSubCatId) {
        this.fkSubCatId = fkSubCatId;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.prodId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return this.prodId == other.prodId;
    }

    @Override
    public String toString() {
        return "Produto{" + "prodId=" + prodId + ", prodNome=" + prodNome + '}';
    }

}
