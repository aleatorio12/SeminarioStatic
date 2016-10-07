/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entities.Ente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yerdmi
 */
@Stateless
public class EnteFacade extends AbstractFacade<Ente> {

    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnteFacade() {
        super(Ente.class);
    }
    
}
