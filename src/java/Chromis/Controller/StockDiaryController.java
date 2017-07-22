/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.Stockdiary;
import Chromis.Utilities.GeneralFunction;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class StockDiaryController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, Stockdiary entity)
  {
    String validator = "";
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".insert_stockdiary");
    // define the stored procedure
    query.registerStoredProcedureParameter("stockdiary_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("date_new", Date.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("diary_reason", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_location", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("attribute_set_instance_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_units", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("price", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_user", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("stockdiary_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("date_new", GeneralFunction.checkNullDate(entity.getDatenew()));
    query.setParameter("diary_reason", entity.getReason());
    
    validator = "";
    if(entity.getLocation() != null) validator = entity.getLocation().getId();
    query.setParameter("product_location", GeneralFunction.checkNullString(validator));
    
    validator = "";
    if(entity.getProduct()!= null) validator = entity.getProduct().getId();
    query.setParameter("product_id", GeneralFunction.checkNullString(validator));
    
    validator = "";
    if(entity.getAttributesetinstanceId() != null) validator = entity.getAttributesetinstanceId().getId();
    query.setParameter("attribute_set_instance_id", GeneralFunction.checkNullString(validator));
    
    query.setParameter("product_units", entity.getUnits());
    query.setParameter("price", entity.getPrice());
    query.setParameter("app_user", GeneralFunction.checkNullString(entity.getAppuser()));
    
    return query;
  }
}
