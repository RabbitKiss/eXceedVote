package exceedvote.test;
import exceedvote.domain.ScoreType;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ScoreTypeTest {
    
    public ScoreTypeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getQuestion method, of class ScoreType.
     */
    @Test
    public void testGetInstruction() {
        System.out.println("getQuestion");
        ScoreType instance = new ScoreType(3,"Test");
        String expResult = "Test";
        String result = instance.getInstruction();
        assertEquals(expResult, result);
        instance = new ScoreType(1,"This is the question");
        expResult = "This is the question";
        assertEquals(expResult, instance.getInstruction());
        expResult = "false";
        assert(!(expResult.equals(instance.getInstruction())));
        // TODO review the generated test code and remove the default call to fail.
        //instance = new ScoreType("test");
        
    }


}
