/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Asun
 */
public class SalesPack implements Serializable
{
  Viewsales sales;
  Viewreceipts receipts;
  Collection<Viewsalesitems> salesItems;
  Collection<Viewpayments> payments;
  Collection<Viewstockdiary> stockdiary;
  Collection<Viewtaxlines> taxlines;

  public Viewsales getSales()
  {
    return sales;
  }

  public void setSales(Viewsales sales)
  {
    this.sales = sales;
  }

  public Viewreceipts getReceipts()
  {
    return receipts;
  }

  public void setReceipts(Viewreceipts receipts)
  {
    this.receipts = receipts;
  }

  public Collection<Viewsalesitems> getSalesItems()
  {
    return salesItems;
  }

  public void setSalesItems(Collection<Viewsalesitems> salesItems)
  {
    this.salesItems = salesItems;
  }

  public Collection<Viewpayments> getPayments()
  {
    return payments;
  }

  public void setPayments(Collection<Viewpayments> payments)
  {
    this.payments = payments;
  }

  public Collection<Viewstockdiary> getStockdiary()
  {
    return stockdiary;
  }

  public void setStockdiary(Collection<Viewstockdiary> stockdiary)
  {
    this.stockdiary = stockdiary;
  }

  public Collection<Viewtaxlines> getTaxlines()
  {
    return taxlines;
  }

  public void setTaxlines(Collection<Viewtaxlines> taxlines)
  {
    this.taxlines = taxlines;
  }

  
  
  
}
