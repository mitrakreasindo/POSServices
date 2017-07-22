/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.GeneralController;
import Chromis.Controller.MerchantPeopleController;
import Chromis.Entities.MerchantPeople;
import Chromis.Utilities.GeneralFunction;
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
@Path("chromis.merchantpeople")
public class MerchantPeopleFacadeREST extends AbstractFacade<MerchantPeople>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public MerchantPeopleFacadeREST()
  {
    super(MerchantPeople.class);
  }

  @POST
  //@Path("{kode}")
  @Path("/test")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(String temp)
  {
    //GeneralFunction.sendRegistrationMail("", "", "Berhasil testing");
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    result.put(1, "Berhasil");
    return result;
    //return GeneralController.executeSP(MerchantPeopleController.sp_create(em));
  }
  
  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
