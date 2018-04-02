import controller.MemberController;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.Member;
import repository.MemberRepository;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    MemberRepository repo;
    MemberController controller;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }


    public void test_tc_1_addMember() {
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("laura", 10, 500);
        assertTrue(controller.addMember(member));

        Member member2 = new Member("", 3, 400);
        assertFalse(controller.addMember(member2));

        Member member3 = new Member("andreea", -1, 200);
        assertFalse(controller.addMember(member3));

        Member member4 = new Member("andreea", 5, -100);
        assertFalse(controller.addMember(member4));

        assertFalse(controller.addMember(member));


    }


    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
