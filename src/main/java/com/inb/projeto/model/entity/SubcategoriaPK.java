/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inb.projeto.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author INB-07
 */
@Embeddable
public class SubcategoriaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "sub_id")
    private int subId;
    @Basic(optional = false)
    @Column(name = "fk_cat_id")
    private int fkCatId;

    public SubcategoriaPK() {
    }

    public SubcategoriaPK(int subId, int fkCatId) {
        this.subId = subId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) subId;
        hash += (int) fkCatId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcategoriaPK)) {
            return false;
        }
        SubcategoriaPK other = (SubcategoriaPK) object;
        if (this.subId != other.subId) {
            return false;
        }
        if (this.fkCatId != other.fkCatId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inb.projeto.model.entity.SubcategoriaPK[ subId=" + subId + ", fkCatId=" + fkCatId + " ]";
    }
    
}
