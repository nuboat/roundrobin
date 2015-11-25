package thjug.rr;

import org.testng.annotations.Test;

public class RouteNGTest {

    @Test
    public void testGet() {
        final String yo = "Yo";
        final Route<String> route = new Route<>(yo);

        assert route.get() == yo;
    }
    
    @Test
    public void testReset() {
        final Route<String> route = new Route<>("Yo");
        route.reset();

        assert route.getScore() == 10000;
        assert route.isReady() == true;
        assert route.getFailCount() == 0;
    }

    @Test
    public void testFail() {
        final Route<String> route = new Route<>("Yo");
        route.fail();

        assert route.getScore() == 1000;
        assert route.isReady() == false;
        assert route.getFailCount() > 0;
    }

    @Test
    public void testIsReady() {
        final Route<String> route = new Route<>("Yo");
        
        assert route.isReady() == true;
    }

    @Test
    public void testIsSkip() {
        final Route<String> route = new Route<>("Yo");
        route.fail();

        assert route.isSkip() == true;
    }

    @Test
    public void testGetScore() {
        final Route<String> route = new Route<>("Yo");
        route.fail();
        route.fail();
        route.fail();

        assert route.getScore() == 10;
    }

    @Test
    public void testGetFailCount() {
        final Route<String> route = new Route<>("Yo");
        route.fail();
        route.fail();
        route.fail();
        route.fail();

        assert route.getFailCount()== 4;
    }
    
    @Test
    public void testShiftTime() {
        final long shifttime = 1500;
        final Route<String> route = new Route<>("Yo", shifttime);
        route.fail();

        assert (route.getDelay() - (System.currentTimeMillis() + shifttime)) <= 100;
    }


}
