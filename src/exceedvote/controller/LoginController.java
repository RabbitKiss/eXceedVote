package exceedvote.controller;

import exceedvote.dao.ConcreteDaoFactory;
import exceedvote.dao.ConcreteUserDAO;
import exceedvote.domain.User;

public class LoginController {
	
	public User verify(String id, String pass)
	{
		ConcreteUserDAO userDAO = (ConcreteUserDAO) ConcreteDaoFactory.getInstance().createDAO("userDAO");
		return userDAO.find(id, pass);
	}
}
