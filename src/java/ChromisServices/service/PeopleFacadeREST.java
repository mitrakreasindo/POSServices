/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.People;
import Controller.GeneralController;
import Controller.PeopleController;
import java.util.HashMap;
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
@Path("chromis.people")
public class PeopleFacadeREST extends AbstractFacade<People>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public PeopleFacadeREST()
  {
    super(People.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant, People entity)
  {
    return GeneralController.executeSP(PeopleController.sp_create(em, kodeMerchant, entity));
  }

  @PUT
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> edit(@PathParam("kode") String kodeMerchant, People entity)
  {
    return GeneralController.executeSP(PeopleController.sp_edit(em, kodeMerchant, entity));
  }

  @DELETE
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> remove(@PathParam("kode") String kodeMerchant, People entity)
  {
    return GeneralController.executeSP(PeopleController.sp_remove(em, kodeMerchant, entity));
  }
  
  //Find entity by ID
  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public People find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  //Select all rows from table
  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<People> findAll(@PathParam("kode") String kodeMerchant)
  {
    List<People> p = super.findAll(kodeMerchant);
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
