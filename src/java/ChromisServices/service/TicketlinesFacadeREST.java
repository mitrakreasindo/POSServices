/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import Chromis.Entities.Ticketlines;
import Chromis.Entities.TicketlinesPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Asun
 */
@Stateless
@Path("chromis.entities.ticketlines")
public class TicketlinesFacadeREST extends AbstractFacade<Ticketlines>
{

  @PersistenceContext(unitName = "MKChromisServicesPU")
  private EntityManager em;

  private TicketlinesPK getPrimaryKey(PathSegment pathSegment)
  {
    /*
     * pathSemgent represents a URI path segment and any associated matrix parameters.
     * URI path part is supposed to be in form of 'somePath;ticket=ticketValue;line=lineValue'.
     * Here 'somePath' is a result of getPath() method invocation and
     * it is ignored in the following code.
     * Matrix parameters are used as field names to build a primary key instance.
     */
    Chromis.Entities.TicketlinesPK key = new Chromis.Entities.TicketlinesPK();
    javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
    java.util.List<String> ticket = map.get("ticket");
    if (ticket != null && !ticket.isEmpty())
    {
      key.setTicket(ticket.get(0));
    }
    java.util.List<String> line = map.get("line");
    if (line != null && !line.isEmpty())
    {
      key.setLine(new java.lang.Integer(line.get(0)));
    }
    return key;
  }

  public TicketlinesFacadeREST()
  {
    super(Ticketlines.class);
  }

//  @POST
//  @Override
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void create(Ticketlines entity)
//  {
//    super.create(entity);
//  }
//
//  @PUT
//  @Path("{id}")
//  @Consumes(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public void edit(@PathParam("id") PathSegment id, Ticketlines entity)
//  {
//    super.edit(entity);
//  }
//
//  @DELETE
//  @Path("{id}")
//  public void remove(@PathParam("id") PathSegment id)
//  {
//    Chromis.Entities.TicketlinesPK key = getPrimaryKey(id);
//    super.remove(super.find(key));
//  }
//
//  @GET
//  @Path("{id}")
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public Ticketlines find(@PathParam("id") PathSegment id)
//  {
//    Chromis.Entities.TicketlinesPK key = getPrimaryKey(id);
//    return super.find(key);
//  }
//
//  @GET
//  @Override
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public List<Ticketlines> findAll()
//  {
//    return super.findAll();
//  }
//
//  @GET
//  @Path("{from}/{to}")
//  @Produces(
//  {
//    MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
//  })
//  public List<Ticketlines> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
//  {
//    return super.findRange(new int[]{from, to});
//  }
//
//  @GET
//  @Path("count")
//  @Produces(MediaType.TEXT_PLAIN)
//  public String countREST()
//  {
//    return String.valueOf(super.count());
//  }

  @Override
  protected EntityManager getEntityManager()
  {
    return em;
  }
  
}
