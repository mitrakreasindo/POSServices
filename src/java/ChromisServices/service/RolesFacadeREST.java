/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.GeneralController;
import Chromis.Controller.RolesControler;
import Chromis.Entities.Roles;
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
@Path("chromis.roles")
public class RolesFacadeREST extends AbstractFacade<Roles>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public RolesFacadeREST()
  {
    super(Roles.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant, Roles entity)
  {
    return GeneralController.executeSP(RolesControler.sp_create(em, kodeMerchant, entity));
  }

  @PUT
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> edit(@PathParam("kode") String kodeMerchant, @PathParam("id") String id, Roles entity)
  {
    entity.setId(id);
    return GeneralController.executeSP(RolesControler.sp_edit(em, kodeMerchant, entity));
  }

  @DELETE
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> remove(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return GeneralController.executeSP(RolesControler.sp_remove(em, kodeMerchant, id));
  }

  //Find entity by ID
  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Roles find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  //Select all rows from table
  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Roles> findAll(@PathParam("kode") String kodeMerchant)
  {
    List<Roles> p = super.findAll(kodeMerchant);
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
