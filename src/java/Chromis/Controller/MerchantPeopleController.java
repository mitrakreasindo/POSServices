/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.MerchantPeople;
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
    MerchantPeople mp = new MerchantPeople();
    mp.setId(5);
    mp.setName("Hola");
    mp.setPersonId("pid");
    
    MerchantPeople mp1 = new MerchantPeople();
    mp1.setId(6);
    mp1.setName("Hulo");
    mp1.setPersonId("pid");
    
    Collection<MerchantPeople> coll = new ArrayList<>();
    coll.add(mp);
    coll.add(mp1);
    
    Object[] foo = coll.toArray(new MerchantPeople[coll.size()]);
    //coll.toArray();
    List<MerchantPeople> list = new ArrayList<MerchantPeople>();
    list.add(mp);
    list.add(mp1);
    
    //String[] stringValues = (String[])list.get(0);
    
    ObjectMapper mapper = new ObjectMapper();
    String jsoninString = "";
    try
    {
      //Object to JSON in String
      jsoninString = mapper.writeValueAsString(foo);
      System.out.println(jsoninString);
      PGobject jsonObject = new PGobject();
      jsonObject.setType("json");
      jsonObject.setValue(jsoninString);
    }
    catch (IOException ex)
    {
      Logger.getLogger(MerchantPeopleController.class.getName()).log(Level.SEVERE, null, ex);
    }
    catch (SQLException ex)
    {
      Logger.getLogger(MerchantPeopleController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    //pstmt.setObject(11, jsonObject);
    //System.out.println(String.join(",", list)+"Test sumardi.");
    
    StoredProcedureQuery query = em.createStoredProcedureQuery("public.insert_merchant_people_beruntun");
    
    query.registerStoredProcedureParameter("merchant_people[]", MerchantPeople[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
    
    query.setParameter("merchant_people[]", foo);
    return query;
  }
}
