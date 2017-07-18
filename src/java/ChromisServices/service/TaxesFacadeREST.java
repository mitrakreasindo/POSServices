/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.GeneralController;
import Chromis.Controller.TaxesController;
import Chromis.Entities.Taxes;
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
@Path("chromis.taxes")
public class TaxesFacadeREST extends AbstractFacade<Taxes>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public TaxesFacadeREST()
  {
    super(Taxes.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant, Taxes entity)
  {
    return GeneralController.executeSP(TaxesController.sp_create(em, kodeMerchant, entity));
  }

  @PUT
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> edit(@PathParam("kode") String kodeMerchant, @PathParam("id") String id, Taxes entity)
  {
    entity.setId(id);
    return GeneralController.executeSP(TaxesController.sp_edit(em, kodeMerchant, entity));
  }

  @DELETE
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> remove(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return GeneralController.executeSP(TaxesController.sp_remove(em, kodeMerchant, id));
  }

  //Find entity by ID
  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Taxes find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  //Select all rows from table
  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Taxes> findAll(@PathParam("kode") String kodeMerchant)
  {
    List<Taxes> p = super.findAll(kodeMerchant);
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
