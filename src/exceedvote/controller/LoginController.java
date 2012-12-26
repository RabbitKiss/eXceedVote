package exceedvote.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import exceedvote.dao.ConcreteDaoFactory;
import exceedvote.dao.ConcreteUserDAO;
import exceedvote.domain.User;

public class LoginController {
	private InetAddress addr;
	private static Logger log = Logger.getLogger( LoginController.class );
	public User verify(String id, String pass)
	{
		ConcreteUserDAO userDAO = (ConcreteUserDAO) ConcreteDaoFactory.getInstance().createDAO("userDAO");
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
        String ipAddress = addr.getHostAddress();   
        
        if(userDAO.find(id, pass)==null)
        {
        	log.warn("Login failed!! IP : "+ipAddress);
        }
        else if(userDAO.find(id, pass).getUserType().equals("student"))
        {
        	log.info("ID:"+id+",Level:Student,LOGIN-IP:"+ipAddress);
        }
        else if(userDAO.find(id, pass).getUserType().equals("committee"))
        {
        	log.info("ID:"+id+",Level:Committee,LOGIN-IP:"+ipAddress);
        }
        //System.out.println("IP address of localhost from Java Program: " + ipAddress);

	
		return userDAO.find(id, pass);
	}
}
