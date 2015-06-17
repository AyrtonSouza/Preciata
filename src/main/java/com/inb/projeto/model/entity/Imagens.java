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
 * @author Thrax
 */
@Entity
@Table(name = "imagens")
public class Imagens implements Serializable {

    @Basic(optional = false)
    @Column(name = "ima_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imaId;

    @Basic(optional = false)
    @Column(name = "fk_prod_id")
    private int fkProdId;

    @Column(name = "ima_nome")
    private String imaNome;

    @Basic(optional = false)
    @Column(name = "ima_caminho")
    private String imaCaminho;

    public Imagens() {
    }

    public Imagens(Integer imaId, Integer fkProdId, String imaCaminho) {
        this.imaId = imaId;
        this.fkProdId = fkProdId;
        this.imaCaminho = imaCaminho;
    }

    public int getImaId() {
        return imaId;
    }

    public void setImaId(int imaId) {
        this.imaId = imaId;
    }

    public int getFkProdId() {
        return fkProdId;
    }

    public void setFkProdId(int fkProdId) {
        this.fkProdId = fkProdId;
    }

    public String getImaNome() {
        return imaNome;
    }

    public void setImaNome(String imaNome) {
        this.imaNome = imaNome;
    }

    public String getImaCaminho() {
        return imaCaminho;
    }

    public void setImaCaminho(String imaCaminho) {
        this.imaCaminho = imaCaminho;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.imaId;
        hash = 29 * hash + this.fkProdId;
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
        final Imagens other = (Imagens) obj;
        if (this.imaId != other.imaId) {
            return false;
        }
        if (this.fkProdId != other.fkProdId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagens{" + "imaId=" + imaId + ", fkProdId=" + fkProdId + ", imaNome=" + imaNome + ", imaCaminho=" + imaCaminho + '}';
    }

}
