/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author INB-07
 */
@Entity
@Table(name = "subcategoria")
public class Subcategoria implements Serializable {

    private static final long serialVersionUID = -8617231033866406103L;

    @Basic(optional = false)
    @Column(name = "sub_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subId;

    @Basic(optional = false)
    @Column(name = "fk_cat_id")
    private int fkCatId;

    @Basic(optional = false)
    @Column(name = "sub_nome")
    private String subNome;

    public Subcategoria() {
    }

    public Subcategoria(Integer subId, Integer fkCatId, String subNome) {
        this.subId = subId;
        this.subNome = subNome;
        this.fkCatId = fkCatId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getFkCatId() {
        return fkCatId;
    }

    public void setFkCatId(int fkCatId) {
        this.fkCatId = fkCatId;
    }

    public String getSubNome() {
        return subNome;
    }

    public void setSubNome(String subNome) {
        this.subNome = subNome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.subId;
        hash = 67 * hash + this.fkCatId;
        hash = 67 * hash + Objects.hashCode(this.subNome);
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
        final Subcategoria other = (Subcategoria) obj;
        if (this.subId != other.subId) {
            return false;
        }
        if (this.fkCatId != other.fkCatId) {
            return false;
        }
        if (!Objects.equals(this.subNome, other.subNome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subcategoria{" + "subId=" + subId + ", fkCatId=" + fkCatId + ", subNome=" + subNome + '}';
    }

}
