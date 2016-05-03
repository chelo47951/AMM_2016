/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author fab
 */
public class Util 
{
 public static Integer tryParseInt(String text) {
  try
  {
    return Integer.parseInt(text);
  }
  catch (NumberFormatException e)
  {
    return null;
  }
}
 
 public static Double tryParseDouble(String text) {
  try
  {
    return Double.parseDouble(text);
  }
  catch (NumberFormatException e)
  {
    return null;
  }
}
    
}
