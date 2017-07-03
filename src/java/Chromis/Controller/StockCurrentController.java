/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.StockCurrent;
import Chromis.Utilities.GeneralFunction;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class StockCurrentController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, StockCurrent entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".update_stockcurrent");
    // define the stored procedure
    query.registerStoredProcedureParameter("product_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_location", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("attributeset_instance_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_units", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("product_id", GeneralFunction.checkNullString(entity.getProduct()));
    query.setParameter("product_location", GeneralFunction.checkNullString(entity.getLocation()));
    query.setParameter("attributeset_instance_id", GeneralFunction.checkNullString(entity.getAttributesetinstance_id()));
    query.setParameter("product_units", entity.getUnits());
    
    return query;
  }
}
