/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsignacionDocente.ejb;

import AsignacionDocente.entity.Centro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Manuel
 */
@Stateless
public class CentroFacade extends AbstractFacade<Centro> {

    @PersistenceContext(unitName = "AsignacionDocente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroFacade() {
        super(Centro.class);
    }
    
}
