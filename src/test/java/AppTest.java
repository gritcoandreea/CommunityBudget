import controller.MemberController;

import model.Member;
import org.junit.Assert;
import org.junit.Test;
import repository.MemberRepository;

/**
 * Unit test for simple App.
 */
public class AppTest {

    MemberRepository repo;
    MemberController controller;

    @Test
    public void test_tc_1_addMember() {
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, 35);
        Assert.assertTrue(controller.addMember(member));

//        Member member2 = new Member("", 3, 400);
////        assertFalse(controller.addMember(member2));
////
////        Member member3 = new Member("andreea", -1, 200);
////        assertFalse(controller.addMember(member3));
////
////        Member member4 = new Member("andreea", 5, -100);
////        assertFalse(controller.addMember(member4));
////
////        assertFalse(controller.addMember(member));


    }
    @Test(expected = NullPointerException.class)
    public void test_tc_2_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member(null, null, 35);
        controller.addMember(member);
    }
    @Test
    public void test_tc_3_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("a3er", -1, -5);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_4_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", Integer.MAX_VALUE + 1, 35);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_5_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, Integer.MAX_VALUE + 1);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_6_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 1, 35);
        Assert.assertTrue(controller.addMember(member));
    }


    @Test
    public void test_tc_7_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", Integer.MAX_VALUE, 35);
        Assert.assertTrue(controller.addMember(member));
    }

    @Test
    public void test_tc_8_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 0, 35);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_9_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 2, 35);
        Assert.assertTrue(controller.addMember(member));
    }

    @Test
    public void test_tc_10_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", Integer.MAX_VALUE - 1, 35);
        Assert.assertTrue(controller.addMember(member));
    }


    @Test
    public void test_tc_11_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("and1", Integer.MAX_VALUE - 1, 35);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_12_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("a nd", Integer.MAX_VALUE - 1, 35);
        Assert.assertFalse(controller.addMember(member));
    }


    @Test
    public void test_tc_13_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("", Integer.MAX_VALUE - 1, 35);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_14_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, 1);
        Assert.assertTrue(controller.addMember(member));
    }

    @Test
    public void test_tc_15_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, Integer.MAX_VALUE);
        Assert.assertTrue(controller.addMember(member));
    }

    @Test
    public void test_tc_16_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, 0);
        Assert.assertFalse(controller.addMember(member));
    }

    @Test
    public void test_tc_17_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, 2);
        Assert.assertTrue(controller.addMember(member));
    }

    @Test
    public void test_tc_18_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Member member = new Member("andreea", 5, Integer.MAX_VALUE -1);
        Assert.assertTrue(controller.addMember(member));
    }





//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite() {
//        return new TestSuite(AppTest.class);
//    }

//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp() {
//        assertTrue(true);
//    }
}
