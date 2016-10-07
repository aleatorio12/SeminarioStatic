/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yerdmi
 */
@Entity
@Table(name = "ARCHIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivo.findAll", query = "SELECT a FROM Archivo a"),
    @NamedQuery(name = "Archivo.findByIdArchivo", query = "SELECT a FROM Archivo a WHERE a.idArchivo = :idArchivo"),
    @NamedQuery(name = "Archivo.findByNombre", query = "SELECT a FROM Archivo a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Archivo.findByFechaSolicitud", query = "SELECT a FROM Archivo a WHERE a.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Archivo.findByFechaRecepcion", query = "SELECT a FROM Archivo a WHERE a.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "Archivo.findByTipo", query = "SELECT a FROM Archivo a WHERE a.tipo = :tipo")})
public class Archivo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "CONTENIDO")
    private byte[] contenido;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARCHIVO")
    private Integer idArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Size(max = 45)
    @Column(name = "FECHA_SOLICITUD")
    private String fechaSolicitud;
    @Size(max = 45)
    @Column(name = "FECHA_RECEPCION")
    private String fechaRecepcion;
    @Column(name = "TIPO")
    private Character tipo;
    @JoinColumn(name = "FASE", referencedColumnName = "ID_FASE")
    @ManyToOne(optional = false)
    private Fase fase;

    public Archivo() {
    }

    public Archivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Archivo(Integer idArchivo, byte[] contenido, String nombre, String comentario) {
        this.idArchivo = idArchivo;
        this.contenido = contenido;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public Integer getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Integer idArchivo) {
        this.idArchivo = idArchivo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
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
        hash += (idArchivo != null ? idArchivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivo)) {
            return false;
        }
        Archivo other = (Archivo) object;
        if ((this.idArchivo == null && other.idArchivo != null) || (this.idArchivo != null && !this.idArchivo.equals(other.idArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Archivo[ idArchivo=" + idArchivo + " ]";
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
}
