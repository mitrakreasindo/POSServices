/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.CategoriesController;
import Chromis.Controller.GeneralController;
import Chromis.Entities.Categories;
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
@Path("chromis.entities.categories")
public class CategoriesFacadeREST extends AbstractFacade<Categories>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public CategoriesFacadeREST()
  {
    super(Categories.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(@PathParam("kode") String kodeMerchant, Categories entity)
  {
    return GeneralController.executeSP(CategoriesController.sp_create(em, kodeMerchant, entity));
  }

  @PUT
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> edit(@PathParam("kode") String kodeMerchant, @PathParam("id") String id, Categories entity)
  {
    entity.setId(id);
    return GeneralController.executeSP(CategoriesController.sp_edit(em, kodeMerchant, entity));
  }

  @DELETE
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> remove(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return GeneralController.executeSP(CategoriesController.sp_remove(em, kodeMerchant, id));
  }

  @GET
  @Override
  @Path("{kode}/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Categories find(@PathParam("kode") String kodeMerchant, @PathParam("id") String id)
  {
    return super.find(kodeMerchant, id);
  }

  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Categories> findAll(@PathParam("kode") String kodeMerchant)
  {
    return super.findAll(kodeMerchant);
  }

//  @GET
//  @Path("{from}/{to}")
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public List<Categories> findRange(@PathParam("kode") String kodeMerchant), @PathParam("from") Integer from, @PathParam("to") Integer to)
//  {
//    return super.findRange(new int[]{from, to});
//  }

  @GET
  @Override
  @Path("{kode}")
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
