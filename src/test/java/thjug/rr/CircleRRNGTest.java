package thjug.rr;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;

public class CircleRRNGTest {

    @Test
    public void testEmpty() {
        final RR<String> rr = new CircleRR(Collections.EMPTY_LIST);
        final Option<Route<String>> opt = rr.get();

        assert opt.isEmpty() == true;
    }

    @Test
    public void testGetAll() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new CircleRR(list);
        final Set<Route<String>> set = new HashSet<>();
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());

        assert set.size() == list.size();
    }
    
    @Test
    public void testAllFail() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new CircleRR(list);
        rr.get().get().fail();
        rr.get().get().fail();
        rr.get().get().fail();
        rr.get().get().fail();

        assert rr.get().isEmpty() == true;
    }

}
