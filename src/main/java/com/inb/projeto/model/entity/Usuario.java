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
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Basic(optional = false)
    @Column(name = "usu_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuId;

    @Basic(optional = false)
    @Column(name = "fk_permi_id")
    private int fkPermiId;

    @Basic(optional = false)
    @Column(name = "usu_nome")
    private String usuNome;
    
    @Basic(optional = false)
    @Column(name = "usu_email")
    private String usuEmail;
    
    @Basic(optional = false)
    @Column(name = "usu_senha")
    private String usuSenha;
    
    @Basic(optional = false)
    @Column(name = "usu_telefone")
    private String usuTelefone;
    
    @Basic(optional = false)
    @Column(name = "usu_celular")
    private String usuCelular;
    
    @Basic(optional = false)
    @Column(name = "usu_cpf")
    private String usuCpf;
    
    @Basic(optional = false)
    @Column(name = "usu_cidade")
    private String usuCidade;
    
    @Basic(optional = false)
    @Column(name = "usu_estado")
    private String usuEstado;
    
    @Basic(optional = false)
    @Column(name = "usu_logradouro")
    private String usuLogradouro;
    
    @Basic(optional = false)
    @Column(name = "usu_nmLogradouro")
    private int usunmLogradouro;
    
    @Column(name = "usu_status")
    private Boolean usuStatus;

    public Usuario() {
    }

    public Usuario(Integer usuId, Integer fkPermiId, String usuNome, String usuEmail, String usuSenha, String usuTelefone, String usuCelular, String usuCpf, String usuCidade, String usuEstado, String usuLogradouro, int usunmLogradouro) {
        this.usuId = usuId;
        this.fkPermiId = fkPermiId;
        this.usuNome = usuNome;
        this.usuEmail = usuEmail;
        this.usuSenha = usuSenha;
        this.usuTelefone = usuTelefone;
        this.usuCelular = usuCelular;
        this.usuCpf = usuCpf;
        this.usuCidade = usuCidade;
        this.usuEstado = usuEstado;
        this.usuLogradouro = usuLogradouro;
        this.usunmLogradouro = usunmLogradouro;
    }

    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public int getFkPermiId() {
        return fkPermiId;
    }

    public void setFkPermiId(int fkPermiId) {
        this.fkPermiId = fkPermiId;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public String getUsuTelefone() {
        return usuTelefone;
    }

    public void setUsuTelefone(String usuTelefone) {
        this.usuTelefone = usuTelefone;
    }

    public String getUsuCelular() {
        return usuCelular;
    }

    public void setUsuCelular(String usuCelular) {
        this.usuCelular = usuCelular;
    }

    public String getUsuCpf() {
        return usuCpf;
    }

    public void setUsuCpf(String usuCpf) {
        this.usuCpf = usuCpf;
    }

    public String getUsuCidade() {
        return usuCidade;
    }

    public void setUsuCidade(String usuCidade) {
        this.usuCidade = usuCidade;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuLogradouro() {
        return usuLogradouro;
    }

    public void setUsuLogradouro(String usuLogradouro) {
        this.usuLogradouro = usuLogradouro;
    }

    public int getUsunmLogradouro() {
        return usunmLogradouro;
    }

    public void setUsunmLogradouro(int usunmLogradouro) {
        this.usunmLogradouro = usunmLogradouro;
    }

    public Boolean getUsuStatus() {
        return usuStatus;
    }

    public void setUsuStatus(Boolean usuStatus) {
        this.usuStatus = usuStatus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.usuId;
        hash = 13 * hash + this.fkPermiId;
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
        final Usuario other = (Usuario) obj;
        if (this.usuId != other.usuId) {
            return false;
        }
        if (this.fkPermiId != other.fkPermiId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuId=" + usuId + ", fkPermiId=" + fkPermiId + ", usuNome=" + usuNome + ", usuEmail=" + usuEmail + ", usuSenha=" + usuSenha + ", usuTelefone=" + usuTelefone + ", usuCelular=" + usuCelular + ", usuCpf=" + usuCpf + ", usuCidade=" + usuCidade + ", usuEstado=" + usuEstado + ", usuLogradouro=" + usuLogradouro + ", usunmLogradouro=" + usunmLogradouro + ", usuStatus=" + usuStatus + '}';
    }

}
