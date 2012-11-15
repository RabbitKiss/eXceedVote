package exceedvote.domain;
import java.io.Console;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;

import exceedvote.jdbc.JDBCTest;


public class Login
{
	private static Logger log = Logger.getLogger( Login.class );
    public static String id=null;

    /**
     * Null constructor
     */
    public Login()
    {
    
    }

    
     /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static String getId()
    {
        return id;
    }
    
     /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     * @throws SQLException 
     */
    public boolean verify(String id , String password)
    {		
    	try{
    		return JDBCTest.verify(id, password);
    	}
    	catch(Exception e){
    		return false;
    	}
//    		if(password!=null && id!=null&&password!=" " && id!=" ")
//    		{
//    			Login.id = id;
//    			log.fatal("ID : " + id );
//    		return true;
//    		}
//    		else
//    		{
//    			log.fatal("ID : " + id + " : invalid input password" );
//    		return false;
//		}
	}
}
