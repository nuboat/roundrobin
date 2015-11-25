package thjug.rr;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;

public class RandomRRNGTest {
   
    @Test
    public void testEmpty() {
        final List<String> list = Collections.EMPTY_LIST;
        final RR<String> rr = new RandomRR<>(list);
        
        assert rr.get().isEmpty() == true;
    }
    
    @Test
    public void testGet() {
        final List<String> list = Arrays.asList("1", "2", "3", "4");
        final RR<String> rr = new RandomRR<>(list);
        
        final Set<Route<String>> set = new HashSet<>();
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());
        set.add(rr.get().get());

        assert set.size() >= list.size() / 2;

    }
    
}
