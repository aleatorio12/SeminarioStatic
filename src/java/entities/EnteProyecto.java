/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Entity
@Table(name = "ENTE_PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnteProyecto.findAll", query = "SELECT e FROM EnteProyecto e"),
    @NamedQuery(name = "EnteProyecto.findByEnte", query = "SELECT e FROM EnteProyecto e WHERE e.enteProyectoPK.ente = :ente"),
    @NamedQuery(name = "EnteProyecto.findByProyecto", query = "SELECT e FROM EnteProyecto e WHERE e.enteProyectoPK.proyecto = :proyecto"),
    @NamedQuery(name = "EnteProyecto.findByRol", query = "SELECT e FROM EnteProyecto e WHERE e.rol = :rol")})
public class EnteProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnteProyectoPK enteProyectoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROL")
    private String rol;
    @JoinColumn(name = "ENTE", referencedColumnName = "ID_ENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ente ente1;
    @JoinColumn(name = "PROYECTO", referencedColumnName = "NOG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto1;

    public EnteProyecto() {
    }

    public EnteProyecto(EnteProyectoPK enteProyectoPK) {
        this.enteProyectoPK = enteProyectoPK;
    }

    public EnteProyecto(EnteProyectoPK enteProyectoPK, String rol) {
        this.enteProyectoPK = enteProyectoPK;
        this.rol = rol;
    }

    public EnteProyecto(int ente, int proyecto) {
        this.enteProyectoPK = new EnteProyectoPK(ente, proyecto);
    }

    public EnteProyectoPK getEnteProyectoPK() {
        return enteProyectoPK;
    }

    public void setEnteProyectoPK(EnteProyectoPK enteProyectoPK) {
        this.enteProyectoPK = enteProyectoPK;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Ente getEnte1() {
        return ente1;
    }

    public void setEnte1(Ente ente1) {
        this.ente1 = ente1;
    }

    public Proyecto getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(Proyecto proyecto1) {
        this.proyecto1 = proyecto1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enteProyectoPK != null ? enteProyectoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnteProyecto)) {
            return false;
        }
        EnteProyecto other = (EnteProyecto) object;
        if ((this.enteProyectoPK == null && other.enteProyectoPK != null) || (this.enteProyectoPK != null && !this.enteProyectoPK.equals(other.enteProyectoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EnteProyecto[ enteProyectoPK=" + enteProyectoPK + " ]";
    }
    
}
