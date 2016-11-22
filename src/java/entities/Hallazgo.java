/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Entity
@Table(name = "HALLAZGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hallazgo.findAll", query = "SELECT h FROM Hallazgo h"),
    @NamedQuery(name = "Hallazgo.findByIdHallazgo", query = "SELECT h FROM Hallazgo h WHERE h.idHallazgo = :idHallazgo"),
    @NamedQuery(name = "Hallazgo.findByComentario", query = "SELECT h FROM Hallazgo h WHERE h.comentario = :comentario")})
public class Hallazgo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HALLAZGO")
    private Integer idHallazgo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "COMENTARIO")
    private String comentario;
    @ManyToMany(mappedBy = "hallazgoList")
    private List<Fase> faseList;

    public Hallazgo() {
    }

    public Hallazgo(Integer idHallazgo) {
        this.idHallazgo = idHallazgo;
    }

    public Hallazgo(Integer idHallazgo, String comentario) {
        this.idHallazgo = idHallazgo;
        this.comentario = comentario;
    }

    public Integer getIdHallazgo() {
        return idHallazgo;
    }

    public void setIdHallazgo(Integer idHallazgo) {
        this.idHallazgo = idHallazgo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @XmlTransient
    public List<Fase> getFaseList() {
        return faseList;
    }

    public void setFaseList(List<Fase> faseList) {
        this.faseList = faseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHallazgo != null ? idHallazgo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hallazgo)) {
            return false;
        }
        Hallazgo other = (Hallazgo) object;
        if ((this.idHallazgo == null && other.idHallazgo != null) || (this.idHallazgo != null && !this.idHallazgo.equals(other.idHallazgo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Hallazgo[ idHallazgo=" + idHallazgo + " ]";
    }
    
}
