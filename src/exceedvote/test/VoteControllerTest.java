//package exceedvote.test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import exceedvote.controller.VoteController;
//
///**
// * This JUnit test for class Controller
// * @author Jaktip Yordsri
// * 
// */
//public class VoteControllerTest {
//
//	private VoteController controller;
//	
//	public VoteControllerTest(){
////		controller = new VoteController();
//	}
//	
//
//	
//	@Test
//	/**
//	 * test the method getQuestionType is work, and perfectly return the exact result
//	 */
//	public void testGetQuestionType(){
//		assert (!controller.getQuestionType(0).equals("exceedvote.voteprocess.ScoreType"));
//		assert (controller.getQuestionType(0).equals("exceedvote.voteprocess.BallotType"));
//		assert (controller.getQuestionType(1).equals("exceedvote.voteprocess.BallotType"));
//		assert (controller.getQuestionType(2).equals("exceedvote.voteprocess.BallotType"));
//		assert (controller.getQuestionType(3).equals("exceedvote.voteprocess.ScoreType"));
//		assert (controller.getQuestionType(4).equals("exceedvote.voteprocess.ScoreType"));
//		assert (controller.getQuestionType(5).equals("exceedvote.voteprocess.ScoreType"));		
//	}
//
//	@Test
//	/**
//	 * test the method login is work, and perfectly return the exact result
//	 */
//	public void testLogin(){
//		assert(controller.login("ID", "PASSWORD")==true);
//		assert(controller.login("RABBITKISS", "RABBITKISSPASSWORD")==true);
//	}
//	
//	
//	
//	
//}