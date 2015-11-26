 package thjug.rr;

import java.util.Optional;
import org.testng.annotations.Test;

public class OptionNGTest {
    
    @Test
    public void testOf() {
        final Option<String> o = Option.of("");
        
        assert o != null;
    }

    @Test
    public void testEmpty() {
        final Option<String> o = Option.empty();
        
        assert o != null;
    }

    @Test
    public void testGet() {
        final String yo = "Yo";
        final Option<String> o = Option.of(yo);
        
        assert o.get().equals(yo);
    }

    @Test
    public void testIsPresent() {
        final String yo = "Yo";
        final Option<String> o = Option.of(yo);
        
        assert o.isPresent() == true;
    }

    @Test
    public void testIsEmpty() {
        final Option<String> o = Option.empty();
        
        assert o.isEmpty() == true;
    }

    @Test
    public void testToOptional() {
        final Option<String> o = Option.of("Yo");
        final Optional<String> op = o.toOptional();
        
        assert op.isPresent() == true;
    }
    
}
