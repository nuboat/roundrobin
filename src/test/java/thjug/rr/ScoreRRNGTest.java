package thjug.rr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;

public class ScoreRRNGTest {

    @Test
    public void testGetCase1() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new ScoreRR(list);
        rr.get().get().fail();
        rr.get().get().fail();
        rr.get().get().fail();
        final Route<String> r1 = rr.get().get();
        final Route<String> r2 = rr.get().get();

        assert r1 == r2;
    }

    @Test
    public void testGetCase2() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new ScoreRR(list);
        rr.get().get().fail();
        rr.get().get().fail();
        rr.get().get().fail();
        rr.get().get().fail();
        final Option<Route<String>> opt = rr.get();

        assert opt.isPresent() == true;
    }

    @Test
    public void testGetCase3() {
        final RR<String> rr = new ScoreRR(Arrays.asList("1", "2"));
        final Route<String> r1 = rr.get().get();
        r1.fail();

        assert rr.get().get().equals(r1) == false;
    }

    @Test
    public void testGetCase4() {
        final RR<String> rr = new ScoreRR(Collections.EMPTY_LIST);
        final Option<Route<String>> opt = rr.get();

        assert opt.isEmpty() == true;
    }
    
    @Test
    public void testGetCase5() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new ScoreRR(list);
        final Route<String> r1 = rr.get().get();
        r1.fail();
        final Route<String> r2 = rr.get().get();
        r2.fail();
        final Route<String> r = rr.get().get();

        assert (r != r1) && (r != r2);
    }

}
