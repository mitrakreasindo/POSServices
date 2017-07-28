/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.SalesController;
import Chromis.Entities.Sales;
import Chromis.Entities.SalesPack;
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
@Path("chromis.sales")
public class SalesFacadeREST extends AbstractFacade<Sales>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public SalesFacadeREST()
  {
    super(Sales.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant)
  {
    SalesController sc = new SalesController();    
    SalesPack pack = sc.testSales();
    
    return sc.create(em, kodeMerchant, pack);
    //super.create(entity);
  }
//
//  @PUT
//  @Path("{id}")
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void edit(@PathParam("id") String id, Sales entity)
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
//  @GET
//  @Path("{id}")
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public Sales find(@PathParam("id") String id)
//  {
//    return super.find(id);
//  }
//
//  @GET
//  @Override
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public List<Sales> findAll()
//  {
//    return super.findAll();
//  }
//
//  @GET
//  @Path("{from}/{to}")
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public List<Sales> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
//  {
//    return super.findRange(new int[]{from, to});
//  }
//
//  @GET
//  @Path("count")
//  @Produces(MediaType.TEXT_PLAIN)
//  public String countREST()
//  {
//    return String.valueOf(super.count());
//  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
