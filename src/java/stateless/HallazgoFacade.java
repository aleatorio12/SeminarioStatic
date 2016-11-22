/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateless;

import entities.Hallazgo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor Matías <Carné: 4490-13-5931> <vitomany@yahoo.es>
 */
@Stateless
public class HallazgoFacade extends AbstractFacade<Hallazgo> {

    @PersistenceContext(unitName = "EJBModulePjSeminarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HallazgoFacade() {
        super(Hallazgo.class);
    }
    
}
