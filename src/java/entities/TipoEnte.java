/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Entity
@Table(name = "TIPO_ENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEnte.findAll", query = "SELECT t FROM TipoEnte t"),
    @NamedQuery(name = "TipoEnte.findByIdTipoEnte", query = "SELECT t FROM TipoEnte t WHERE t.idTipoEnte = :idTipoEnte"),
    @NamedQuery(name = "TipoEnte.findByTipo", query = "SELECT t FROM TipoEnte t WHERE t.tipo = :tipo")})
public class TipoEnte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ENTE")
    private Integer idTipoEnte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private Character tipo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoEnte1")
    private Ente ente;

    public TipoEnte() {
    }

    public TipoEnte(Integer idTipoEnte) {
        this.idTipoEnte = idTipoEnte;
    }

    public TipoEnte(Integer idTipoEnte, Character tipo) {
        this.idTipoEnte = idTipoEnte;
        this.tipo = tipo;
    }

    public Integer getIdTipoEnte() {
        return idTipoEnte;
    }

    public void setIdTipoEnte(Integer idTipoEnte) {
        this.idTipoEnte = idTipoEnte;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Ente getEnte() {
        return ente;
    }

    public void setEnte(Ente ente) {
        this.ente = ente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEnte != null ? idTipoEnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEnte)) {
            return false;
        }
        TipoEnte other = (TipoEnte) object;
        if ((this.idTipoEnte == null && other.idTipoEnte != null) || (this.idTipoEnte != null && !this.idTipoEnte.equals(other.idTipoEnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoEnte[ idTipoEnte=" + idTipoEnte + " ]";
    }
    
}
