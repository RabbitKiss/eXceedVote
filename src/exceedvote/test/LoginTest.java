package exceedvote.test;

import exceedvote.domain.Login;
import junit.framework.TestCase;

public class LoginTest extends TestCase {
	Login log = new Login();

	public void testGetId() {
		assertEquals(log.id, Login.getId());
	}

	public void testVerify() {
		assertEquals(true, log.verify("ADMIN", "TESTEST"));
	}
	
	public void testVerifyF1() {
		assertEquals(false, log.verify("ADMIN", null));
	}
	public void testVerifyF2() {
		assertEquals(false, log.verify(null, "TESTESETES"));
	}
	public void testVerifyF3() {
		assertEquals(false, log.verify(null, null));
	}

}
