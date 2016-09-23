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
public class ProyectoDetallePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTO")
    private int proyecto;
    @Basic(optional = false)
    @Column(name = "FASE")
    private int fase;

    public ProyectoDetallePK() {
    }

    public ProyectoDetallePK(int proyecto, int fase) {
        this.proyecto = proyecto;
        this.fase = fase;
    }

    public int getProyecto() {
        return proyecto;
    }

    public void setProyecto(int proyecto) {
        this.proyecto = proyecto;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyecto;
        hash += (int) fase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoDetallePK)) {
            return false;
        }
        ProyectoDetallePK other = (ProyectoDetallePK) object;
        if (this.proyecto != other.proyecto) {
            return false;
        }
        if (this.fase != other.fase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProyectoDetallePK[ proyecto=" + proyecto + ", fase=" + fase + " ]";
    }
    
}
