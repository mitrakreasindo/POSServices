/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Controller.GeneralController;
import Chromis.Controller.MerchantController;
import Chromis.Entities.MerchantRegistration;
import Chromis.Entities.Merchants;
import Chromis.Utilities.GeneralFunction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@Path("chromis.merchants")
public class MerchantsFacadeREST extends AbstractFacade<Merchants>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public MerchantsFacadeREST()
  {
    super(Merchants.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(MerchantRegistration entities)
  {
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    
    //Generate password
    String generatedpassword = GeneralFunction.generatePassword();
    //String generatedpassword = "Admin1234!";
    String username = entities.getMerchant().getCode()+ "_admin";
    entities.getPeople().setApppassword(generatedpassword);
    entities.getPeople().setName(generatedpassword);
    
    //Exec sp
    HashMap<Integer, String> spresult = new HashMap<Integer, String>();
    spresult = GeneralController.executeSP(MerchantController.sp_create(em, entities));
    
    //If succes or return = 1 than send email
    Map.Entry<Integer,String> entry = spresult.entrySet().iterator().next();
    if(entry.getKey() == 1)
    {
        boolean isSent = GeneralFunction.sendRegistrationMail(entities);
        if(isSent == false)
        {
          result.put(1, "Registrasi merchant berhasil dan terdapat kendala dalam pengiriman email. Mohon hubungi contact yang tersedia.");
          return result;
        }
    }
    
    return spresult;
  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
