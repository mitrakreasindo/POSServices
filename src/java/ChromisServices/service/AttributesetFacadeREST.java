/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Entities.Attributeset;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Asun
 */
@Stateless
@Path("chromis.attributeset")
public class AttributesetFacadeREST extends AbstractFacade<Attributeset>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public AttributesetFacadeREST()
  {
    super(Attributeset.class);
  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
