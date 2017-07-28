/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.Result;
import Chromis.Entities.SalesPack;
import Chromis.Entities.Viewpayments;
import Chromis.Entities.Viewreceipts;
import Chromis.Entities.Viewsales;
import Chromis.Entities.Viewsalesitems;
import Chromis.Entities.Viewstockdiary;
import Chromis.Entities.Viewtaxlines;
import Chromis.Utilities.GeneralFunction;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Asun
 */
public class SalesController
{
//  public SalesPack testSales()
//  {
//    SalesPack pack = new SalesPack();
//    Viewreceipts receipts = new Viewreceipts();
//    Viewsales sales = new Viewsales();
//    Collection<Viewsalesitems> salesItems = new ArrayList<>();;
//    Collection<Viewpayments> payments = new ArrayList<>();;
//    Collection<Viewtaxlines> taxLines = new ArrayList<>();;
//    Collection<Viewstockdiary> stockDiary = new ArrayList<>();;
//    
//    //populate receipts
//    receipts.setId(UUID.randomUUID().toString());
//    //receipts.setSales(sales);
//    receipts.setAttributes(null);
//    receipts.setDatenew(GeneralFunction.date2String(new Date()));
//      //Closedcash money = new Closedcash("d3b7fc98-a824-4ce3-876f-597f11fe3d67");
//    receipts.setMoney("ea051560-2723-44a7-b165-47911b4bcd73");
//    receipts.setHost("");
//    receipts.setPerson("Test Pantek");
//    receipts.setSflag(Boolean.TRUE);
//    receipts.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    
//    //populate sales
//    sales.setId(receipts.getId());
//    sales.setCustomer(null);
//    sales.setPerson("0");
//    sales.setSalesnum(0);
//    sales.setDatenew(GeneralFunction.date2String(new Date()));
//    //sales.setReceipts(receipts.getId());
//    //sales.setSalesItemsCollection(null);
//    sales.setSalestype(0);
//    sales.setSflag(Boolean.TRUE);
//    sales.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    sales.setStatus(0);
//    
//    //Populate SalesItem
//    Viewsalesitems item = new Viewsalesitems();
//    item.setAttributes(null);
//    item.setAttributesetinstanceId(null);
//    item.setId(36);
//    item.setLine(1);
//    item.setPrice(1000.0);
//      //Products p = new Products("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    item.setProduct("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    item.setRefundqty(0.0);
//    item.setSalesId(sales.getId());
//    item.setSflag(Boolean.TRUE);
//    item.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//      //Taxes t = new Taxes("001");
//    item.setTaxid("001");
//    item.setUnits(2.0);
//    
//    salesItems.add(item);
//    
//    item = new Viewsalesitems();
//    item.setAttributes(null);
//    item.setAttributesetinstanceId(null);
//    item.setId(37);
//    item.setLine(2);
//    item.setPrice(1000.0);
//      //Products p = new Products("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    item.setProduct("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    item.setRefundqty(0.0);
//    item.setSalesId(sales.getId());
//    item.setSflag(Boolean.TRUE);
//    item.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//      //Taxes t = new Taxes("001");
//    item.setTaxid("001");
//    item.setUnits(2.0);
//    salesItems.add(item);
//    
//    //Populate payment
//    Viewpayments payment = new Viewpayments();
//    payment.setId(UUID.randomUUID().toString());
//    payment.setTendered(2000.0);
//    payment.setTotal(2000.0);
//    payment.setPayment("cash");
//    payment.setCardname("CardName");
//    payment.setNotes("Notes");
//    payment.setReceipt(receipts.getId());
//    payment.setReturnmsg(null);
//    payment.setSflag(Boolean.TRUE);
//    payment.setTransid("Random");
//    payment.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    payments.add(payment);
//    
//    //Populate Stockdiary
//    Viewstockdiary diary = new Viewstockdiary();
//    diary.setId(UUID.randomUUID().toString());
//    diary.setDatenew(GeneralFunction.date2String(new Date()));
//    diary.setPrice(1000.0);
//    diary.setReason(0);
//    diary.setUnits(1.0);
//    
//    diary.setAppuser("appuser");
//    diary.setAttributesetinstanceId(null);
//    diary.setLocation("0");
//    diary.setProduct("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    diary.setReason(0);
//    diary.setSflag(Boolean.TRUE);
//    diary.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    stockDiary.add(diary);
//    
//    diary = new Viewstockdiary();
//    diary.setId(UUID.randomUUID().toString());
//    diary.setDatenew(GeneralFunction.date2String(new Date()));
//    diary.setPrice(1000.0);
//    diary.setReason(0);
//    diary.setUnits(1.0);
//    diary.setAppuser("appuser");
//    diary.setAttributesetinstanceId(null);
//    diary.setLocation("0");
//    diary.setProduct("b8403cee-738c-471d-8bfe-b5cc2da1c691");
//    diary.setReason(0);
//    diary.setSflag(Boolean.TRUE);
//    diary.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    stockDiary.add(diary);
//    
//    Viewtaxlines tl = new Viewtaxlines();
//    tl.setId(UUID.randomUUID().toString());
//    tl.setBase(1000.0);
//    tl.setAmount(100.0);
//    tl.setReceipt(receipts.getId());
//    tl.setSflag(Boolean.TRUE);
//    tl.setTaxid("001");
//    tl.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    taxLines.add(tl);
//    
//    tl = new Viewtaxlines();
//    tl.setId(UUID.randomUUID().toString());
//    tl.setBase(1000.0);
//    tl.setAmount(100.0);
//    tl.setReceipt(receipts.getId());
//    tl.setSflag(Boolean.TRUE);
//    tl.setTaxid("001");
//    tl.setSiteguid("a73c83f2-3c42-42a7-8f19-7d7cbea17286");
//    taxLines.add(tl);
//    
//    
//    pack.setReceipts(receipts);
//    pack.setSales(sales);
//    pack.setPayments(payments);
//    pack.setSalesItems(salesItems);
//    pack.setStockdiary(stockDiary);
//    pack.setTaxlines(taxLines);
//
//    return pack;
//  }
  
  public HashMap<Integer, String> create(EntityManager em, String kodeMerchant, SalesPack entity)
  {
    HashMap<Integer, String> result = new HashMap<Integer, String>();
    
    String receiptsJson = GeneralFunction.convert2Json(entity.getReceipts());
    String salesJson = GeneralFunction.convert2Json(entity.getSales());
    String salesItemsJson = GeneralFunction.convert2Json(entity.getSalesItems());
    String stockDiaryJson = GeneralFunction.convert2Json(entity.getStockdiary());
    String paymentsJson = GeneralFunction.convert2Json(entity.getPayments());
    String taxlinesJson = GeneralFunction.convert2Json(entity.getTaxlines());
    
    //Use native query to execute sp with json input
    Query q = em.createNativeQuery("SELECT * FROM public.insert_sales_new"
            + "("
            + "'"+receiptsJson+"',"
            + "'"+salesJson+"',"
            + "'"+salesItemsJson+"',"
            + "'"+stockDiaryJson+"',"
            + "'"+paymentsJson+"',"
            + "'"+taxlinesJson+"'"
            + ")");
    
    try
    {
      //q.getSingleResult().getClass();
      Object[] obj = (Object[]) q.getSingleResult();
      
      
      //List obj = q.getResultList();
      System.out.println(obj[0]);
      System.out.println(obj[1]);
     
      
      result.put((Integer)obj[0], obj[1].toString());
      return result;
    }
    catch (Exception e)
    {
      result.put(1, "Transaksi sales gagal");
      return result;
    }
  }
}
