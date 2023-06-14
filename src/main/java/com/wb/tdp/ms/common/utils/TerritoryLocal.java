package com.wb.tdp.ms.common.utils;



import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/** This is class is used to hold all the country code and provide the localization support
 * to the application.
 * 
 * @author anangupt
 *
 */
public class TerritoryLocal {

	/**The constructor is private so that no class is able to create a object of this class.
	 * 
	 */
	private TerritoryLocal(){
		super();
	}
   /**
    * predefine country code for US.
    */
	public static final Long US= 1L; 
	
	  /**
	    * predefine country code for US EN..
	    */
    public static final Long EN_US= 2L; 
    
    /**This method hold the predefine country code and Local saved against it.
     * 
     */
    private static final Map<Long, Locale> locales = new HashMap<>();
    
    static {
        locales.put( EN_US, new Locale("en","US"));
        locales.put( US, new Locale("en","US"));
    }

    /**This is method is used to return the locale object when there is 
     * country code given as a input.
     * 
     * @param key - holds the input of country code
     * @return Locale - returning the Locale object 
     */
    public static Locale getLocal(Long key) {
    	return locales.get(key);
    }
  
}
