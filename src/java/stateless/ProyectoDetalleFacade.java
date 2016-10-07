/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entities.ProyectoDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yerdmi
 */
@Stateless
public class ProyectoDetalleFacade extends AbstractFacade<ProyectoDetalle> {

    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoDetalleFacade() {
        super(ProyectoDetalle.class);
    }
    
}
