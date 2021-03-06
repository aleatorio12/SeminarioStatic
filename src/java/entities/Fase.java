/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Entity
@Table(name = "FASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fase.findAll", query = "SELECT f FROM Fase f"),
    @NamedQuery(name = "Fase.findByIdFase", query = "SELECT f FROM Fase f WHERE f.idFase = :idFase"),
    @NamedQuery(name = "Fase.findByNombre", query = "SELECT f FROM Fase f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Fase.findByFechaInicio", query = "SELECT f FROM Fase f WHERE f.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Fase.findByFechaFinalizacion", query = "SELECT f FROM Fase f WHERE f.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Fase.findByEstado", query = "SELECT f FROM Fase f WHERE f.estado = :estado")})
public class Fase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FASE")
    private Integer idFase;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ESTADO")
    private String estado;
    @JoinTable(name = "FASE_HALLAZGO", joinColumns = {
        @JoinColumn(name = "ID_FASE", referencedColumnName = "ID_FASE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_HALLAZGO", referencedColumnName = "ID_HALLAZGO")})
    @ManyToMany
    private List<Hallazgo> hallazgoList;
    @JoinTable(name = "PROYECTO_DETALLE", joinColumns = {
        @JoinColumn(name = "FASE", referencedColumnName = "ID_FASE")}, inverseJoinColumns = {
        @JoinColumn(name = "PROYECTO", referencedColumnName = "NOG")})
    @ManyToMany
    private List<Proyecto> proyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fase")
    private List<Archivo> archivoList;

    public Fase() {
    }

    public Fase(Integer idFase) {
        this.idFase = idFase;
    }

    public Fase(Integer idFase, String nombre, String estado) {
        this.idFase = idFase;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdFase() {
        return idFase;
    }

    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Hallazgo> getHallazgoList() {
        return hallazgoList;
    }

    public void setHallazgoList(List<Hallazgo> hallazgoList) {
        this.hallazgoList = hallazgoList;
    }

    @XmlTransient
    public List<Proyecto> getProyectoList() {
        return proyectoList;
    }

    public void setProyectoList(List<Proyecto> proyectoList) {
        this.proyectoList = proyectoList;
    }

    @XmlTransient
    public List<Archivo> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<Archivo> archivoList) {
        this.archivoList = archivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFase != null ? idFase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fase)) {
            return false;
        }
        Fase other = (Fase) object;
        if ((this.idFase == null && other.idFase != null) || (this.idFase != null && !this.idFase.equals(other.idFase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fase[ idFase=" + idFase + " ]";
    }
    
}
