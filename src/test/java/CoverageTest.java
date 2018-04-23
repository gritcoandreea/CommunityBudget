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

    @Test()
    public void test_tc_3_addEntry(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        Entry entry = new Entry("income", 400, 1);
        Entry entry2 = new Entry("cost",300, 4);

        controller.addEntry(entry);
        Assert.assertTrue(controller.addEntry(entry2));

    }

    @Test()
    public void test_tc_4_addEntry(){
        repo = new MemberRepository();
        controller = new MemberController(repo);

        repo.clearEntries();

        Entry entry = new Entry("income",400,3);

        Assert.assertTrue(controller.addEntry(entry));

    }



}
