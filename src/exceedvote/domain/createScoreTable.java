package exceedvote.domain;

import exceedvote.controller.CommitteeController;
import exceedvote.dao.ConcreteScoreDAO;

public class createScoreTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		CommitteeController cc = new CommitteeController();
		cc.addScoreTable();
	}

}
