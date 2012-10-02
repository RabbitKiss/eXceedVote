package exceedvote.voteprocess;
import java.io.Console;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class Login
{
	private static Logger log = Logger.getLogger( Login.class );
    private static String id;

    /**
     * Constructor for objects of class Login
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
    public boolean login(String id,String password)
    {
    	return true;
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
     */
    public boolean verify(String id , String password)
    {		
    		
            Login.id = id;
            log.fatal("ID : " + id );
            return true;
    }
}
