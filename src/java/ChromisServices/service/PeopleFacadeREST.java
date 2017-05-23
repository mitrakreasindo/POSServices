/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.People;
import Chromis.Roles;
import Utils.GeneralFunction;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Asun
 */
@Stateless
@Path("chromis.people")
public class PeopleFacadeREST extends AbstractFacade<People>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  public PeopleFacadeREST()
  {
    super(People.class);
  }

  @POST
  @Path("{kode}")
  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> create(People entity)
  {
    //super.create(entity);
    HashMap<Integer, String> result = new HashMap<Integer, String>();

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
    //query.setParameter("app_pass", entity.getApppassword());
    query.setParameter("card_no", GeneralFunction.checkNullString(entity.getCard()));
    query.setParameter("person_role", entity.getRole().getId());
    query.setParameter("visibility", entity.getVisible());
    query.setParameter("image_code", GeneralFunction.checkNullByte(entity.getImage()));

    try
    {
      query.setParameter("app_pass", GeneralFunction.encryptPassword(entity.getApppassword()));
      query.execute();
      //Get output parameter value
      Integer key = (Integer) query.getOutputParameterValue("retval");
      String value = (String) query.getOutputParameterValue("message");
      result.put(key, value);

      return result;
    }
    catch (Exception ex)
    {
      System.out.print("Flag asun" + ex.getStackTrace());
      result.put(1, ex.getStackTrace().toString());
      return result;
    }
  }

  @PUT
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> edit(People entity)
  {
    //super.create(entity);
    HashMap<Integer, String> result = new HashMap<Integer, String>();

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

    try
    {
      query.setParameter("app_pass", GeneralFunction.encryptPassword(entity.getApppassword()));
      query.execute();
      //Get output parameter value
      Integer key = (Integer) query.getOutputParameterValue("retval");
      String value = (String) query.getOutputParameterValue("message");
      result.put(key, value);

      return result;
    }
    catch (Exception ex)
    {
      result.put(1, ex.getMessage());
      return result;
    }
  }

  @DELETE
  @Path("{kode}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public HashMap<Integer, String> remove(String inputID)
  {
    //super.create(entity);
    HashMap<Integer, String> result = new HashMap<Integer, String>();

    StoredProcedureQuery query = em.createStoredProcedureQuery("delete_user");
    // define the stored procedure
    query.registerStoredProcedureParameter("person_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("person_id", inputID);

    try
    {
      query.execute();
      //Get output parameter value
      Integer key = (Integer) query.getOutputParameterValue("retval");
      String value = (String) query.getOutputParameterValue("message");
      result.put(key, value);

      return result;
    }
    catch (Exception ex)
    {
      result.put(1, ex.getMessage());
      return result;
    }
  }

//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public People find(@PathParam("id") String id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<People> findAll() {
//        List<People> p = super.findAll();
//        
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<People> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }

}
