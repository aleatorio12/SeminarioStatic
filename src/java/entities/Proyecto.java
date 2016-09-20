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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "PROYECTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p"),
    @NamedQuery(name = "Proyecto.findByNog", query = "SELECT p FROM Proyecto p WHERE p.nog = :nog"),
    @NamedQuery(name = "Proyecto.findByNombre", query = "SELECT p FROM Proyecto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyecto.findByMonto", query = "SELECT p FROM Proyecto p WHERE p.monto = :monto"),
    @NamedQuery(name = "Proyecto.findByDireccion", query = "SELECT p FROM Proyecto p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proyecto.findByFechaInicio", query = "SELECT p FROM Proyecto p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyecto.findByFechaFinalizacion", query = "SELECT p FROM Proyecto p WHERE p.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Proyecto.findByImpactoSocial", query = "SELECT p FROM Proyecto p WHERE p.impactoSocial = :impactoSocial"),
    @NamedQuery(name = "Proyecto.findByEstado", query = "SELECT p FROM Proyecto p WHERE p.estado = :estado")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NOG")
    private Integer nog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private double monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Column(name = "IMPACTO_SOCIAL")
    private Integer impactoSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private Character estado;
    @ManyToMany(mappedBy = "proyectoList")
    private List<Auditor> auditorList;
    @JoinColumn(name = "ENTE_EJECUTOR", referencedColumnName = "ID_ENTE")
    @ManyToOne(optional = false)
    private Ente enteEjecutor;
    @JoinColumn(name = "ENTE_RECTOR", referencedColumnName = "ID_ENTE")
    @ManyToOne(optional = false)
    private Ente enteRector;
    @JoinColumn(name = "ENTE_SUPERVISOR", referencedColumnName = "ID_ENTE")
    @ManyToOne(optional = false)
    private Ente enteSupervisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "proyecto1")
    private Fase fase;

    public Proyecto() {
    }

    public Proyecto(Integer nog) {
        this.nog = nog;
    }

    public Proyecto(Integer nog, String nombre, double monto, String direccion, Character estado) {
        this.nog = nog;
        this.nombre = nombre;
        this.monto = monto;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Integer getNog() {
        return nog;
    }

    public void setNog(Integer nog) {
        this.nog = nog;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Integer getImpactoSocial() {
        return impactoSocial;
    }

    public void setImpactoSocial(Integer impactoSocial) {
        this.impactoSocial = impactoSocial;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Auditor> getAuditorList() {
        return auditorList;
    }

    public void setAuditorList(List<Auditor> auditorList) {
        this.auditorList = auditorList;
    }

    public Ente getEnteEjecutor() {
        return enteEjecutor;
    }

    public void setEnteEjecutor(Ente enteEjecutor) {
        this.enteEjecutor = enteEjecutor;
    }

    public Ente getEnteRector() {
        return enteRector;
    }

    public void setEnteRector(Ente enteRector) {
        this.enteRector = enteRector;
    }

    public Ente getEnteSupervisor() {
        return enteSupervisor;
    }

    public void setEnteSupervisor(Ente enteSupervisor) {
        this.enteSupervisor = enteSupervisor;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nog != null ? nog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.nog == null && other.nog != null) || (this.nog != null && !this.nog.equals(other.nog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Proyecto[ nog=" + nog + " ]";
    }
    
}
