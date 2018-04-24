import controller.MemberController;
import repository.MemberRepository;
import model.Entry;
import model.Member;
import org.junit.Assert;
import org.junit.Test;


public class IntegrationTest {

    MemberRepository repo;
    MemberController controller;


    public void test_tc_1_getAllEntriesForUser(){
        repo = new MemberRepository();
        controller = new MemberController(repo);
//        repo.clearEntries();
//
//        Member member = new Member("andreea",5,100);
//        controller.addMember(member);
//
//        Entry  entry =  new Entry("income", 1,5);
//        controller.addEntry(entry);

        Assert.assertEquals(controller.allEntriesForUser(5).size(),1);
    }




    public void test_tc_1_addEntry(){
        repo = new MemberRepository();
        controller = new MemberController(repo);
        repo.clearEntries();
        Entry  entry =  new Entry("income", 1,5);
        Assert.assertTrue(controller.addEntry(entry));

    }


    public void test_tc_1_addMember(){
        repo = new MemberRepository();
        controller = new MemberController(repo);
        repo.clearMembers();

        Member member = new Member("andreea",5,100);
        Assert.assertTrue(controller.addMember(member));
    }


    @Test
    public void test_tc_1_testAll(){

        test_tc_1_addMember();
        test_tc_1_addEntry();
        test_tc_1_getAllEntriesForUser();

    }


}
