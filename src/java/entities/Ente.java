/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerdmi
 */
@Entity
@Table(name = "ENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ente.findAll", query = "SELECT e FROM Ente e"),
    @NamedQuery(name = "Ente.findByIdEnte", query = "SELECT e FROM Ente e WHERE e.idEnte = :idEnte"),
    @NamedQuery(name = "Ente.findByNombre", query = "SELECT e FROM Ente e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Ente.findByDireccion", query = "SELECT e FROM Ente e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Ente.findByTipoEnte", query = "SELECT e FROM Ente e WHERE e.tipoEnte = :tipoEnte")})
public class Ente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ENTE")
    private Integer idEnte;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 45)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_ENTE")
    private int tipoEnte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ente1")
    private List<EnteProyecto> enteProyectoList;

    public Ente() {
    }

    public Ente(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public Ente(Integer idEnte, int tipoEnte) {
        this.idEnte = idEnte;
        this.tipoEnte = tipoEnte;
    }

    public Integer getIdEnte() {
        return idEnte;
    }

    public void setIdEnte(Integer idEnte) {
        this.idEnte = idEnte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipoEnte() {
        return tipoEnte;
    }

    public void setTipoEnte(int tipoEnte) {
        this.tipoEnte = tipoEnte;
    }

    @XmlTransient
    public List<EnteProyecto> getEnteProyectoList() {
        return enteProyectoList;
    }

    public void setEnteProyectoList(List<EnteProyecto> enteProyectoList) {
        this.enteProyectoList = enteProyectoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnte != null ? idEnte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ente)) {
            return false;
        }
        Ente other = (Ente) object;
        if ((this.idEnte == null && other.idEnte != null) || (this.idEnte != null && !this.idEnte.equals(other.idEnte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ente[ idEnte=" + idEnte + " ]";
    }
    
}
