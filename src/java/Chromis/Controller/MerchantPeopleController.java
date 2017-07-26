/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.MerchantPeople;
import Chromis.Utilities.GeneralFunction;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.codehaus.jackson.map.ObjectMapper;
import org.postgresql.util.PGobject;

/**
 *
 * @author Asun
 */
public class MerchantPeopleController
{
  public static StoredProcedureQuery sp_create(EntityManager em)
  {
    boolean result = true;
    
    MerchantPeople mp = new MerchantPeople();
    mp.setId(10);
    mp.setName("Hola");
    mp.setPersonId("pid");
    
    MerchantPeople mp1 = new MerchantPeople();
    mp1.setId(11);
    mp1.setName("Hulo");
    mp1.setPersonId("pid");
    
    Collection<MerchantPeople> coll = new ArrayList<>();
    coll.add(mp);
    coll.add(mp1);
    
    //Object[] objects = (Object[]) mp;
    
    Object[] foo = coll.toArray(new MerchantPeople[coll.size()]);
    String jsoninString = GeneralFunction.convert2Json(foo);
      
    StoredProcedureQuery query = 
      em.createStoredProcedureQuery("public.insert_merchant_people_beruntun_2");

    //Use native query to execute sp with json input
    Query q = em.createNativeQuery("SELECT * FROM public.insert_merchantpeoplejson('"+jsoninString+"')");
    Object temp = q.getSingleResult();
    
    return query;
  }
}
