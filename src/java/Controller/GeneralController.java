/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.HashMap;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Asun
 */
public class GeneralController
{
  public static HashMap<Integer, String> executeSP(StoredProcedureQuery query)
  {
    HashMap<Integer, String> result = new HashMap<Integer, String>();
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
}
