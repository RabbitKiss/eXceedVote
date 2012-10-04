package exceedvote.voteprocess;

import static org.junit.Assert.*;

import org.junit.Test;

public class BallotTypeTest {

	private BallotType bt;
	@Test
	public void testBallotTypeStringInt() {
		bt = new BallotType("question 1",0);
	}

	@Test
	public void testGetInstruction() {
		assert (bt.getInstruction().equals("question 1"));
		bt = new BallotType("",0);
		assert (bt.getInstruction().equals(""));
	}

}
