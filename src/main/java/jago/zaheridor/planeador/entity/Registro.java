/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jago.zaheridor.planeador.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zaheridor
 */
@Entity
@Table(name = "REGISTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r")
    , @NamedQuery(name = "Registro.findByCreado", query = "SELECT r FROM Registro r WHERE r.creado = :creado")
    , @NamedQuery(name = "Registro.findByFecharegistro", query = "SELECT r FROM Registro r WHERE r.fecharegistro = :fecharegistro")
    , @NamedQuery(name = "Registro.findByMoneda", query = "SELECT r FROM Registro r WHERE r.moneda = :moneda")
    , @NamedQuery(name = "Registro.findByValoringreso", query = "SELECT r FROM Registro r WHERE r.valoringreso = :valoringreso")
    , @NamedQuery(name = "Registro.findByValoregreso", query = "SELECT r FROM Registro r WHERE r.valoregreso = :valoregreso")
    , @NamedQuery(name = "Registro.findByNota", query = "SELECT r FROM Registro r WHERE r.nota = :nota")})
public class Registro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fecharegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "MONEDA")
    private String moneda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORINGRESO")
    private BigDecimal valoringreso;
    @Column(name = "VALOREGRESO")
    private BigDecimal valoregreso;
    @Size(max = 300)
    @Column(name = "NOTA")
    private String nota;
    @JoinColumn(name = "CATEGORIA", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Categoria categoria;

    public Registro() {
    }

    public Registro(Date creado) {
        this.creado = creado;
    }

    public Registro(Date creado, Date fecharegistro, String moneda) {
        this.creado = creado;
        this.fecharegistro = fecharegistro;
        this.moneda = moneda;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getValoringreso() {
        return valoringreso;
    }

    public void setValoringreso(BigDecimal valoringreso) {
        this.valoringreso = valoringreso;
    }

    public BigDecimal getValoregreso() {
        return valoregreso;
    }

    public void setValoregreso(BigDecimal valoregreso) {
        this.valoregreso = valoregreso;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creado != null ? creado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.creado == null && other.creado != null) || (this.creado != null && !this.creado.equals(other.creado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jago.zaheridor.planeador.entity.Registro[ creado=" + creado + " ]";
    }
    
}
