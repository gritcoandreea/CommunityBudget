import controller.MemberController;
import model.Entry;
import model.Member;
import org.junit.Assert;
import org.junit.Test;
import repository.MemberRepository;

public class CoverageTest {
    MemberRepository repo;
    MemberController controller;


    @Test()
    public void test_tc_1_addMEntry(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Entry entry = new Entry("nothing",500,-1);
        Assert.assertFalse(controller.addEntry(entry));
    }

    @Test()
    public void test_tc_2_addMEntry(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Entry entry = new Entry("income",300,3);

        controller.addEntry(entry);
        Assert.assertFalse(controller.addEntry(entry));
        
    }

}
