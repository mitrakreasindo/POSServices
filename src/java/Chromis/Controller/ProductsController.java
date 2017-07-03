/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Controller;

import Chromis.Entities.Products;
import Chromis.Utilities.GeneralFunction;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class ProductsController
{
  public static StoredProcedureQuery sp_create(EntityManager em, String kodeMerchant, Products entity)
  {
    String validator = "";
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant+".insert_product");
    // define the stored procedure
    query.registerStoredProcedureParameter("product_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_reference", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_code", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_codetype", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("price_buy", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("price_sell", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_category", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_category", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_attributeset_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_cost", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_volume", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_com", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_scale", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_kitchen", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("print_kb", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("send_status", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_service", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_display", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_attributes", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_vprice", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_verpatrib", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("text_tip", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_warranty", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_image", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_units", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_alias", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("always_available", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_discounted", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("can_discount", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_catalog", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("cat_order", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_pack", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("pack_quantity", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("pack_product", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("promotion_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("all_products", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("manage_stock", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("product_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("product_reference", GeneralFunction.checkNullString(entity.getReference()));
    query.setParameter("product_code", GeneralFunction.checkNullString(entity.getCode()));
    query.setParameter("product_codetype", GeneralFunction.checkNullString(entity.getCodetype()));
    query.setParameter("product_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("price_buy", entity.getPricebuy());
    query.setParameter("price_sell", entity.getPricesell());
    
    validator = "";
    if(entity.getCategory() != null) validator = entity.getCategory().getId();
    query.setParameter("product_category", validator);
    
    validator = "";
    if(entity.getTaxcat() != null) validator = entity.getTaxcat().getId();
    query.setParameter("tax_category", validator);
    
    validator = "";
    if(entity.getAttributesetId() != null) validator = entity.getAttributesetId().getId();
    query.setParameter("product_attributeset_id", validator);
    
    query.setParameter("stock_cost", entity.getStockcost());
    query.setParameter("stock_volume", entity.getStockvolume());
    query.setParameter("is_com", entity.getIscom());
    query.setParameter("is_scale", entity.getIsscale());
    query.setParameter("is_kitchen", entity.getIskitchen());
    query.setParameter("print_kb", entity.getPrintkb());
    query.setParameter("send_status", entity.getSendstatus());
    query.setParameter("is_service", entity.getIsservice());
    query.setParameter("product_display", entity.getDisplay());
    query.setParameter("product_attributes", GeneralFunction.checkNullByte(entity.getAttributes()));
    query.setParameter("is_vprice", entity.getIsvprice());
    query.setParameter("is_verpatrib", entity.getIsverpatrib());
    query.setParameter("text_tip", GeneralFunction.checkNullString(entity.getTexttip()));
    query.setParameter("product_warranty", entity.getWarranty());
    query.setParameter("product_image", GeneralFunction.checkNullByte(entity.getImage()));
    query.setParameter("stock_units", entity.getStockunits());
    query.setParameter("product_alias", GeneralFunction.checkNullString(entity.getAlias()));
    query.setParameter("always_available", entity.getAlwaysavailable());
    query.setParameter("product_discounted", GeneralFunction.checkNullString(entity.getDiscounted()));
    query.setParameter("can_discount", entity.getCandiscount());
    query.setParameter("is_catalog", entity.getIscatalog());
    query.setParameter("cat_order", entity.getCatorder());
    query.setParameter("is_pack", entity.getIspack());
    query.setParameter("pack_quantity", entity.getPackquantity());
    
    validator = "";
    if(entity.getPackproduct() != null) validator = entity.getPackproduct().getId();
    query.setParameter("pack_product", validator);
    
    validator = "";
    if(entity.getPromotionid() != null) validator = entity.getPromotionid().getId();
    query.setParameter("promotion_id", validator);
    query.setParameter("all_products", entity.getAllproducts());
    query.setParameter("manage_stock", entity.getManagestock());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_edit(EntityManager em, String kodeMerchant, Products entity)
  {
    String validator = "";
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant+".update_product");
    // define the stored procedure
    query.registerStoredProcedureParameter("product_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_reference", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_code", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_codetype", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_name", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("price_buy", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("price_sell", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_category", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("tax_category", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_attributeset_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_cost", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_volume", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_com", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_scale", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_kitchen", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("print_kb", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("send_status", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_service", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_display", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_attributes", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_vprice", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_verpatrib", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("text_tip", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_warranty", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_image", byte[].class, ParameterMode.IN);
    query.registerStoredProcedureParameter("stock_units", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_alias", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("always_available", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("product_discounted", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("can_discount", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_catalog", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("cat_order", Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("is_pack", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("pack_quantity", Double.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("pack_product", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("promotion_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("all_products", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("manage_stock", Boolean.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);

    query.setParameter("product_id", GeneralFunction.checkNullString(entity.getId()));
    query.setParameter("product_reference", GeneralFunction.checkNullString(entity.getReference()));
    query.setParameter("product_code", GeneralFunction.checkNullString(entity.getCode()));
    query.setParameter("product_codetype", GeneralFunction.checkNullString(entity.getCodetype()));
    query.setParameter("product_name", GeneralFunction.checkNullString(entity.getName()));
    query.setParameter("price_buy", entity.getPricebuy());
    query.setParameter("price_sell", entity.getPricesell());
    
   validator = "";
    if(entity.getCategory() != null) validator = entity.getCategory().getId();
    query.setParameter("product_category", validator);
    
    validator = "";
    if(entity.getTaxcat() != null) validator = entity.getTaxcat().getId();
    query.setParameter("tax_category", validator);
    
    validator = "";
    if(entity.getAttributesetId() != null) validator = entity.getAttributesetId().getId();
    query.setParameter("product_attributeset_id", validator);

    query.setParameter("stock_cost", entity.getStockcost());
    query.setParameter("stock_volume", entity.getStockvolume());
    query.setParameter("is_com", entity.getIscom());
    query.setParameter("is_scale", entity.getIsscale());
    query.setParameter("is_kitchen", entity.getIskitchen());
    query.setParameter("print_kb", entity.getPrintkb());
    query.setParameter("send_status", entity.getSendstatus());
    query.setParameter("is_service", entity.getIsservice());
    query.setParameter("product_display", entity.getDisplay());
    query.setParameter("product_attributes", GeneralFunction.checkNullByte(entity.getAttributes()));
    query.setParameter("is_vprice", entity.getIsvprice());
    query.setParameter("is_verpatrib", entity.getIsverpatrib());
    query.setParameter("text_tip", GeneralFunction.checkNullString(entity.getTexttip()));
    query.setParameter("product_warranty", entity.getWarranty());
    query.setParameter("product_image", GeneralFunction.checkNullByte(entity.getImage()));
    query.setParameter("stock_units", entity.getStockunits());
    query.setParameter("product_alias", GeneralFunction.checkNullString(entity.getAlias()));
    query.setParameter("always_available", entity.getAlwaysavailable());
    query.setParameter("product_discounted", GeneralFunction.checkNullString(entity.getDiscounted()));
    query.setParameter("can_discount", entity.getCandiscount());
    query.setParameter("is_catalog", entity.getIscatalog());
    query.setParameter("cat_order", entity.getCatorder());
    query.setParameter("is_pack", entity.getIspack());
    query.setParameter("pack_quantity", entity.getPackquantity());
    
    validator = "";
    if(entity.getPackproduct() != null) validator = entity.getPackproduct().getId();
    query.setParameter("pack_product", validator);
    
    validator = "";
    if(entity.getPromotionid() != null) validator = entity.getPromotionid().getId();
    query.setParameter("promotion_id", validator);
    
    query.setParameter("all_products", entity.getAllproducts());
    query.setParameter("manage_stock", entity.getManagestock());
    
    return query;
  }
  
  public static StoredProcedureQuery sp_remove(EntityManager em, String kodeMerchant, String id)
  {
    StoredProcedureQuery query = em.createStoredProcedureQuery(kodeMerchant+".delete_product");
    // define the stored procedure
    query.registerStoredProcedureParameter("product_id", String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter("retval", Integer.class, ParameterMode.OUT);
    query.registerStoredProcedureParameter("message", String.class, ParameterMode.OUT);
    
    query.setParameter("product_id", GeneralFunction.checkNullString(id));
    
    return query;
  }
  //Delete
//  IN product_id character varying,
//    OUT retval integer,
//    OUT message text)
}
