/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory.user;

// Le costanti utilizzate nel codice
import static Util.Constant.*;


/**
 *
 * @author fab
 */
public class UserFactoryBuilder 
{
    public static UserFactory getFactory(String appMode)
    {
        if(appMode==null || appMode.equals(""))
            return null;
        
        if(appMode.equals(TEST_FACTORY_MODE))
            return TestUserFactory.getInstance();
        else if(appMode.equals(DB_FACTORY_MODE))
                return DbUserFactory.getInstance();
        else return null;
        
    }
    
}
