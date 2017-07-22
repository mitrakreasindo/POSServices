/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChromisServices.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Asun
 */
public abstract class AbstractFacade<T>
{

  private Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass)
  {
    this.entityClass = entityClass;
  }

  protected abstract EntityManager getEntityManager();

  protected EntityManager getEntityManager(String schema)
  {
    EntityManager em = null;
    EntityManagerFactory emf = null;
    Map properties = new HashMap();
    properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
    properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://192.168.1.40:5432/chromispos?currentSchema=" + schema);
    properties.put("javax.persistence.jdbc.user", "chromispos");
    properties.put("javax.persistence.jdbc.password", "chromispos");
    try
    {
      emf = Persistence.createEntityManagerFactory("dynamicJPA", properties);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return em = (EntityManager) emf.createEntityManager();
  }
  
  public T find(String kodeMerchant, String id)
  {
    try
    {
      Query q = getEntityManager().createNativeQuery("SELECT * FROM " + kodeMerchant + "." + entityClass.getSimpleName() + " where id = '" + id + "' and sflag = true", entityClass);
      return (T) q.getSingleResult();
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public List<T> findAll(String kodeMerchant)
  {
    try
    {
      Query q = getEntityManager().createNativeQuery("SELECT * FROM " + kodeMerchant + "." + entityClass.getSimpleName() + " where sflag = true", entityClass);
      return q.getResultList();
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public int count(String kodeMerchant)
  {
    try
    {
      Query q = getEntityManager().createNativeQuery("SELECT count(id) FROM " + kodeMerchant + "."+entityClass.getSimpleName() + " where sflag = true");
      BigInteger result = (BigInteger)q.getSingleResult();
      return result.intValue();
    }
    catch (Exception e)
    {
      return 0;
    }
  }

  //    public void create(T entity) {
//        getEntityManager().persist(entity);
//    }
//
//    public void edit(T entity) {
//        getEntityManager().merge(entity);
//    }
//
//    public void remove(T entity) {
//        getEntityManager().remove(getEntityManager().merge(entity));
//    }
//  public List<T> findRange(int[] range)
//  {
//    javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//    cq.select(cq.from(entityClass));
//    javax.persistence.Query q = getEntityManager().createQuery(cq);
//    q.setMaxResults(range[1] - range[0] + 1);
//    q.setFirstResult(range[0]);
//    return q.getResultList();
//  }
}
