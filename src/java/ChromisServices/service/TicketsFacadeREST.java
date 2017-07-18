/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Entities.Viewtickets;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("chromis.tickets")
public class TicketsFacadeREST extends AbstractFacade<Viewtickets>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public TicketsFacadeREST()
  {
    super(Viewtickets.class);
  }

//  @POST
//  @Override
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void create(Tickets entity)
//  {
//    super.create(entity);
//  }
//
//  @PUT
//  @Path("{id}")
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void edit(@PathParam("id") String id, Tickets entity)
//  {
//    super.edit(entity);
//  }
//
//  @DELETE
//  @Path("{id}")
//  public void remove(@PathParam("id") String id)
//  {
//    super.remove(super.find(id));
//  }
//
  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Viewtickets find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  //Select all rows from table
  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Viewtickets> findAll(@PathParam("kode") String kodeMerchant)
  {
    //Query q = em.createNativeQuery("Select t from viewtickets t join fetch t.ticketlin")
    List<Viewtickets> p = super.findAll(kodeMerchant);
    return p;
  }

  @GET
  @Override
  @Path("{kode}/count")
  @Produces(MediaType.TEXT_PLAIN)
  public int count(@PathParam("kode") String kodeMerchant)
  {
    return super.count(kodeMerchant);
  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
