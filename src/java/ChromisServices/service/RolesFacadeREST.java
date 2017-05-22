/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Roles;
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
@Path("chromis.roles")
public class RolesFacadeREST extends AbstractFacade<Roles> {

    @PersistenceContext(unitName = "MKChromisServicesPU")
    private EntityManager em;

    public RolesFacadeREST() {
        super(Roles.class);
    }

    @POST
    //@Override
    //@Path("/Insert")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HashMap<Integer, String> create(Roles entity) {
        //super.create(entity);
        HashMap<Integer, String> result = new HashMap<Integer, String>();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("insert_role");
        // define the stored procedure
        query.registerStoredProcedureParameter("role_name", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("permission_lists", byte[].class, ParameterMode.IN);
        query.registerStoredProcedureParameter("rights_level", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
        
        query.setParameter("role_name", entity.getName());
        query.setParameter("permission_lists", entity.getPermissions());
        query.setParameter("rights_level", entity.getRightslevel());
        
        try
        {
            query.execute();   
            //Get output parameter value
            Integer key = (Integer) query.getOutputParameterValue("retval");
            String value = (String) query.getOutputParameterValue("message");
            result.put(key, value);
            
            return result;
        }
        catch(Exception ex){
            result.put(1, ex.getMessage());
            return result;
        }
    }

    @PUT
    //@Override
    //@Path("/Update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HashMap<Integer, String> edit(Roles entity) {
        //super.create(entity);
        HashMap<Integer, String> result = new HashMap<Integer, String>();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("update_role");
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
        
        try
        {
            query.execute();   
            //Get output parameter value
            Integer key = (Integer) query.getOutputParameterValue("retval");
            String value = (String) query.getOutputParameterValue("message");
            result.put(key, value);
            
            return result;
        }
        catch(Exception ex){
            result.put(1, ex.getMessage());
            return result;
        }
    }

    @DELETE
    //@Override
    //@Path("/Delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public HashMap<Integer, String> remove(Roles entity) {
        //super.create(entity);
        HashMap<Integer, String> result = new HashMap<Integer, String>();
        
        StoredProcedureQuery query = em.createStoredProcedureQuery("delete_role");
        // define the stored procedure
        query.registerStoredProcedureParameter("role_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
        
        query.setParameter("role_id", entity.getId());
        
        try
        {
            query.execute();   
            //Get output parameter value
            Integer key = (Integer) query.getOutputParameterValue("retval");
            String value = (String) query.getOutputParameterValue("message");
            result.put(key, value);
            
            return result;
        }
        catch(Exception ex){
            result.put(1, ex.getMessage());
            return result;
        }
    }
   
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Roles find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Roles> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
