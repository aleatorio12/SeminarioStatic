/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Entity
@Table(name = "PROYECTO_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProyectoDetalle.findAll", query = "SELECT p FROM ProyectoDetalle p"),
    @NamedQuery(name = "ProyectoDetalle.findByProyecto", query = "SELECT p FROM ProyectoDetalle p WHERE p.proyectoDetallePK.proyecto = :proyecto"),
    @NamedQuery(name = "ProyectoDetalle.findByFase", query = "SELECT p FROM ProyectoDetalle p WHERE p.proyectoDetallePK.fase = :fase"),
    @NamedQuery(name = "ProyectoDetalle.findByEnte", query = "SELECT p FROM ProyectoDetalle p WHERE p.ente = :ente"),
    @NamedQuery(name = "ProyectoDetalle.findByPROYECTODETALLEcol", query = "SELECT p FROM ProyectoDetalle p WHERE p.pROYECTODETALLEcol = :pROYECTODETALLEcol")})
public class ProyectoDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectoDetallePK proyectoDetallePK;
    @Column(name = "ENTE")
    private Integer ente;
    @Size(max = 45)
    @Column(name = "PROYECTO_DETALLEcol")
    private String pROYECTODETALLEcol;
    @JoinColumn(name = "PROYECTO", referencedColumnName = "NOG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyecto proyecto1;
    @JoinColumn(name = "FASE", referencedColumnName = "ID_FASE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fase fase1;

    public ProyectoDetalle() {
    }

    public ProyectoDetalle(ProyectoDetallePK proyectoDetallePK) {
        this.proyectoDetallePK = proyectoDetallePK;
    }

    public ProyectoDetalle(int proyecto, int fase) {
        this.proyectoDetallePK = new ProyectoDetallePK(proyecto, fase);
    }

    public ProyectoDetallePK getProyectoDetallePK() {
        return proyectoDetallePK;
    }

    public void setProyectoDetallePK(ProyectoDetallePK proyectoDetallePK) {
        this.proyectoDetallePK = proyectoDetallePK;
    }

    public Integer getEnte() {
        return ente;
    }

    public void setEnte(Integer ente) {
        this.ente = ente;
    }

    public String getPROYECTODETALLEcol() {
        return pROYECTODETALLEcol;
    }

    public void setPROYECTODETALLEcol(String pROYECTODETALLEcol) {
        this.pROYECTODETALLEcol = pROYECTODETALLEcol;
    }

    public Proyecto getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(Proyecto proyecto1) {
        this.proyecto1 = proyecto1;
    }

    public Fase getFase1() {
        return fase1;
    }

    public void setFase1(Fase fase1) {
        this.fase1 = fase1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoDetallePK != null ? proyectoDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoDetalle)) {
            return false;
        }
        ProyectoDetalle other = (ProyectoDetalle) object;
        if ((this.proyectoDetallePK == null && other.proyectoDetallePK != null) || (this.proyectoDetallePK != null && !this.proyectoDetallePK.equals(other.proyectoDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProyectoDetalle[ proyectoDetallePK=" + proyectoDetallePK + " ]";
    }
    
}
