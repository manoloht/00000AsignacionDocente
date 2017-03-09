/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsignacionDocente.ejb;

import AsignacionDocente.entity.Ggdca;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Manuel
 */
@Stateless
public class GgdcaFacade extends AbstractFacade<Ggdca> {

    @PersistenceContext(unitName = "AsignacionDocente-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GgdcaFacade() {
        super(Ggdca.class);
    }
    
}
