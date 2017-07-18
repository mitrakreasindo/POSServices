/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.Taxes;
import Chromis.Utilities.GeneralFunction;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class TaxesController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, Taxes entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".insert_taxes_and_taxcategories");
    // define the stored procedure
    query.registerStoredProcedureParameter("tax_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("taxcat_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_rate", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("tax_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("tax_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("taxcat_id", GeneralFunction.checkNullString(entity.getCategory().getId()));
    query.setParameter("tax_rate", entity.getRate());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, Taxes entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".update_taxes_and_taxcategories");
    query.registerStoredProcedureParameter("tax_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("taxcat_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_rate", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("tax_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("tax_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("taxcat_id", GeneralFunction.checkNullString(entity.getCategory().getId()));
    query.setParameter("tax_rate", entity.getRate());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, String id)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".delete_taxes_and_taxcategories");
    query.registerStoredProcedureParameter("tax_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("tax_id", GeneralFunction.checkNullString(id));
    return query;
  }
}
