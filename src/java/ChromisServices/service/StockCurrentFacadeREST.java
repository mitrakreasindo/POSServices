/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Entities.StockCurrent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

/**
 *
 * @author Asun
 */
@Stateless
@Path("chromis.stockcurrent")
public class StockCurrentFacadeREST extends AbstractFacade<StockCurrent>
{
  
  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public StockCurrentFacadeREST()
  {
    super(StockCurrent.class);
  }

  
  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
