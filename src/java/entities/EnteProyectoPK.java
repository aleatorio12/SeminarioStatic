/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Embeddable
public class EnteProyectoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTE")
    private int ente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTO")
    private int proyecto;

    public EnteProyectoPK() {
    }

    public EnteProyectoPK(int ente, int proyecto) {
        this.ente = ente;
        this.proyecto = proyecto;
    }

    public int getEnte() {
        return ente;
    }

    public void setEnte(int ente) {
        this.ente = ente;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ente;
        hash += (int) proyecto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnteProyectoPK)) {
            return false;
        }
        EnteProyectoPK other = (EnteProyectoPK) object;
        if (this.ente != other.ente) {
            return false;
        }
        if (this.proyecto != other.proyecto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EnteProyectoPK[ ente=" + ente + ", proyecto=" + proyecto + " ]";
    }
    
}
