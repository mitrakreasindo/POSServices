/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.GeneralController;
import Chromis.Controller.StockDiaryController;
import Chromis.Entities.Stockdiary;
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
@Path("chromis.stockdiary")
public class StockdiaryFacadeREST extends AbstractFacade<Stockdiary>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public StockdiaryFacadeREST()
  {
    super(Stockdiary.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant, Stockdiary entity)
  {
    return GeneralController.executeSP(StockDiaryController.sp_create(em, kodeMerchant, entity));
  }

//  @PUT
//  @Path("{id}")
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void edit(@PathParam("id") String id, Stockdiary entity)
//  {
//    super.edit(entity);
//  }

//  @DELETE
//  @Path("{id}")
//  public void remove(@PathParam("id") String id)
//  {
//    super.remove(super.find(id));
//  }

  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Stockdiary find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  //Select all rows from table
  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Stockdiary> findAll(@PathParam("kode") String kodeMerchant)
  {
    List<Stockdiary> p = super.findAll(kodeMerchant);
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
