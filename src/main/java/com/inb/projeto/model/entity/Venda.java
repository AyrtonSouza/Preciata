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
@Table(name = "venda")
public class Venda implements Serializable{

    @Basic(optional = false)
    @Column(name = "pedido_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pedidoId;

    @Basic(optional = false)
    @Column(name = "pedido_status")
    private String pedidoStatus;

    @Basic(optional = false)
    @Column(name = "fk_usu_id")
    //@OneToOne
    private Usuario usuId;

    public Venda() {
    }

    public Venda(int pedidoId, String pedidoStatus, Usuario usuId) {
        this.pedidoId = pedidoId;
        this.pedidoStatus = pedidoStatus;
        this.usuId = usuId;
    }

    public int getPedidoId() {
        return pedidoId;
    }

    public String getPedidoStatus() {
        return pedidoStatus;
    }

    public void setPedidoStatus(String pedidoStatus) {
        this.pedidoStatus = pedidoStatus;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.pedidoId;
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
        final Venda other = (Venda) obj;
        return other.pedidoId == this.pedidoId;
    }

    @Override
    public String toString() {
        return "Venda{" + "pedidoId=" + pedidoId + ", pedidoStatus=" + pedidoStatus + ", usuId=" + usuId + '}';
    }

}
