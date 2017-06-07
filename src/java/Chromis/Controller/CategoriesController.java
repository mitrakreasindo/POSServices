/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.Categories;
import Chromis.Utilities.GeneralFunction;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class CategoriesController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, Categories entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".insert_category");
    // define the stored procedure
    query.registerStoredProcedureParameter("category_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("parent_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("text_tip", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_showname", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_image", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_colour", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_order", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("category_name", GeneralFunction.checkNullString(entity.getName()));
    if(entity.getParentid() != null)
    {
      query.setParameter("parent_id", GeneralFunction.checkNullString(entity.getParentid().getId()));
    }
    else{
      query.setParameter("parent_id", "");
    }
    
    query.setParameter("text_tip", GeneralFunction.checkNullString(entity.getTexttip()));
    query.setParameter("category_showname", entity.getCatshowname());
    query.setParameter("category_image", GeneralFunction.checkNullByte(entity.getImage()));
    query.setParameter("category_colour", GeneralFunction.checkNullString(entity.getColour()));
    query.setParameter("category_order", entity.getCatorder());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, Categories entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".update_category");
    // define the stored procedure
    query.registerStoredProcedureParameter("category_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("parent_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("text_tip", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_showname", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_image", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_colour", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("category_order", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("category_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("category_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("parent_id", GeneralFunction.checkNullString(entity.getParentid().getId()));
    query.setParameter("text_tip", GeneralFunction.checkNullString(entity.getTexttip()));
    query.setParameter("category_showname", entity.getCatshowname());
    query.setParameter("category_image", GeneralFunction.checkNullByte(entity.getImage()));
    query.setParameter("category_colour", GeneralFunction.checkNullString(entity.getColour()));
    query.setParameter("category_order", entity.getCatorder());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, String id)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".delete_category");
    // define the stored procedure
    query.registerStoredProcedureParameter("category_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("category_id", GeneralFunction.checkNullString(id));
    return query;
  }
}
