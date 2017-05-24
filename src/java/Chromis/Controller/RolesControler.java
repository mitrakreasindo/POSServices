/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import Chromis.Entities.Roles;

/**
 *
 * @author Asun
 */
public class RolesControler
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, Roles entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".insert_role");
    // define the stored procedure
    query.registerStoredProcedureParameter("role_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("permission_lists", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("rights_level", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("role_name", entity.getName());
    query.setParameter("permission_lists", entity.getPermissions());
    query.setParameter("rights_level", entity.getRightslevel());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, Roles entity)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".update_role");
    // define the stored procedure
    query.registerStoredProcedureParameter("role_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("role_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("permission_lists", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("rights_level", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("role_id", entity.getId());
    query.setParameter("role_name", entity.getName());
    query.setParameter("permission_lists", entity.getPermissions());
    query.setParameter("rights_level", entity.getRightslevel());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, String id)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant + ".delete_role");
    // define the stored procedure
    query.registerStoredProcedureParameter("role_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("role_id", id);
    return query;
  }
}
