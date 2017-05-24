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
    StoredProcedureQuery query = em.createStoredProcedureQuery("insert_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("card_no", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_role", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("visibility", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("image_code", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_name", entity.getName());
    query.setParameter("card_no", GeneralFunction.checkNullString(entity.getCard()));
    query.setParameter("person_role", entity.getRole().getId());
    query.setParameter("visibility", entity.getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entity.getImage()));
    
    try
    {
      query.setParameter("app_pass", GeneralFunction.encryptPassword(entity.getApppassword()));
    }
    catch (Exception e)
    {
      //return 
    }
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, People entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery("update_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("card_no", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_role", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("visibility", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("image_code", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", entity.getName());
    query.setParameter("person_name", entity.getName());
    query.setParameter("card_no", GeneralFunction.checkNullString(entity.getCard()));
    query.setParameter("person_role", entity.getRole().getId());
    query.setParameter("visibility", entity.getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entity.getImage()));
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, People entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery("delete_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", entity.getId());
    return query;
  }
}
