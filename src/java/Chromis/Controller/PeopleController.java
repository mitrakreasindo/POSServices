/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.People;
import Chromis.Utilities.GeneralFunction;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class PeopleController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, People entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".insert_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("email_addr", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("card_no", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_role", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("visibility", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("image_code", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("person_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("card_no", GeneralFunction.checkNullString(entity.getCard()));
    query.setParameter("email_addr", GeneralFunction.checkNullString(entity.getEmail()));
    query.setParameter("person_role", entity.getRole().getId());
    query.setParameter("visibility", entity.getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entity.getImage()));
    
    try
    {
      query.setParameter("app_pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(entity.getApppassword())));
    }
    catch (Exception e)
    {
      //return 
    }
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, People entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".update_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("email_addr", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("card_no", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_role", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("visibility", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("image_code", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("person_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("card_no", GeneralFunction.checkNullString(entity.getCard()));
    query.setParameter("person_role", GeneralFunction.checkNullString(entity.getRole().getId()));
    query.setParameter("visibility", entity.getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entity.getImage()));
    query.setParameter("email_addr", GeneralFunction.checkNullString(entity.getEmail()));
    
    try
    {
      if(entity.getApppassword() == "" || entity.getApppassword() == null){
        query.setParameter("app_pass", "");
      }
      else{
        query.setParameter("app_pass", GeneralFunction.encryptPassword(entity.getApppassword()));
      }
    }
    catch (Exception e)
    {
      //return 
    }
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, String id)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".delete_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", GeneralFunction.checkNullString(id));
    return query;
  }
  
  public static StoredProcedureQuery sp_login(EntityManager em, String kodeMerchant, String username, String password)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery("public.login");
    // define the stored procedure
    query.registerStoredProcedureParameter("merchant_code", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_user_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("merchant_code", GeneralFunction.checkNullString(kodeMerchant));
    query.setParameter("merchant_user_name", GeneralFunction.checkNullString(username));
    
    try
    {
      query.setParameter("pass", GeneralFunction.checkNullString(GeneralFunction.encryptPassword(password)));
    }
    catch (Exception e)
    {
      //return
    }
    return query;
  }
}
