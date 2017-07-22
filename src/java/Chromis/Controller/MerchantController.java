/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.MerchantRegistration;
import Chromis.Entities.Merchants;
import Chromis.Entities.People;
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
public class MerchantController
{
  public static StoredProcedureQuery sp_create(EntityManager em, MerchantRegistration entities)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery("public.insert_merchant");
    // define the stored procedure
    query.registerStoredProcedureParameter("merchant_code", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_email", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_phone", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_address", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("the_type", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("merchant_npwp", String.class, ParameterMode.IN);
    
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("app_pass", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_full_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_gender", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_birthdate", Date.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_id_type", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_id_number", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("person_npwp", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("card_no", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("visibility", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("image_code", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
    //query.registerStoredProcedureParameter("person_role", String.class, ParameterMode.IN);
    //query.registerStoredProcedureParameter("email_addr", String.class, ParameterMode.IN);
    //query.registerStoredProcedureParameter("phone_num", String.class, ParameterMode.IN);
    
   //Mapping
    query.setParameter("merchant_code", GeneralFunction.checkNullString(entities.getMerchant().getCode()));
    query.setParameter("merchant_name", GeneralFunction.checkNullString(entities.getMerchant().getName()));
    query.setParameter("merchant_email", GeneralFunction.checkNullString(entities.getMerchant().getEmail()));
    query.setParameter("merchant_phone", GeneralFunction.checkNullString(entities.getMerchant().getPhone()));
    query.setParameter("merchant_address", GeneralFunction.checkNullString(entities.getMerchant().getAddress()));
    query.setParameter("the_type", entities.getMerchant().getCategory().getId());
    query.setParameter("merchant_npwp", GeneralFunction.checkNullString(entities.getMerchant().getNpwpperusahaan()));
    
    query.setParameter("person_id", GeneralFunction.checkNullString(entities.getPeople().getId()));
    query.setParameter("person_name", GeneralFunction.checkNullString(entities.getPeople().getName()));
    query.setParameter("person_full_name", GeneralFunction.checkNullString(entities.getPeople().getFullname()));
    query.setParameter("person_gender", GeneralFunction.checkNullString(entities.getPeople().getGender()));
    query.setParameter("person_birthdate", entities.getPeople().getBirthdate());
    query.setParameter("person_id_type", GeneralFunction.checkNullString(entities.getPeople().getPersonalIdType()));
    query.setParameter("person_id_number", GeneralFunction.checkNullString(entities.getPeople().getPersonalId()));
    query.setParameter("person_npwp", GeneralFunction.checkNullString(entities.getPeople().getNpwpPribadi()));
    query.setParameter("card_no", GeneralFunction.checkNullString(entities.getPeople().getCard()));
    query.setParameter("visibility", entities.getPeople().getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entities.getPeople().getImage()));
    //query.setParameter("phone_num", GeneralFunction.checkNullString(entities.getPeople().getPhoneNumber()));
    //query.setParameter("email_addr", GeneralFunction.checkNullString(entities.getPeople().getEmail()));
    //query.setParameter("person_role", people.getRole().getId());
    
    try
    {
      query.setParameter("app_pass", GeneralFunction.encryptPassword(GeneralFunction.checkNullString(entities.getPeople().getApppassword())));
    }
    catch (Exception e)
    {
      //return 
    }
    
    return query;
  }
}
