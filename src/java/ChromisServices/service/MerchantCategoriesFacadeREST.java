/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Entities.MerchantCategories;
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
@Path("chromis.merchantcategories")
public class MerchantCategoriesFacadeREST extends AbstractFacade<MerchantCategories>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public MerchantCategoriesFacadeREST()
  {
    super(MerchantCategories.class);
  }

  @GET
  @Override
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<MerchantCategories> findAll(@PathParam("kode") String kodeMerchant)
  {
//    Query query = getEntityManager().createNativeQuery("select business_category_id, business_category_name, business_category_name, business_subcategory_name \n" +
//         "from "+kodeMerchant+".merchant_business_categories");
    List<MerchantCategories> p = super.findAll(kodeMerchant);
    return p;
  }
  
  @GET
  @Path("{kode}/getname")
  @Produces(MediaType.APPLICATION_JSON)
  public List<MerchantCategories> findName(@PathParam("kode") String kodeMerchant)
  {
    Query query = getEntityManager().createNativeQuery("select distinct on(name)id, name, subcategory, sflag \n" +
      "from "+kodeMerchant+".MerchantCategories \n" +
      "where sflag = true \n"+
      "order by name", MerchantCategories.class);
    List<MerchantCategories> p = query.getResultList();
    return p;
  }
  
  @GET
  @Path("{kode}/getsubname/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<MerchantCategories> findSub(@PathParam("kode") String kodeMerchant, @PathParam("name") String name)
  {
    Query query = getEntityManager().createNativeQuery("select id, name, subcategory, sflag \n" +
      "from "+kodeMerchant+".MerchantCategories \n" +
      "where sflag = true \n" +
      "and name = '"+name+"'", MerchantCategories.class);
    List<MerchantCategories> p = query.getResultList();
    return p;
  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
